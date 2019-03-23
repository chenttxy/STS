package com.sts.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sts.pojo.Product;
import com.sts.pojo.User;
import com.sts.service.ShopcartService;

@Controller
@RequestMapping("shopcart")
public class ShopcartController {
	
	@Autowired
	ShopcartService shopcartService;
	
	@RequestMapping("shopcartList")
	public String shopcartList(HttpServletRequest rq, Model model){
		
		User u = (User) rq.getSession().getAttribute("cur_user");
		
		List<Product> shopcartList = shopcartService.queryByUserId(u.getUserId());
		model.addAttribute("shopcartList", shopcartList);
		
		return "shopcart_list";
	}

}
