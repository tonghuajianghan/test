package commitdatabase;

import java.sql.*;

class update{
	public static void myupdate(){
		Connection conn = DatabaseConnection.getdataConnection();		
		try{
			conn.setAutoCommit(false);
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			//String hurl = "update person set 'jianghan' ='haoren' where id = 1  "; 
			//String url = "insert into person  values('177','han','22','33')";
			String uurl = "update person set name = 'jjjjj' where id = '10'";
			String durl = "delete from person where id = '2'";
			String hurl = "select * from person ";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(uurl);
			stmt.execute(durl);
			//ResultSet rs = stmt.executeQuery(hurl);
			ResultSet rs = stmt.executeQuery(hurl);				
			while(rs.next()){
				String []array =new String[]{ rs.getString(2)};
				for(int j = 0; j < array.length;j++){					
			   		System.out.println(array[j] );
				}
				
			}
			conn.commit();//��java�е������ύ��mysql�У�������mysql������ʾjava�����ݿ�ĸı�
			rs.close();//���رգ�ϵͳ���Զ��ر�
			stmt.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
public class DbUpdate{
	public static void main(String[] args) {
		update.myupdate();
	}
}
	
