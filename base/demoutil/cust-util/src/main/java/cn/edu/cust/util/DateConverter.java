package cn.edu.cust.util;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter {
	private static Logger log = Logger.getLogger(DateConverter.class);
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");

	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		// TODO Auto-generated method stub
		try{
			log.info("convert from string");
			return format.parse(arg1[0]);
		}catch(Exception ex){
			log.warn(ex.getMessage(), ex);
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map arg0, Object arg1) {
		// TODO Auto-generated method stub
		log.info("convert to string");
		return format.format(arg1);
	}

}
