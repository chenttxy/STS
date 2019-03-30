package com.sts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.dao.ProductMapper;
import com.sts.dao.ShopcartMapper;
import com.sts.pojo.Product;
import com.sts.pojo.Shopcart;
import com.sts.service.ShopcartService;

@Service
public class ShopcartServiceImpl implements ShopcartService{
	
	@Autowired
	ShopcartMapper shopcartMapper;
	
	@Autowired
	ProductMapper productMapper;

	@Override
	public List<Product> queryByUserId(Integer userId) {
		return productMapper.queryByUserId(userId);
	}

	@Override
	public boolean addShopcart(Shopcart sc) {
		int n = shopcartMapper.addShopcart(sc);
		boolean flag = false;
		if(n > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public Integer queryIsExist(Shopcart sc) {
		return shopcartMapper.queryIsExist(sc);
	}

	@Override
	public Integer deleteShopcart(Shopcart sc) {
		// TODO Auto-generated method stub
		return shopcartMapper.deleteShopcart(sc);
	}

}
