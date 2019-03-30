package com.sts.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sts.dao.OrdersMapper;
import com.sts.pojo.Orders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationConfig.xml")
public class OrdersTest {
	
	@Autowired
	OrdersMapper ordersMapper;
	
	@Test
	public void queryById(){
		Orders orders = ordersMapper.queryOrderById("22E9A080903C4EFEB6381569D76BD534");
		orders.setOrderId("2222222222222222");
		Integer string = ordersMapper.createOrder(orders);
		System.out.println(string);
	}

}
