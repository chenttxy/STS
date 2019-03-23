package com.sts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sts.pojo.Category;
import com.sts.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	/*@RequestMapping(value="/categoryList.action")
	public @ResponseBody List<Category> getAllCategory(){
		return categoryService.getAllCategory();
	}*/

}
