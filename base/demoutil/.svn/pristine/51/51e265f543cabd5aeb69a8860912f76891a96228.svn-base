package cn.edu.cust.util.db;

import org.springframework.jdbc.core.JdbcTemplate;

public class IntGenerator extends IncrementGenerator {
	
	private int value;
	
	public IntGenerator(String table, String column){
		super(table, column);
	}
	
	public synchronized int next(JdbcTemplate jt) {
		if(sql != null){
			value = jt.queryForInt(sql);
			sql = null;
		}
		value++;
		return value;
	}

}
