package com.sts.service;

import java.util.List;

import com.sts.pojo.Product;

public interface ShopcartService {

	List<Product> queryByUserId(Integer userId);
}
