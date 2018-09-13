package com.cissst.software.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;

public class DateConverter2 implements Converter<String,Date>{

	@Override
	public Date convert(String source) {
		/*
		 * ���ַ�ʽ:�̶�
		 */
		Logger log = Logger.getLogger(DateConverter2.class);
		log.debug("source is " + source);
		Date date = null;
		source.contains("-"); //��ʽ������xxxx-xx-xx��ʽ��
		SimpleDateFormat sf = null;
		if(source.contains("-")){
			sf = new SimpleDateFormat("yyyy-MM-dd");
		}
		else{
			sf = new SimpleDateFormat("yyyy/MM/dd");
		}
		try {
			date = sf.parse(source);
		} catch (ParseException e) { //��������
			e.printStackTrace();
		}
		return date;
	}
}
