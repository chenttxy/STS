package com.sts.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sts.dao.UserMapper;
import com.sts.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationConfig.xml")
public class UserTest {
	
	@Autowired
	UserMapper userMapper;

	@Test
	public void checkOldPwd(){
		User user = new User();
		user.setUserId(1);
		user.setUserPwd("111");
		Integer checkOldPwd = userMapper.checkOldPwd(user);
		System.out.println(checkOldPwd);
	}
}
