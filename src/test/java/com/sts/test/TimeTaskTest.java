package com.sts.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sts.pojo.Preorder;
import com.sts.pojo.Product;
import com.sts.service.OrderService;
import com.sts.service.PreorderService;
import com.sts.service.ProductService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationConfig.xml")
public class TimeTaskTest {
	
	@Autowired
	ProductService productSevice;
	
	@Autowired
	PreorderService perorder;
	
	@Autowired
	OrderService orderService;
	
	@Test
	public void timeTaskTest(){
		List<Product> productList = productSevice.queryListByEndTime();
		synchronized (orderService.createPreorder(productList)) {
		}
	}

}
