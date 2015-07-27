package cn.edu.cust.util.search;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColumnType {
	
	protected Logger log = LoggerFactory.getLogger(getClass());
	
	public static final ColumnType STRING = new ColumnType();
	
	public static final ColumnType BOOLEAN = new ColumnType(){
		@Override
		public Object getValue(String value) {
			// TODO Auto-generated method stub
			return Boolean.valueOf(value);
		}
	};
	
	public static final ColumnType SHORT = new ColumnType(){
		@Override
		public Object getValue(String value) {
			// TODO Auto-generated method stub
			return Short.valueOf(value);
		}
	};
	
	
	public static final ColumnType INT = new ColumnType(){

		@Override
		public Object getValue(String value) {
			// TODO Auto-generated method stub
			return Integer.valueOf(value);
		}
		
	};
	
	
	public static final ColumnType LONG = new ColumnType(){
		@Override
		public Object getValue(String value) {
			// TODO Auto-generated method stub
			return Long.valueOf(value);
		}
	};
	
	public static final ColumnType FLOAT = new ColumnType(){
		@Override
		public Object getValue(String value) {
			// TODO Auto-generated method stub
			return Float.valueOf(value);
		}
	};
	
	public static final ColumnType DOUBLE = new ColumnType(){
		@Override
		public Object getValue(String value) {
			// TODO Auto-generated method stub
			return Double.valueOf(value);
		}
	};
	
	static SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
	public static final ColumnType DATE = new ColumnType(){
		@Override
		public Object getValue(String value) {
			// TODO Auto-generated method stub
			try{
				log.info("date:{}", value);
				return new Date(df.parse(value).getTime());
			}catch(Exception ex){
				log.warn(ex.getMessage(), ex);
				return null;
			}
		}
	};

	public Object getValue(String value){
		return value;
	}
}
