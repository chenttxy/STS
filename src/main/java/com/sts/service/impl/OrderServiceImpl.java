package com.sts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sts.dao.OrdersMapper;
import com.sts.dao.ProductMapper;
import com.sts.pojo.Orders;
import com.sts.pojo.Product;
import com.sts.service.OrderService;
import com.sts.utils.Constants;

import cn.itcast.commons.CommonUtils;

@Transactional(rollbackFor=Exception.class)  
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	ProductMapper productMapper;
	
	@Autowired
	OrdersMapper ordersMapper;

	@Override
	public String createOrder(Integer userId, String goodId) {
		
		//更改商品状态为已卖出
		Product p = new Product();
		p.setGoodId(Integer.parseInt(goodId));
		p.setGoodStatus(Constants.PRODUCT_SELLED);
		int n = 0;
		n = productMapper.updateGoodStatus(p);
			
		//生成初始订单信息
		Orders orders = new Orders();
		orders.setOrderId(CommonUtils.uuid());
		orders.setUserId(userId);
		orders.setGoodId(Integer.parseInt(goodId));
		
		//根据商品ID查询卖家信息
		Product product = productMapper.queryByGoodId(goodId);
		
		orders.setOrderPrice(product.getGoodPrice());
		orders.setSellerId(product.getUserId());
		orders.setOrderStatus(Constants.ORDER_ADD);
			
		int m = 0;	
		m = ordersMapper.createOrder(orders);
		
		String orderId = null;
		
		if(n > 0 && m > 0){
			orderId = orders.getOrderId();
		}
		return orderId;
	}

	@Override
	public Orders queryOrderById(String orderId) {
		return ordersMapper.queryOrderById(orderId);
	}

	@Override
	public boolean addOrderInfo(Orders order) {
		int n = ordersMapper.ordersMapper(order);
		boolean flag = false;
		if(n > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public List<Orders> queryListByUid(Integer userId) {
		return ordersMapper.queryListByUid(userId);
	}

	@Override
	public boolean orderEvaluation(Orders order) {
		int n = ordersMapper.orderEvaluation(order);
		boolean flag = false;
		if(n > 0){
			flag = true;
		}
		return flag;
	}

}
