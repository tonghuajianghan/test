package VMware;
import java.sql.*;

public class ConnectSQLserver {
	public static void main(String[] args)throws Exception {
		Connection conn =  DatabaseConnection.getdataConnection();
		try{
			conn.setAutoCommit(false);
		}catch(SQLException e){
				e.printStackTrace();
		}
		Statement stmt = conn.createStatement();
		String sql = "select * from han";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			int i = rs.getInt("id");
			System.out.println(i);
		}
		
		
	}
}
class DatabaseConnection {
	  private static final String DBDRIVER = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
	  private static final String DBURL = "jdbc:microsoft:sqlserver://127.0.0.1:1433/jiang";
	  private static final String DBUSER = "sa";
	  private static final String DBPASSWARD = "123456";
	  public static Connection getdataConnection(){
		
		  try{
			  Class.forName(DBDRIVER);
			  Connection conn =  DriverManager.getConnection(DBURL,DBUSER,DBPASSWARD);//负责管理驱动器程序。方法是静态的
			  System.out.println("数据库连接成功");
			  return conn;
		  }catch(ClassNotFoundException e){
			  e.printStackTrace();
			  System.out.println("驱动错误");
		  }catch(SQLException e){
			  e.printStackTrace();
			  System.out.println("数据库连接失败");
		  }
		  return null;
	  }
	  
	}
