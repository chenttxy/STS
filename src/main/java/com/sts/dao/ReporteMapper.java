package com.sts.dao;

import com.sts.model.Reporte;
import com.sts.model.ReporteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReporteMapper {
    int countByExample(ReporteExample example);

    int deleteByExample(ReporteExample example);

    int deleteByPrimaryKey(Integer reporteId);

    int insert(Reporte record);

    int insertSelective(Reporte record);

    List<Reporte> selectByExample(ReporteExample example);

    Reporte selectByPrimaryKey(Integer reporteId);

    int updateByExampleSelective(@Param("record") Reporte record, @Param("example") ReporteExample example);

    int updateByExample(@Param("record") Reporte record, @Param("example") ReporteExample example);

    int updateByPrimaryKeySelective(Reporte record);

    int updateByPrimaryKey(Reporte record);
}