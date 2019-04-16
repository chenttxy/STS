package com.sts.dao;

import java.util.List;

import com.sts.pojo.Reporte;

/**
 * 
 * @ClassName: ReporteMapper.java
 * @Description: 举报信息相关
 * @author chentongtong
 * @date: 2019年4月16日 下午6:34:26
 */
public interface ReporteMapper {
    
	/**
	 * 管理员查询所有举报信息
	 * @return
	 */
	List<Reporte> queryList();
}