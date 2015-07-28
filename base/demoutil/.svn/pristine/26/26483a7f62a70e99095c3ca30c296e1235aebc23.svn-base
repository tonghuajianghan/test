package cn.edu.cust.util.action;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import cn.edu.cust.util.db.Worker;
public abstract class CommonAction {
	
	public static final String JSON_SUCCESS = "jsonsuccess";
	public static final String JSON_ERROR = "jsonerror";
	
	public static final String SUCCESS = "success";
	public static final String ERROR = "error";

	protected String success = SUCCESS;
	
	protected String error = ERROR;
	
	protected Logger log = Logger.getLogger(getClass());
	
	//protected DataSource ds;
	
	protected String successurl;
	protected String errorurl;
	
	protected String successmsg;
	protected String errormsg;
	
	protected JdbcTemplate jt = new JdbcTemplate();
	protected TransactionTemplate tt = new TransactionTemplate();
	
	protected void init(DataSource ds, JdbcTemplate jt, TransactionTemplate tt){
		jt.setDataSource(ds);
		tt.setTransactionManager(new DataSourceTransactionManager(ds));
	}
	
	public String getSuccessurl() {
		return successurl;
	}

	public String getErrorurl() {
		return errorurl;
	}

	public String getSuccessmsg() {
		return successmsg;
	}

	public String getErrormsg() {
		return errormsg;
	}

	protected String work(Object tc){
		try{
			if(tc instanceof TransactionCallback<?>)
				tt.execute((TransactionCallback<?>)tc);
			else
				((Worker)tc).doWork();
		}catch(Exception ex){
			errormsg = ex.getMessage();
			if(errormsg == null || errormsg.equals("")){
				errormsg = "未知异常";
			}
			log.warn(errormsg, ex);
			return error;
		}
		return success;
	}
}
