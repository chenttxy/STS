package com.sts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.dao.ReporteMapper;
import com.sts.pojo.Reporte;
import com.sts.service.ReporteService;
@Service
public class ReporteServiceImpl implements ReporteService {
	
	@Autowired
	ReporteMapper reporteMapper;

	@Override
	public List<Reporte> queryList() {
		return reporteMapper.queryList();
	}

	@Override
	public boolean addReporte(Reporte reporte) {
		boolean flag = false;
		int n = reporteMapper.addReporte(reporte);
		if(n > 0){
			flag = true;
		}
		return flag;
	}

}
