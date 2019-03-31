package com.sts.service;

import java.util.List;

import com.sts.pojo.Orders;
import com.sts.pojo.Product;

/**
 * 
 * @ClassName: OrderService.java
 * @Description: 订单的service
 * @author chentongtong
 * @date: 2019年3月23日 下午7:31:43
 */
public interface OrderService {
	
	/**
	 * 点击结算后生成初始订单，更改商品状态为已卖出，返回值是生成的初始订单的ID
	 * @param userId  当前登录人ID，也就是买家
	 * @param goodId  商品ID，根据商品ID查出卖家
	 * @return
	 */
	String createOrder(Integer userId, String goodId);
	
	/**
	 * 根据ID查询订单信息
	 * @param orderId
	 * @return
	 */
	Orders queryOrderById(String orderId);

	boolean addOrderInfo(Orders order);
	
	List<Orders> queryListByUid(Integer userId);

	/**
	 * 订单评价
	 * @param order
	 * @return
	 */
	boolean orderEvaluation(Orders order);

	Integer createPreorder(List<Product> productList);
}
