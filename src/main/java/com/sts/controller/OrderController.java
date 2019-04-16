package com.sts.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sts.pojo.Orders;
import com.sts.pojo.Shopcart;
import com.sts.pojo.User;
import com.sts.service.OrderService;
import com.sts.service.ShopcartService;
import com.sts.utils.Constants;

@RequestMapping("/orders/")
@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ShopcartService shopcartService;

	@RequestMapping("createOrder")
	public String generateOrder(HttpServletRequest rq, String goodId, Model model){
		
		//获取当前登录人信息
		User u = (User) rq.getSession().getAttribute("cur_user");
		
		//当用户点击结算或购买时，先查询购物车中是否存在该项商品的信息，如果存在，则删除购物车相关的信息
		Shopcart sc = new Shopcart();
		sc.setGoodId(Integer.parseInt(goodId));
		sc.setUserId(u.getUserId());
		int isExist = shopcartService.queryIsExist(sc);
		if(isExist > 0){
			shopcartService.deleteShopcart(sc);
		}
		
		//获取初始订单的OrderId
		String orderId = null;
		
		//这一步创建订单，返回创建订单生成的orderId
		orderId = orderService.createOrder(u.getUserId(), goodId);
		if(orderId != null && !"".equals(orderId)){
			Orders o = new Orders();
			o = orderService.queryOrderById(orderId);
			model.addAttribute("orderInfo", o);
			return "order_add";
		}
		return "common_error";
	}
	
	@RequestMapping("addOrderInfo")
	public String addOrderInfo(Orders order){
		order.setOrderStatus(Constants.ORDER_UNDONE);
		boolean flag = orderService.addOrderInfo(order);
		if(flag){
			return "order_index";
		}
		return "common_error";
	}
	
	@RequestMapping("orderEvaluation")
	public String orderEvaluation(Orders order){
		order.setOrderStatus(Constants.ORDER_FINISH);
		boolean flag = orderService.orderEvaluation(order);
		if(flag){
			return "order_index";
		}
		return "common_error";
	}
	
	@RequestMapping("orderList")
	public String orderList(HttpServletRequest rs, Model model){
		User user = new User();
		user = (User) rs.getSession().getAttribute("cur_user");
		List<Orders> orderList = orderService.queryListByUid(user.getUserId());
		
		List<Orders> orderList1 = new ArrayList<Orders>();
		List<Orders> orderList2 = new ArrayList<Orders>();
		List<Orders> orderList3 = new ArrayList<Orders>();
		
		for (Orders order : orderList) {
			if(order.getOrderStatus() == 1){
				orderList1.add(order);
			}else if(order.getOrderStatus() == 2){
				orderList2.add(order);
			}else if(order.getOrderStatus() == 3){
				orderList3.add(order);
			}
		}
		
		model.addAttribute("orderList1", orderList1);
		model.addAttribute("orderList2", orderList2);
		model.addAttribute("orderList3", orderList3);
		return "order_list";
	}
}
