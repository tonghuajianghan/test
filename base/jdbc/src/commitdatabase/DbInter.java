package commitdatabase;

import java.sql.*;

public class DbInter {
  public static void main(String[] args) {
	     Connection conn = DatabaseConnection.getdataConnection();
		 try {
				conn.setAutoCommit(false);//设置自动连接
		 } catch (SQLException e1) {
				e1.printStackTrace();//打印寨堆追踪
		 }
			String sql= "";
			try {		  		
				sql = "insert into person values(?,?,?,?)";	
				String usql = "insert into person id values(?)";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setInt(1,10);//插入第一纵；
				ps.setString(2, "车轮");
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
					e1.printStackTrace();//打印站输出
				}
				e.printStackTrace();
				throw new RuntimeException("sss");
			}
		 
		 
  }
}

