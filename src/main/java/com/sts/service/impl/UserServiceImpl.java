package com.sts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.dao.UserMapper;
import com.sts.model.User;
import com.sts.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void save(User u) {
		userMapper.insert(u);
	}

}
