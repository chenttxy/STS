package com.sts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.dao.AdminMapper;
import com.sts.pojo.Admin;
import com.sts.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminMapper adminMapper;

	@Override
	public boolean adminLogin(Admin admin) {
		int n = adminMapper.adminLogin(admin);
		boolean flag = false;
		if(n > 0){
			flag = true;
		}
		return flag;
	}

}
