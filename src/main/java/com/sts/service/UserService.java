package com.sts.service;

import com.sts.pojo.User;

public interface UserService {
	
	boolean saveUser(User u);

	boolean checkUsername(String username);

	boolean checkPhoneNum(String telephone);

	User login(User u);

}
