package cn.edu.cust.eduxm.expert;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import cn.edu.cust.eduxm.DataSourceFactory4Test;
import cn.edu.cust.eduxm.expert.dao.ExpertDAO;
import cn.edu.cust.eduxm.expert.domain.Expert;
import cn.edu.cust.util.db.JdbcTool;

public class ExpertActionTest {
	public static void main(String args[]){
		DataSource ds = DataSourceFactory4Test.getDataSource();
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(ds);
		JdbcTool.setJdbcTemplate(jt);
		
		TransactionTemplate tt = new TransactionTemplate();
		tt.setTransactionManager(new DataSourceTransactionManager(ds));
		JdbcTool.setTransactionTemplate(tt);
		Expert e=new Expert();
	
		e.setUsername("555555555555555555");


		ExpertAction ea=new ExpertAction();
		ExpertDAO dao=new ExpertDAO();
		ea.setDao(dao);
		ea.setObj(e);
		ea.load();
	
		
	}
}
