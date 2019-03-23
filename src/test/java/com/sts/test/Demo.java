package com.sts.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sts.dao.ProductMapper;
import com.sts.pojo.Product;
import com.sts.service.OrderService;
import com.sts.service.ShopcartService;

import cn.itcast.commons.CommonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationConfig.xml")
public class Demo {
	
	@Autowired
	private ShopcartService shopcartService;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private OrderService orderService;
	
	@Test
	/**
	 * 购物车查询测试
	 */
	public void run(){
		
		List<Product> queryByUserId = productMapper.queryByUserId(1);
		System.out.println("===============");
		System.out.println(queryByUserId);
	}
	
	/**
	 * UUID测试
	 */
	@Test
	public void runUUID(){
		System.out.println(CommonUtils.uuid());
	}
	
	@Test
	public void run1(){
		int n = 0;
		System.out.println(n);
	}
	
	@Test
	public void run2(){
		Product p = new Product();
		p.setGoodId(2);
		p.setGoodStatus(5);
		productMapper.updateGoodStatus(p);
	}
	
	/**
	 * 生成初试订单测试
	 */
	@Test
	public void createOrder(){
		boolean createOrder = orderService.createOrder(2, String.valueOf(9));
		System.out.println(createOrder+"==========");
	}
	

}
