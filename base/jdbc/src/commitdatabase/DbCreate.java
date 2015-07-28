package commitdatabase;
import java.sql.*;

public class DbCreate {
 public static void main(String[] args) {
	 Connection conn = DatabaseConnection.getdataConnection();
	 try{
		 conn.setAutoCommit(false);
	 }catch(SQLException e){
		 e.printStackTrace();
	 }
	 try{ 		
	    Statement stmt = conn.createStatement();
	    stmt.addBatch("insert into person values(12,hanhan,7979,79)");
	    //String plants = "create database plants";
	    String hh = "use excite";
	    String curl = "create table animal(id int primary key,name varchar)";
	   // String url = "select * from animal";
	    //stmt.execute(plants);
	    String insertanimal = "insert into animal values(1,'dog')";
	    
	    
	    stmt.execute( hh);
	    stmt.execute(curl);
	    stmt.executeUpdate(insertanimal);
	    
	    conn.commit();
	    stmt.close();
	    conn.close();
	   
	    
	}catch(SQLException e){
		e.printStackTrace();
	}
	
 }
}
