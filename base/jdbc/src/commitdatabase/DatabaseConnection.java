package commitdatabase;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
  private static final String DBDRIVER = "com.mysql.jdbc.Driver";
  private static final String DBURL = "jdbc:mysql://127.0.0.1:3306/excite";
  private static final String DBUSER = "root";
  private static final String DBPASSWARD = "123";
  public static Connection getdataConnection(){
	
	  try{
		  Class.forName(DBDRIVER);
		  Connection conn =  DriverManager.getConnection(DBURL,DBUSER,DBPASSWARD);//����������������򡣷����Ǿ�̬��
		  System.out.println("���ݿ����ӳɹ�");
		  return conn;
	  }catch(ClassNotFoundException e){
		  e.printStackTrace();
	  }catch(SQLException e){
		  e.printStackTrace();
	  }
	  return null;
  }
  
}
