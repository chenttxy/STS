package com.sts.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sts.pojo.Product;
import com.sts.pojo.Shopcart;
import com.sts.pojo.User;
import com.sts.service.ShopcartService;

@Controller
@RequestMapping("/shopcart/")
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
	
	@RequestMapping("addShopcart")
	public void addShopcart(String goodId, HttpServletRequest rq, HttpServletResponse rs) throws IOException{
		
		User user = new User();
		user = (User) rq.getSession().getAttribute("cur_user");
		Shopcart sc = new Shopcart();
		
		boolean flag = false;
		
		if(goodId != null && !"".equals(goodId)){
			sc.setUserId(user.getUserId());
			sc.setGoodId(Integer.parseInt(goodId));
			
			//得到goodId以后现在购物车中查询一下是否已经存在在购物车中，如果已经存在，则提示该商品已存在，不要重复添加
			int n = shopcartService.queryIsExist(sc);
			if(n > 0){
				boolean flag1 = true;
				rs.getWriter().write("{\"flag1\":"+flag1+"}");
			} else {
				flag = shopcartService.addShopcart(sc);
				rs.getWriter().write("{\"flag\":"+flag+"}");
			}
		}
	}

}
