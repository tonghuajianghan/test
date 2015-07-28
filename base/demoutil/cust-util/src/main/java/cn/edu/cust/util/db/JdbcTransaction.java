package cn.edu.cust.util.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class JdbcTransaction {
	
	private static Logger log = Logger.getLogger(JdbcTransaction.class);
	
	private Connection con;

	private boolean toggleAutoCommit;
	private boolean begun;
	private boolean rolledBack;
	private boolean committed;
	private boolean commitFailed;

	public JdbcTransaction(Connection con){
		this.con = con;
	}
	
	
	public void begin() throws TransactionException {
		if (begun) {
			return;
		}
		if (commitFailed) {
			throw new TransactionException(
					"cannot re-start transaction after failed commit");
		}

		log.debug("begin");
		try {
			toggleAutoCommit = con.getAutoCommit();

			if (toggleAutoCommit) {
				log.debug("disabling autocommit");
				con.setAutoCommit(false);
			}
		} catch (SQLException e) {
			throw new TransactionException("JDBC begin failed: ", e);
		}

		begun = true;
		committed = false;
		rolledBack = false;

	}
	
	
	public void commit() throws TransactionException {
		if (!begun) {
			throw new TransactionException(
					"Transaction not successfully started");
		}

		log.debug("commit");

		try {
			commitAndResetAutoCommit();
			log.debug("committed JDBC Connection");
			committed = true;
		} catch (SQLException e) {
			commitFailed = true;

			throw new TransactionException("JDBC commit failed", e);
		}
	}
	
	private void commitAndResetAutoCommit() throws SQLException {
		try {
			con.commit();
		} finally {
			toggleAutoCommit();
		}
	}
	
	
	public void rollback() throws TransactionException {
		if ((!begun) && (!commitFailed)) {
			throw new TransactionException(
					"Transaction not successfully started");
		}

		log.debug("rollback");

		if (commitFailed) {
			return;
		}

		try {
			rollbackAndResetAutoCommit();
			log.debug("rolled back JDBC Connection");
			rolledBack = true;
		} catch (SQLException e) {
			throw new TransactionException("JDBC rollback failed", e);
		}
	}
	
	public boolean isActive() {
		return (begun) && (!rolledBack) && (!((committed | commitFailed)));
	}

	private void rollbackAndResetAutoCommit() throws SQLException {
		try {
			con.rollback();
		} finally {
			toggleAutoCommit();
		}
	}

	private void toggleAutoCommit() {
		try {
			if (toggleAutoCommit) {
				log.debug("re-enabling autocommit");
				con.setAutoCommit(true);
			}
		} catch (Exception sqle) {
			log.error("Could not toggle autocommit", sqle);
		}
	}

}
