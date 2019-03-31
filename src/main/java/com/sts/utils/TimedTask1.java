package com.sts.utils;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * 
 * @ClassName: TimedTask.java
 * @Description: 定时任务，主要用来后台查询拍卖进度，生成订单
 * @author chentongtong
 * @date: 2019年3月30日 下午10:34:00
 */
public class TimedTask1 {
	
	@Scheduled(cron = "0/5 * * * * ?")  //每隔5秒执行一次定时任务
    public static void consoleInfo(){
        System.out.println("定时任务");
    }
}
