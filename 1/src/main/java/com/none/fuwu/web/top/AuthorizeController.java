package com.none.fuwu.web.top;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taobao.api.internal.util.WebUtils;

/**
 * 
 * @Description:
 * 
 * @author 秋年
 * 
 * @date 2012-8-1 下午3:37:23
 * 
 */
@Controller
public class AuthorizeController {
	
	public static Logger logger = LoggerFactory.getLogger(AuthorizeController.class);

	private String appKey = "515970";

	private String appSecret = "be877ce67853b20812bae6b3de39666d";

	private String redirectUri = "http://10.13.104.29:7788/none/authorize.htm";

	private String tokenUri = "https://oauth.daily.taobao.net/token";

	@RequestMapping(value = "/authorize")
	public String authorize(HttpServletRequest request,
			HttpServletResponse response, HttpSession session, ModelMap context) {
		String error = request.getParameter("error");
		if (StringUtils.isNotBlank(error)) {
			String description = request.getParameter("error_description");
			context.put("error", description);
		}
		try {
			session.setAttribute("access_token", getAccessToken(request));
		} catch (Exception e) {
			logger.error("认证时出现异常", e);
		}
		return "authorize";
	}

	private String getAccessToken(HttpServletRequest request) throws Exception{
		Map<String, String> param = new HashMap<String, String>();
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		param.put("grant_type", "authorization_code");
		param.put("code", code);
		param.put("client_id", appKey);
		param.put("client_secret", appSecret);
		param.put("redirect_uri", redirectUri);
		param.put("scope", "item");
		param.put("view", "web");
		param.put("state", state);
		String responseJson = WebUtils.doPost(tokenUri, param, 3000, 3000);
		JSONObject json = JSONObject.fromObject(responseJson);
		String token = json.getString("access_token");
		return token;
		
	}
}
