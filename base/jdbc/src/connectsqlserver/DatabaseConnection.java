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
		  Connection conn =  DriverManager.getConnection(DBURL,DBUSER,DBPASSWARD);//����������������򡣷����Ǿ�̬��
		  System.out.println("���ݿ����ӳɹ�");
		  return conn;
	  }catch(ClassNotFoundException e){
		  e.printStackTrace();
		  System.out.print("��������ʧ��");
	  }catch(SQLException e){
		  e.printStackTrace();
		  System.out.println("���ݿ�δ���ӳɹ�");
	  }
	  return null;
  }
  
}