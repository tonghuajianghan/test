package cn.edu.cust.eduxm.project;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import cn.edu.cust.eduxm.DataSourceFactory4Test;
import cn.edu.cust.util.db.JdbcTool;

public class ProjectActionTest {
	public static void main(String []args){
		DataSource ds = DataSourceFactory4Test.getDataSource();
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(ds);
		JdbcTool.setJdbcTemplate(jt);
		
		TransactionTemplate tt = new TransactionTemplate();
		tt.setTransactionManager(new DataSourceTransactionManager(ds));
		JdbcTool.setTransactionTemplate(tt);
		ProjectAction p = new ProjectAction();
		p.list();
		//tt.execute(new TransactionCallback<Object>(){
		
	}
}
