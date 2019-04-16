package com.sts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sts.pojo.Admin;
import com.sts.pojo.Reporte;
import com.sts.pojo.User;
import com.sts.service.AdminService;
import com.sts.service.ReporteService;
import com.sts.service.UserService;

@Controller
@RequestMapping("/admin/")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ReporteService reporteService;
	
	@RequestMapping("login")
	public String adminLogin(Admin admin){
		boolean flag = adminService.adminLogin(admin);
		if(flag){
			return "admin_manager";
		}
		return "admin_login";
	}
	
	@RequestMapping("userList")
	public String userList(Model model){
		List<User> userList = userService.queryUserList();
		model.addAttribute("userList", userList);
		return "admin_userList";
	}
	
	@RequestMapping("updateUserStatus")
	public String updateUserStatus(String userId, String userStatus, Model model){
		
		User user = new User();
		user.setUserId(Integer.parseInt(userId));
		user.setUserStatus(Integer.parseInt(userStatus));
		userService.updateUserStatus(user);
		
		List<User> userList = userService.queryUserList();
		model.addAttribute("userList", userList);
		return "admin_userList";
	}
	
	@RequestMapping("reportList")
	public String reportList(Model model){
		List<Reporte> reporteList = reporteService.queryList();
		model.addAttribute("reporteList", reporteList);
		return "admin_reportList";
	}
}
