package com.sts.service;

import com.sts.pojo.Preorder;

public interface PreorderService {
	
	boolean savePrice(Preorder p);

	Preorder queryMaxMoney(int goodId);

}
