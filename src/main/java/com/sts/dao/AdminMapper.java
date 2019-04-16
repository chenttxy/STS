package com.sts.dao;

import com.sts.pojo.Admin;

/**
 * 
 * @ClassName: AdminMapper.java
 * @Description: 管理员
 * @author chentongtong
 * @date: 2019年4月16日 下午2:11:47
 */
public interface AdminMapper {
    
	/**
	 * 管理员登录
	 * @param admin
	 * @return
	 */
	Integer adminLogin(Admin admin);
}