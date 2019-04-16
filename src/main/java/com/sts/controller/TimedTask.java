package com.sts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.sts.pojo.Orders;
import com.sts.pojo.Preorder;
import com.sts.pojo.Product;
import com.sts.service.OrderService;
import com.sts.service.PreorderService;
import com.sts.service.ProductService;
import com.sts.utils.Constants;

import cn.itcast.commons.CommonUtils;

/**
 * 
 * @ClassName: TimedTask.java
 * @Description: 定时任务，主要用来后台查询拍卖进度，生成订单
 * @author chentongtong
 * @date: 2019年3月30日 下午10:34:00
 */
@Controller
public class TimedTask {
	
	@Autowired
	ProductService productSevice;
	
	@Autowired
	PreorderService perorderService;
	
	@Autowired
	OrderService orderService;
	
	@Scheduled(cron = "0/60 * * * * ?")  //每隔60秒执行一次定时任务
    public synchronized void createPreorder(){
		List<Product> productList = productSevice.queryListByEndTime();
		Integer n = orderService.createPreorder(productList);
		System.out.println("执行结果==========="+n);
	}
}
