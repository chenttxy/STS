package com.sts.dao;

import java.util.Map;

import com.sts.pojo.Shopcart;

/**
 * 
 * @ClassName: ShopcartMapper.java
 * @Description: 购物车相关接口
 * @author chentongtong
 * @date: 2019年3月23日 下午3:47:28
 */
public interface ShopcartMapper {

	/**
	 * 添加购物车
	 * @param sc
	 * @return
	 */
	Integer addShopcart(Shopcart sc);
	
	/**
	 * 查询该购物项是否已经存在
	 * @param sc
	 * @return
	 */
	Integer queryIsExist(Shopcart sc);

	/**
	 * 当用户点击结算或购买时，删除购物车中的相关项
	 * @param sc
	 * @return
	 */
	Integer deleteShopcart(Shopcart sc);
}