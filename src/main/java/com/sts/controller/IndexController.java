package com.sts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sts.pojo.Product;
import com.sts.service.ProductService;
@Controller
public class IndexController {
	
	@Autowired
	ProductService productService;
	
	/**
	 * 页面首页显示
	 * @param model
	 * @return
	 */
	@RequestMapping("/main")
	public String queryListByTime(@RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo, Model model){
		
		Integer pageSize = 6;//每页显示记录数
        //分页查询
        PageHelper.startPage(pageNo, pageSize);
        List<Product> productList = productService.queryListByTime();
        PageInfo<Product> pageInfo=new PageInfo<Product>(productList);
        model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("categoryName", "最新发布");
		return "main";
	}
	
	@RequestMapping(value="loginView")
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="registerView")
	public String register(){
		return "register";
	}

}
