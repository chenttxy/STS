package com.sts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.dao.ProductMapper;
import com.sts.dao.UserMapper;
import com.sts.pojo.Product;
import com.sts.pojo.User;
import com.sts.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMapper productMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public boolean saveProduct(Product product) {
		int n = 0;
		n = productMapper.saveProduct(product);
		if(n > 0){
			return true;
		}
		return false;
	}

	@Override
	public List<Product> queryListByTime() {
		return productMapper.queryListByTime();
	}

	@Override
	public Product queryInfo(String goodId) {
		productMapper.updateGoodClick(goodId);
		return productMapper.queryByGoodId(goodId);
	}

	@Override
	public List<Product> queryListByCid(String cid) {
		return productMapper.queryListByCid(cid);
	}

	@Override
	public List<Product> queryListByName(String goodName) {
		return productMapper.queryListByName(goodName);
	}

	@Override
	public List<Product> queryListByType() {
		return productMapper.queryListByType();
	}

}
