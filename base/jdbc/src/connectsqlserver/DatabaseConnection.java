package connectsqlserver;

import java.sql.*;

public class DatabaseConnection {
  private static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
  private static final String DBURL = "jdbc:microsoft:sqlserver://localhost:1433/jiang";
  private static final String DBUSER = "sa";
  private static final String DBPASSWARD = "123";
  public static Connection getdataConnection(){
	
	  try{
		  Class.forName(DBDRIVER);
		  Connection conn =  DriverManager.getConnection(DBURL,DBUSER,DBPASSWARD);//负责管理驱动器程序。方法是静态的
		  System.out.println("数据库连接成功");
		  return conn;
	  }catch(ClassNotFoundException e){
		  e.printStackTrace();
		  System.out.print("驱动加载失败");
	  }catch(SQLException e){
		  e.printStackTrace();
		  System.out.println("数据库未连接成功");
	  }
	  return null;
  }
  
}