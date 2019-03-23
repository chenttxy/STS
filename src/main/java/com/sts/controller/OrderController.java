package com.sts.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;

import com.sts.pojo.User;

@RequestMapping("/orders/")
public class OrderController {

	@RequestMapping("createOrder")
	public String generateOrder(HttpServletRequest rq, String goodId){
		
		//获取当前登录人信息
		User u = (User) rq.getSession().getAttribute("cur_user");
		
		return "order_add";
	}
}
