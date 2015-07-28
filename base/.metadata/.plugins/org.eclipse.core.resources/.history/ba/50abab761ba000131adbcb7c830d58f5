package cn.edu.cust.demo.util;

public class MySqlPage extends Page {

	@Override
	public String getLimitString(String sql) {
		// TODO Auto-generated method stub
		StringBuffer sqlbuf = new StringBuffer();
		sqlbuf.append(sql);
		sqlbuf.append(" limit ");
		sqlbuf.append(getOffset());
		sqlbuf.append(", ");
		sqlbuf.append(getLimit());
		return sqlbuf.toString();
	}

}
