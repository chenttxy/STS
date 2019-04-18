package com.sts.dao;

import java.util.List;

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
	
	/**
	 * 用户修改个人信息时验证原密码
	 * @param userId
	 * @param userPwd
	 * @return
	 */
	Integer checkOldPwd(User user);

	/**
	 * 根据用户ID查询用户信息
	 * @param userId
	 * @return
	 */
	User queryByUid(Integer userId);

	/**
	 * 管理员查询用户列表
	 * @return
	 */
	List<User> queryUserList();
	
	/**
	 * 管理员更改用户状态
	 * @param userId
	 * @param userStatus
	 * @return
	 */
	Integer updateUserStatus(User user);

	/**
	 * 用户修改密码
	 * @param u
	 * @return
	 */
	Integer updateUserPwd(User u);
	
}