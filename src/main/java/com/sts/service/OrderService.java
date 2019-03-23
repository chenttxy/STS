package com.sts.service;
/**
 * 
 * @ClassName: OrderService.java
 * @Description: 订单的service
 * @author chentongtong
 * @date: 2019年3月23日 下午7:31:43
 */
public interface OrderService {
	
	/**
	 * 点击结算后生成初始订单，更改商品状态为已卖出
	 * @param userId  当前登录人ID，也就是买家
	 * @param goodId  商品ID，根据商品ID查出卖家
	 * @return
	 */
	boolean createOrder(Integer userId, String goodId);
}
