package com.sts.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sts.pojo.Product;
import com.sts.pojo.User;
import com.sts.service.ProductService;
import com.sts.service.UserService;
import com.sts.utils.GetMessage;

@Controller
@RequestMapping(value="/user/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="saveUser.action")
	public String saveUser(User u){
		userService.saveUser(u);
		
		return "login";
	}
	
	@RequestMapping(value="login.action")
	public String login(HttpServletRequest rq, HttpServletResponse rs, User u){
		User user = null;
		user = userService.login(u);
		System.out.println(user+"============");
		if(user != null){
			rq.getSession().setAttribute("cur_user", user);
			
			return "main";
		}
		return "login";
	}
	
	@RequestMapping(value="checkUsername.action")
	public void checkUsername(String userName, HttpServletResponse rs){
		
		boolean flag = userService.checkUsername(userName);
		try {
			rs.getWriter().write("{\"flag\":"+flag+"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="checkPhoneNum.action")
	public void checkPhoneNum(String telephone, HttpServletResponse response){
		
		boolean flag = userService.checkPhoneNum(telephone);
		String json = "{\"flag\":"+flag+"}";
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	
	@RequestMapping(value="sendMsg.action")
	public void sendMsg(String phoneNum, HttpServletRequest rq){
		System.out.println(phoneNum);
		/*String code = GetMessage.getCode(phoneNum);*/
		rq.getSession().setAttribute("code", "111111");
	}
	
	//对验证码进行验证
	@RequestMapping(value="checkIdentityNum.action")
	public void checkIdentityNum(String identityNum, HttpServletRequest request, HttpServletResponse response){
		System.out.println("identityNum"+identityNum);
		String code = (String) request.getSession().getAttribute("code");
		System.out.println("code"+code);
		boolean flag = false;
		if(code.equals(identityNum)){
			flag = true;
		}
		System.out.println(flag);
		String json = "{\"flag\":"+flag+"}";
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("userHome")
	public String userHome(){
		
		return "user_home";
	}
}
