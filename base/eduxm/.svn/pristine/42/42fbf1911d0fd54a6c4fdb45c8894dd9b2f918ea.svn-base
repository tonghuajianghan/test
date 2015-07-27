package cn.edu.cust.eduxm.project.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class DateConverter implements Converter {
	//"yyyy"必须放在最后，否则会出现错误
	String[] formats = {"yyyy-MM-dd","yyyy.MM","yyyy/MM/dd","yyyy年MM月dd日","yyyy年MM月","yyyy",};

	@Override
	public Object convert(String value) {
		for(String s : formats){
			try {
				SimpleDateFormat df = new SimpleDateFormat(s);
				return df.parse(value);
			} catch (ParseException e) {
//				e.printStackTrace();
			}
		}
		return null;
	}

}
