package com.sts.service;

import java.util.List;

import com.sts.pojo.Product;

public interface ProductService {

	/*void saveProduct(Product product);*/

	List<Product> queryListByTime();

	Product queryInfo(String goodId);

	List<Product> queryListByCid(String cid);
	
	List<Product> queryListByName(String goodName);
	
}
