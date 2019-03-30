package com.sts.service;

import java.util.List;

import com.sts.pojo.Product;
import com.sts.pojo.Shopcart;

public interface ShopcartService {

	List<Product> queryByUserId(Integer userId);

	boolean addShopcart(Shopcart sc);
	
	Integer queryIsExist(Shopcart sc);

	Integer deleteShopcart(Shopcart sc);
}
