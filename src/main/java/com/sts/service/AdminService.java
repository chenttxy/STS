package com.sts.service;

import com.sts.pojo.Admin;

/**
 * 
 * @ClassName: AdminService.java
 * @Description: 管理员
 * @author chentongtong
 * @date: 2019年4月16日 下午2:15:38
 */
public interface AdminService {

	/**
	 * 管理员登录
	 * @param admin
	 * @return
	 */
	boolean adminLogin(Admin admin);
}
