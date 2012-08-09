package com.none.fuwu.web.top;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.none.fuwu.top.order.LogisticsTop;

/**
 *
 * @Description: 
 *
 * @author ÇïÄê 
 *
 * @date 2012-8-3 ÏÂÎç3:10:49
 *
 */
@Controller
public class DeliverController {

	@Autowired
	private LogisticsTop logisticsTop; 
	
	
	@RequestMapping(value="/send", method = RequestMethod.POST)  
	public @ResponseBody String delivery(HttpServletRequest request,
			HttpServletResponse response, HttpSession session){
		
		try {
			String sesssionKey = (String)session.getAttribute("access_token");
			
			String tid = request.getParameter("tid");
			
			String outId = request.getParameter("outId");
			
			boolean result = logisticsTop.deliveryConfirm(sesssionKey, Long.valueOf(tid) , outId);
			if(result){
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";
	}

	public LogisticsTop getLogisticsTop() {
		return logisticsTop;
	}

	public void setLogisticsTop(LogisticsTop logisticsTop) {
		this.logisticsTop = logisticsTop;
	}
	
	
}
