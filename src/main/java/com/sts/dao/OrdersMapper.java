package com.sts.dao;

import java.util.List;

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
	 * 返回值为生成的orderId
	 * @param order
	 * @return
	 */
	Integer createOrder(Orders order);
	
	/**
	 * 根据orderId查询订单
	 * @param orderId
	 * @return
	 */
	Orders queryOrderById(String orderId);

	/**
	 * 补充订单详细信息
	 * @param order
	 * @return
	 */
	Integer ordersMapper(Orders order);

	/**
	 * 根据用户ID查询订单列表
	 * @param userId
	 * @return
	 */
	List<Orders> queryListByUid(Integer userId);

	/**
	 * 评价订单
	 * @param order
	 * @return
	 */
	Integer orderEvaluation(Orders order);
    
}