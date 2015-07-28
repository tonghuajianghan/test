package cn.edu.cust.util.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface ParamSetter {
	
	public void setParams(PreparedStatement ps) throws SQLException;

}
