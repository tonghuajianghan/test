package cn.edu.cust.util.action;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionCallback;

import cn.edu.cust.util.db.JdbcTool;
import cn.edu.cust.util.db.Worker;

public class CommonAction2 {

	public static final String JSON_SUCCESS = "jsonsuccess";
	public static final String JSON_ERROR = "jsonerror";

	public static final String SUCCESS = "success";
	public static final String ERROR = "error";

	protected String success = SUCCESS;

	protected String error = ERROR;

	protected Logger log = LoggerFactory.getLogger(getClass());

	// protected JdbcTool jdbcTool;

	protected String successurl;
	protected String errorurl;

	protected String successmsg;
	protected String errormsg;

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

	protected boolean isPermitted(String... permissions) {
		boolean permitted = SecurityUtils.getSubject().isPermittedAll(
				permissions);
		if (!permitted) {
			errormsg = "您无权限执行此操作！";
		}
		return permitted;
	}

	protected String work(Object tc, String... permissions) {
		if (permissions.length > 0
				&& !isPermitted(permissions)) {
			return error;
		}
		try {
			if (tc instanceof TransactionCallback<?>)
				JdbcTool.getTransactionTemplate().execute(
						(TransactionCallback<?>) tc);
			else
				((Worker) tc).doWork();
		} catch (Exception ex) {
			errormsg = ex.getMessage();
			if (errormsg == null || errormsg.equals("")) {
				errormsg = "未知异常";
			}
			log.warn(errormsg, ex);
			return error;
		}
		return success;
	}

}
