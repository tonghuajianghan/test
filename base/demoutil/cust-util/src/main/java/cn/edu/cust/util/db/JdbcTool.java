package cn.edu.cust.util.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.struts2.ServletActionContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class JdbcTool {

	private static JdbcTemplate jdbcTemplate;
	private static TransactionTemplate transactionTemplate;

	public static void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		JdbcTool.jdbcTemplate = jdbcTemplate;
	}

	public static void setTransactionTemplate(
			TransactionTemplate transactionTemplate) {
		JdbcTool.transactionTemplate = transactionTemplate;
	}

	public static JdbcTemplate getJdbcTemplate() {
		if (jdbcTemplate == null) {
			WebApplicationContext wac = WebApplicationContextUtils
					.getWebApplicationContext(ServletActionContext
							.getServletContext());
			JdbcTemplate jt = (JdbcTemplate) wac.getBean("jdbcTemplate");
			jdbcTemplate = jt;
		}
		return jdbcTemplate;
	}

	public static TransactionTemplate getTransactionTemplate() {
		if (transactionTemplate == null) {
			WebApplicationContext wac = WebApplicationContextUtils
					.getWebApplicationContext(ServletActionContext
							.getServletContext());
			TransactionTemplate tt = (TransactionTemplate) wac
					.getBean("transactionTemplate");
			transactionTemplate = tt;
		}
		return transactionTemplate;
	}

	public static void closeStatement(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception ex) {
				//
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception ex) {
				//
			}
		}
	}

	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (Exception ex) {
				//
			}
		}
	}

}
