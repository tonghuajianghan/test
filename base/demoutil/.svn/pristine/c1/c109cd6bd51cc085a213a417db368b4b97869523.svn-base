package cn.edu.cust.util.db;


public abstract class IncrementGenerator {
	
	protected String sql;
	
	public IncrementGenerator(String table, String column){
		StringBuffer select = new StringBuffer();
		select.append("select max(");
		select.append(column);
		select.append(") from ");
		select.append(table);
		sql = select.toString();
	}

}
