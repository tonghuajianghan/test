package commitdatabase;

import java.sql.*;

public class DbInter {
  public static void main(String[] args) {
	     Connection conn = DatabaseConnection.getdataConnection();
		 try {
				conn.setAutoCommit(false);//�����Զ�����
		 } catch (SQLException e1) {
				e1.printStackTrace();//��ӡկ��׷��
		 }
			String sql= "";
			try {		  		
				sql = "insert into person values(?,?,?,?)";	
				String usql = "insert into person id values(?)";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1,10);//�����һ�ݣ�
				ps.setString(2, "����");
				ps.setInt(3,70);
				ps.setInt(4,3);
				ps.execute();
				System.out.println(sql);
				conn.commit();				
				ps.close();
			}catch (SQLException e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();//��ӡվ���
				}
				e.printStackTrace();
				throw new RuntimeException("sss");
			}
		 
		 
  }
}

