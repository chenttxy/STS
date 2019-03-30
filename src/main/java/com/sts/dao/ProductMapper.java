package com.sts.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.sts.pojo.Product;

/**
 * 
 * @ClassName: ProductMapper.java
 * @Description: 商品相关的接口
 * @author chentongtong
 * @date: 2019年3月22日 下午12:12:44
 */
public interface ProductMapper {
    
	/**
	 * 根据发布时间查找商品列表
	 * @return
	 */
    List<Product> queryListByTime();

    /**
     * 根据商品类别查询商品列表
     * @param cid
     * @return
     */
	List<Product> queryListByCid(String cid);
	
	/**
	 * 根据商品名字模糊查询商品列表
	 * @param goodName
	 * @return
	 */
	List<Product> queryListByName(String goodName);
	
	/**
	 * 根据商品ID查询商品详细信息
	 * @param goodId
	 * @return
	 */
	Product queryByGoodId(String goodId);
	
	/**
	 * 根据当前登录人信息查询当前登录人购物车相关信息
	 * @param userId
	 * @return
	 */
	List<Product> queryByUserId(Integer userId);
	
	/**
	 * 更改商品状态
	 * @param product
	 * @return
	 */
	Integer updateGoodStatus(Product product);
	
	/**
	 * 发布二手商品
	 * @param product
	 * @return
	 */
	Integer saveProduct(Product product);
	
	/**
	 * 查询用户发布的二手商品
	 * @param userId
	 * @return
	 */
	List<Product> queryPublishByUid(Integer userId);

	/**
	 * 当用户点击商品详情后，更新商品的点击次数
	 * @param goodId
	 */
	void updateGoodClick(String goodId);
	
	/**
	 * 查询热门拍卖商品
	 * @return
	 */
	List<Product> queryListByType();
	
}