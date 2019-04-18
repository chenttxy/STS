package com.sts.service;

import java.util.List;

import com.sts.pojo.Product;
import com.sts.pojo.User;

public interface UserService {
	
	boolean saveUser(User u);

	boolean checkUsername(String username);

	boolean checkPhoneNum(String telephone);

	User login(User u);
	
	List<Product> queryPublishByUid(Integer userId);

	boolean checkOldPwd(User user);
	
	User queryByUid(Integer userId);

	List<User> queryUserList();

	boolean updateUserStatus(User user);

	boolean updateUserPwd(User u);
 
}
