package com.sts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.dao.PreorderMapper;
import com.sts.pojo.Preorder;
import com.sts.service.PreorderService;
@Service
public class PreorderServiceImpl implements PreorderService {
	
	@Autowired
	PreorderMapper preorderMapper;

	@Override
	public boolean savePrice(Preorder p) {
		int n = preorderMapper.savePrice(p);
		boolean flag = false;
		if(n > 0){
			flag = true;
		}
		return flag;
	}

	@Override
	public Preorder queryMaxMoney(int goodId) {
		return preorderMapper.queryMaxMoney(goodId);
	}

}
