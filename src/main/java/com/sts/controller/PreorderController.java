package com.sts.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sts.pojo.Preorder;
import com.sts.pojo.User;
import com.sts.service.PreorderService;

@Controller
@RequestMapping("/preorder/")
public class PreorderController {

	@Autowired
	PreorderService preorderService;
	
	@RequestMapping("savePrice")
	public void savePrice(@ModelAttribute Preorder preorder, HttpServletResponse rs, HttpServletRequest rq) throws IOException{
		
		User user = new User();
		user = (User) rq.getSession().getAttribute("cur_user");
		preorder.setUserId(user.getUserId());
		boolean flag = preorderService.savePrice(preorder);
		rs.getWriter().write("{\"flag\":"+flag+"}");
	}
}
