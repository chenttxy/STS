package com.sts.conversion;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
@Component
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
			return sdf.parse(source);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
