package com.none.fuwu.top.core;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;

/**
 * 
 * @Description:
 * 
 * @author ÇïÄê
 * 
 * @date 2012-8-1 ÏÂÎç2:24:02
 * 
 */
public class TopClient{

	private String appKey = "515970";

	private String appSecret = "be877ce67853b20812bae6b3de39666d";

	private String topUrl = "http://api.daily.taobao.net/router/rest";

	private TaobaoClient client = new DefaultTaobaoClient(topUrl, appKey, appSecret);

	public TaobaoClient getClient() {
		return client;
	}

	public void setClient(TaobaoClient client) {
		this.client = client;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getTopUrl() {
		return topUrl;
	}

	public void setTopUrl(String topUrl) {
		this.topUrl = topUrl;
	}

	public String getAppKey() {
		return appKey;
	}

	public String getAppSecret() {
		return appSecret;
	}

}
