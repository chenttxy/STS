package com.sts.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

@Controller
@RequestMapping(value="/user/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value="saveUser")
	public String saveUser(User u){
		userService.saveUser(u);
		
		return "user_login";
	}
	
	@RequestMapping(value="login")
	public String login(HttpServletRequest rq, HttpServletResponse rs, User u){
		User user = null;
		user = userService.login(u);
		System.out.println(user+"============");
		if(user != null){
			rq.getSession().setAttribute("cur_user", user);
			
			return "common_index";
		}
		return "user_login";
	}
	
	@RequestMapping(value="checkUsername")
	public void checkUsername(String userName, HttpServletResponse rs){
		
		boolean flag = userService.checkUsername(userName);
		try {
			rs.getWriter().write("{\"flag\":"+flag+"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="checkPhoneNum")
	public void checkPhoneNum(String telephone, HttpServletResponse response){
		
		boolean flag = userService.checkPhoneNum(telephone);
		String json = "{\"flag\":"+flag+"}";
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	
	@RequestMapping(value="sendMsg")
	public void sendMsg(String phoneNum, HttpServletRequest rq){
		System.out.println(phoneNum);
		/*String code = GetMessage.getCode(phoneNum);*/
		rq.getSession().setAttribute("code", "111111");
	}
	
	//对验证码进行验证
	@RequestMapping(value="checkIdentityNum")
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
	public String userHome(@RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo,
							Model model, HttpServletRequest rq){
		
		//根据cid查找商品分类名称
		
		Integer pageSize = 6;//每页显示记录数
        //分页查询
        PageHelper.startPage(pageNo, pageSize);
        
        User u = new User();
        u = (User) rq.getSession().getAttribute("cur_user");
        
    	//根据cid查找该类下的商品列表
        List<Product> productList = userService.queryPublishByUid(u.getUserId());
        
        PageInfo<Product> pageInfo = new PageInfo<Product>(productList);
        
        model.addAttribute("pageInfo", pageInfo);
		
		return "user_home";
	}
	
	@RequestMapping("loginOut")
	public String loginOut(HttpServletRequest rq){
		rq.getSession().removeAttribute("cur_user");
		return "common_index";
	}
	
	@RequestMapping("checkOldPwd")
	public void checkOldPwd(String userPwd, HttpServletResponse response, HttpServletRequest request){
		
		User u = new User();
		u = (User) request.getSession().getAttribute("cur_user");
		
		User user = new User();
		user.setUserId(u.getUserId());
		user.setUserPwd(userPwd);
		
		boolean flag = userService.checkOldPwd(user);
		
		System.out.println(flag+"=============");
		String json = "{\"flag\":"+flag+"}";
		try {
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("updateView")
	public String updateView(){
		
		return "user_update";
	}
}
