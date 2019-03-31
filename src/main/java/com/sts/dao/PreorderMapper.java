package com.sts.dao;

import com.sts.pojo.Preorder;

/**
 * 
 * @ClassName: PreorderMapper.java
 * @Description: 拍卖相关
 * @author chentongtong
 * @date: 2019年3月30日 下午5:58:36
 */
public interface PreorderMapper {
    
	/**
	 * 保存用户的出价
	 * @param preorder
	 * @return
	 */
	Integer savePrice(Preorder preorder);

	/**
	 * 根据商品Id查询出预购表中的最大出价信息
	 * @param goodId
	 * @return
	 */
	Preorder queryMaxMoney(int goodId);
}