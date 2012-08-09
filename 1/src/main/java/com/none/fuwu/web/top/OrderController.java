package com.none.fuwu.web.top;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.none.fuwu.top.order.OrderTop;
import com.taobao.api.domain.Order;

/**
 *
 * @Description: 
 *
 * @author ÇïÄê 
 *
 * @date 2012-8-1 ÏÂÎç3:37:23
 *
 */
@Controller
public class OrderController {
	
	@Autowired
	private OrderTop orderTop;
	
	@RequestMapping(value = "/orders")   
	public String authorize(HttpSession session , ModelMap modelMap){
		String sesssionKey = (String)session.getAttribute("access_token");
		try {
			List<Order> orders = orderTop.getOrders(sesssionKey);
			modelMap.put("orders", orders);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "orders";
	}

	public OrderTop getOrderTop() {
		return orderTop;
	}

	public void setOrderTop(OrderTop orderTop) {
		this.orderTop = orderTop;
	}
	
	
}
