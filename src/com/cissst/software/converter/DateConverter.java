package com.cissst.software.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String,Date>{

	Logger log = Logger.getLogger(DateConverter.class);
	
	//日期的模板比如：yyyy-MM-dd
	private String pattern;
	
	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public Date convert(String source) {
		log.debug("pattern is " + pattern);
		Date date = null;
		try{
			SimpleDateFormat sf = new SimpleDateFormat(pattern);
			date = sf.parse(source);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
}