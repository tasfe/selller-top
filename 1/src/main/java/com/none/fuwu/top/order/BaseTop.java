package com.none.fuwu.top.order;

import com.none.fuwu.top.core.TopClient;
import com.taobao.api.TaobaoClient;

/**
 * 
 * @Description:
 * 
 * @author ����
 * 
 * @date 2012-8-1 ����2:34:33
 * 
 */
public class BaseTop {

	protected TopClient topClient;
	
	public TaobaoClient getClient(){
		return topClient.getClient();
	}

	public TopClient getTopClient() {
		return topClient;
	}

	public void setTopClient(TopClient topClient) {
		this.topClient = topClient;
	}
	
	

}
