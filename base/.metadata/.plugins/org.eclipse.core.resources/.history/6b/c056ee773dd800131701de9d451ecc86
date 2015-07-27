package cn.edu.cust.eduxm;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataSourceFactory4Test {
	
	public static DataSource ds;
	static{
		DriverManagerDataSource  dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@210.47.0.215:1521:orcl");
		dataSource.setUsername("eduxm");
		dataSource.setPassword("cust_214");
		ds = dataSource;
	}
	
	public static DataSource getDataSource(){
		return ds;
	}
	
	public static JdbcTemplate getJdbcTemplate(){
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(ds);
		return jt;
	}
}
