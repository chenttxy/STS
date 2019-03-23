package com.sts.dao;

import com.sts.pojo.User;

public interface UserMapper {

    //验证用户名是否存在
	Integer checkUsername(String username);
	
	//验证用户手机是否被注册
	Integer checkPhoneNum(String telephone);
	
	//用户登录
	User login(User u);
	
	/**
	 * 用户注册
	 */
	Integer saveUser(User u);
	
}