package com.sts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.dao.CategoryMapper;
import com.sts.pojo.Category;
import com.sts.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryMapper categoryMapper;

	/*@Override
	public List<Category> getAllCategory() {
		return categoryMapper.selectByExample(null);
	}*/

	@Override
	public String queryCNameByCid(String cid) {
		return categoryMapper.queryCNameByCid(cid);
	}

}
