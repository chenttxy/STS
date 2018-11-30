package com.sts.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sts.model.User;
import com.sts.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationConfig.xml")
public class Demo {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void run(){
		User u = new User();
		u.setUserName("张三");
		u.setUserPhone("11111111111");
		u.setUserPwd("111");
		userService.save(u);
		
	}

}
