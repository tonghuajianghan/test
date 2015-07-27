package connectsqlserver;

import java.sql.*;
public class Selection {
    public static void main(String[] args) {
    	Connection conn = DatabaseConnection.getdataConnection();
    	try{
    		conn.setAutoCommit(false);
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    	String surl = "select * from han";
    	String iurl = "insert into han values(1,4,6)";
    	try{
    		Statement stmt = conn.createStatement();
    		ResultSet rs = stmt.executeQuery(surl);
    		while(rs.next()){
    			int i = rs.getInt("id");
    			System.out.println(i);
    		}
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    	
	}
    	
}
