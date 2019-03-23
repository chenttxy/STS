package com.sts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.dao.UserMapper;
import com.sts.pojo.User;
import com.sts.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean checkUsername(String username) {
		Integer n = userMapper.checkUsername(username);
		boolean flag = false;
		if(n > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean checkPhoneNum(String telephone) {
		Integer n = userMapper.checkPhoneNum(telephone);
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

}
