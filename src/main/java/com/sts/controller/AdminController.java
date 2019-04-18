package com.sts.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sts.pojo.Admin;
import com.sts.pojo.Product;
import com.sts.pojo.Reporte;
import com.sts.pojo.User;
import com.sts.service.AdminService;
import com.sts.service.ProductService;
import com.sts.service.ReporteService;
import com.sts.service.UserService;
import com.sts.utils.Constants;

@Controller
@RequestMapping("/admin/")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ReporteService reporteService;
	
	@Autowired
	ProductService productService;
	
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
		for (int i = 0; i < reporteList.size(); i ++) {
			//根据商品ID查询出商品状态，如果为非正常状态则不显示
			String goodId = String.valueOf(reporteList.get(i).getGoodId());
			Product product = productService.queryInfo(goodId);
			if(product.getGoodStatus() != 1){
				reporteList.remove(i);
			}
		}
		model.addAttribute("reporteList", reporteList);
		return "admin_reportList";
	}
	
	@RequestMapping("queryGoodStatus")
	public void queryGoodStatus(String goodId, HttpServletResponse rs){
		Product product = productService.queryInfo(goodId);
		int flag = product.getGoodStatus();
		try {
			rs.getWriter().write("{\"flag\":"+flag+"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("updateGoodStatus")
	public void updateGoodStatus(String goodId, HttpServletResponse rs){
		Product product = new Product();
		product.setGoodId(Integer.parseInt(goodId));
		product.setGoodStatus(Constants.PRODUCT_LOCKED);
		boolean flag = productService.updateGoodStatus(product);
		try {
			rs.getWriter().write("{\"flag\":"+flag+"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
