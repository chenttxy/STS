package com.sts.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sts.conversion.DateConverter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationConfig.xml")
public class DateTest {

	
	@Test
	public void DateTest(){
		String source = "2019-03-15T21:22";
		DateConverter dc = new DateConverter();
		System.out.println(dc.convert(source));
	}
}
