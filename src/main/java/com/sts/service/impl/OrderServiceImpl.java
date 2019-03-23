package com.sts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.dao.OrdersMapper;
import com.sts.dao.ProductMapper;
import com.sts.pojo.Orders;
import com.sts.pojo.Product;
import com.sts.service.OrderService;
import com.sts.utils.Constants;
import cn.itcast.commons.CommonUtils;
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	ProductMapper productMapper;
	
	@Autowired
	OrdersMapper ordersMapper;

	@Override
	public boolean createOrder(Integer userId, String goodId) {
		
		boolean flag = false;
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
			
		int a = 0;	
		a = ordersMapper.createOrder(orders);
		if(a > 0 && n > 0){
			flag = true;
		}
		
		return flag;
	}

}
