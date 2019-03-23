package com.sts.dao;

import com.sts.pojo.Orders;

/**
 * 
 * @ClassName: OrdersMapper.java
 * @Description: 订单相关方法
 * @author chentongtong
 * @date: 2019年3月23日 下午8:34:06
 */
public interface OrdersMapper {
	
	/**
	 * 当用户点击结算后生成的初始订单
	 * @param order
	 * @return
	 */
	Integer createOrder(Orders order);
    
}