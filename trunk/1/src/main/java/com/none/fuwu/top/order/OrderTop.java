package com.none.fuwu.top.order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.taobao.api.domain.Order;
import com.taobao.api.domain.Trade;
import com.taobao.api.request.TradesSoldIncrementGetRequest;
import com.taobao.api.response.TradesSoldIncrementGetResponse;

/**
 *
 * @Description: 订单的TOP接口
 *
 * @author 秋年 
 *
 * @date 2012-8-1 下午2:23:27
 *
 */
public class OrderTop extends BaseTop{
	
	public List<Order> getOrders(String sessionKey) throws Exception{
		List<Order> orders =  new ArrayList<Order>();
		
		TradesSoldIncrementGetRequest req = new TradesSoldIncrementGetRequest();
		req.setFields("tid,num,receiver_name,type,status,price,title,modified,receiver_state,receiver_city,receiver_district,receiver_address,receiver_mobile,orders.oid");
		Date dateTime = SimpleDateFormat.getDateTimeInstance().parse("2012-08-08 00:00:00");
		req.setStartModified(dateTime);
		Date endTime = SimpleDateFormat.getDateTimeInstance().parse("2012-08-08 24:00:00");
		req.setEndModified(endTime);
		req.setStatus("WAIT_SELLER_SEND_GOODS");
		req.setType("fixed");
		req.setPageNo(1L);
		req.setPageSize(40L);
		req.setUseHasNext(true);
		
		TradesSoldIncrementGetResponse response = this.getClient().execute(req,sessionKey);
		
		if(response.getTrades() != null && response.getTrades().size() > 0){
			for (Trade trade : response.getTrades()) {
				orders.addAll(trade.getOrders());
			}
		}
		return orders;
	}
}
 