
import java.sql.*;
import java.util.*;

/**
 * @author HongTao 2009-9-16
 * JDBC数据库连接类
 * 得到的Arraylist 可以用 Map解析
 * Arraylist ar = db.executeQueryList("select ***")    
 * for(int i=1;i<ar.size;i++)
 *   Map mp = (Map)ar.get(i);
 * mp.get("id");
 * 就是得到了里面的id了
 */
public class DBConnection {
	public static ThreadLocal threadConnection = new ThreadLocal();
	public Connection conn = null;
	public DBConnection() {
	}
	public Connection getMySqlConnection() {
		try {
			Class.forName(Constants.driver);
			conn = DriverManager.getConnection(Constants.url, Constants.name,Constants.password);
			if (conn == null)
				throw new SQLException("Can't connect MsSql!");
//			conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);//设置事务隔离级别 
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public Connection getCurrentConnection() throws SQLException {
		conn = (Connection) threadConnection.get();
		if (conn == null) {
//			System.out.println("--------------打开链接---------------------");
			conn = getMySqlConnection();
			threadConnection.set(conn);
		}
		return conn;
	}

	public Connection getCurrentConnection(boolean isTransaction)
			throws SQLException {
		conn = (Connection) threadConnection.get();
		if (conn == null) {
			conn = getMySqlConnection();
			threadConnection.set(conn);
		}
		if (isTransaction)
			conn.setAutoCommit(false);
		return conn;
	}

	public void closeCurrentConnection() {
		try {
			Connection conn = (Connection) threadConnection.get();
			threadConnection.set(null);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeConnection(Connection conn) throws SQLException {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void beginTransaction() {
		try {
			getCurrentConnection().setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void commitTransaction() {
		try {
			getCurrentConnection().commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void rollbackTransaction() {
		try {
			getCurrentConnection().rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int executeUpdate(String sqlQuery, String sqlValue[])throws Exception {
		int count = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sqlQuery);
			if (sqlValue != null) {
				for (int i = 0; i < sqlValue.length; i++)
					ps.setString(i + 1, sqlValue[i]);
			}
			count = ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		return count;
	}

	//记录数
	public int executeQuery(String sql){
		ResultSet rs = null;
		PreparedStatement ps;
		int count=0;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			rs.next();
			count=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public ArrayList executeQueryList(String sql) {
		Statement st = null;
		ArrayList alResult = new ArrayList();
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			String colum[] = new String[count];
			for (int i = 0; i < colum.length; i++)
				if (rsmd.getColumnName(i + 1) != null)
					colum[i] = rsmd.getColumnName(i + 1);
				else
					colum[i] = rsmd.getColumnLabel(i + 1);

			HashMap hdRow = null;
			String fieldValue = null;
			for (; rs.next(); alResult.add(hdRow)) {
				hdRow = new HashMap();
				for (int i = 0; i < colum.length; i++) {
					int iType = rsmd.getColumnType(i + 1);
					if (iType == 2 || iType == 3) {
						if (rsmd.getScale(i + 1) == 0)
							fieldValue = String.valueOf(rs.getLong(i + 1));
						else
							fieldValue = rs.getString(i + 1);
					} else if (iType == 8)
						fieldValue = String.valueOf(rs.getDouble(i + 1));
					else if (iType == 6 || iType == 7)
						fieldValue = String.valueOf(rs.getFloat(i + 1));
					else
						fieldValue = rs.getString(i + 1);
					if (fieldValue == null)
						fieldValue = "";
					else
						fieldValue = fieldValue.trim();
					hdRow.put(colum[i], fieldValue);//.toLowerCase()
				}
			}
		} catch (Exception e) {}
		return alResult;
	}
	
	public static void main(String arg[]) throws Exception {
		System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqq");
		DBConnection db = new DBConnection();
		db.getCurrentConnection();
		db.closeCurrentConnection();
	}
}
