package com.sts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.dao.ProductMapper;
import com.sts.pojo.Product;
import com.sts.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMapper productMapper;
	
	/*@Override
	public void saveProduct(Product product) {
		productMapper.insert(product);
	}*/

	@Override
	public List<Product> queryListByTime() {
		return productMapper.queryListByTime();
	}

	@Override
	public Product queryInfo(String goodId) {
		// TODO Auto-generated method stub
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

}
