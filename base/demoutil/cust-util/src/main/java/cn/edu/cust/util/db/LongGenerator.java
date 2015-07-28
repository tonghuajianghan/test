package cn.edu.cust.util.db;

import org.springframework.jdbc.core.JdbcTemplate;

public class LongGenerator extends IncrementGenerator {
	
	private long value;
	
	public LongGenerator(String table, String column){
		super(table, column);
	}
	
	public synchronized long next(JdbcTemplate jt) {
		if(sql != null){
			value = jt.queryForLong(sql);
			sql = null;
		}
		value++;
		return value;
	}

}
