package com.none.fuwu.top.order;

import com.taobao.api.domain.Shipping;
import com.taobao.api.request.LogisticsOfflineSendRequest;
import com.taobao.api.response.LogisticsOfflineSendResponse;

/**
 *
 * @Description: 
 *
 * @author ÇïÄê 
 *
 * @date 2012-8-3 ÏÂÎç3:06:30
 *
 */
public class LogisticsTop extends BaseTop {

	public boolean deliveryConfirm(String sessionKey , Long tid , String outId ) throws Exception{
		LogisticsOfflineSendRequest req=new LogisticsOfflineSendRequest();
		req.setTid(tid);
		req.setOutSid(outId);
		req.setCompanyCode("POST");
		LogisticsOfflineSendResponse response = this.getClient().execute(req , sessionKey);
		
		Shipping shipping = response.getShipping();
		return shipping.getIsSuccess();
	}
}
