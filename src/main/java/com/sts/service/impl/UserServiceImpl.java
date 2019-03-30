package com.sts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.dao.ProductMapper;
import com.sts.dao.UserMapper;
import com.sts.pojo.Product;
import com.sts.pojo.User;
import com.sts.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private ProductMapper productMapper;

	@Override
	public boolean checkUsername(String username) {
		int n = userMapper.checkUsername(username);
		boolean flag = false;
		if(n > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean checkPhoneNum(String telephone) {
		int n = userMapper.checkPhoneNum(telephone);
		boolean flag = false;
		if(n > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public User login(User u) {
		return userMapper.login(u);
	}

	@Override
	public boolean saveUser(User u) {
		Integer n = userMapper.saveUser(u);
		boolean flag = false;
		if(n > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public List<Product> queryPublishByUid(Integer userId) {
		return productMapper.queryByUserId(userId);
	}

	@Override
	public boolean checkOldPwd(User user) {
		int n =  userMapper.checkOldPwd(user);
		boolean flag = false;
		if(n > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public User queryByUid(Integer userId) {
		return userMapper.queryByUid(userId);
	}

}
