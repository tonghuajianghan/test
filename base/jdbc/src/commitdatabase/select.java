/*package commitdatabase;

public class select {

}
package lianjie;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class DatabaseConnection {
	private final static String DBDRIVER = "com.mysql.jdbc.Driver";
	private final static String DBURL = "jdbc:mysql://127.0.0.1:3306/jianghan";// ���ݿ�IP�����ݿ�����     ,3306mysql�Ķ˿�
	private final static String NAME = "root";// ���ݿ��˻���
	private final static String PWD = "123";// ���ݿ�����
	// ������ݿ�����
	public Connection getConnection() {
		try {
			System.out.println("==============");
			Class.forName(DBDRIVER);// ����ʹ�õ���������
			Connection conn = DriverManager.getConnection(DBURL, NAME, PWD); // ��ȡ����
			System.out.println("���ݿ����ӳɹ���");
			return conn;
		} catch (ClassNotFoundException e) {
			System.out.println("���ݿ�����������");
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("���ݿ����Ӳ��ɹ�");
			System.out.println(e.getMessage());
		}
		return null;
		
	}
 }

public class connectionsql {
	 
	
	      public	String []w_title =null;
		  public	String []w_type = null;
		  public	String []w_text = null;
		  public	String []w_time = null;
	 public  void connect() throws Exception{
		 DatabaseConnection database = new DatabaseConnection();
		 Connection conn = database.getConnection();	
		        try {
						conn.setAutoCommit(false);
					} catch (SQLException e1) {
						e1.printStackTrace(); 
					}			
				
				Statement stmt = conn.createStatement();
				String usql = "select * from wenzhang";
				ResultSet rs = stmt.executeQuery(usql);	
				int i = 0;
				while(rs.next()){
					 w_title[i] = new String(rs.getString("w_title"));					
					 w_type[i] = new String(rs.getString("w_type"));
					 w_text[i] = new String(rs.getString(" w_text"));
					 w_time[i] = new String(rs.getString("w_time"));
					 i++;
					
				}
				

	       
	 }
	  public		String []p_id = null;
	  public		String []p_passward = null;
	  public		String []p_name = null;
	  public		String []p_text = null;
	  public		String []p_time = null;
	  public		String []w_id = null;
		
	 public  void connectpinyu() throws Exception{
		 DatabaseConnection database = new DatabaseConnection();
		 Connection conn = database.getConnection();	
	        try {
					conn.setAutoCommit(false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}			
			
			Statement stmt = conn.createStatement();
			String usql = "select * from pinyu";
			ResultSet rs = stmt.executeQuery(usql);
		    int j = 0;
			while(rs.next()){
				 p_id[j]  =  new String(rs.getString(" p_id"));					
				 p_passward[j] =new String(rs.getString("  p_passward"));		
				 p_name[j] = new String(rs.getString(" p_name"));		
				 p_text[j] = new String(rs.getString(" p_text"));		
				 p_time[j] =new String(rs.getString(" p_time "));		
				 w_id[j] = new String(rs.getString(" w_id"));		
				 j++;
				
			}
              
    }
}

*/