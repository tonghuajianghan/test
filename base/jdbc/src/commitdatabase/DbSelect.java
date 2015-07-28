package commitdatabase;

import java.sql.*;
import javax.sql.*;
class Select{	
  public static String[] dd() {
		Connection conn = DatabaseConnection.getdataConnection();
		 String str[] = null;
		try{
		  conn.setAutoCommit(false);
		}catch(SQLException e){
			e.printStackTrace();
			 System.out.println("rrr");
		}
		try{
		  String url = "select * from person";
		  String hurl = "insert into person  values('167','ddhan','22','33')";
		  Statement stmt = conn.createStatement();
		  boolean bl =  stmt.execute(hurl);
		  
		 /* ResultSet urs = urs.getR; 
		  System.out.println("eee");*/
		  ResultSet rs = stmt.executeQuery(url);
		  ResultSet urs = stmt.getResultSet();
          int i = 0;        
		  while(rs.next()){
			  
			  /*for(int r = 0; r < i; r++){
				    System.out.println(bl);
			  }*/
			 /*int h =  rs.getInt(1);
			 System.out.println(h);
			 String str = rs.getString(2);
			 System.out.println(str);*/
			  /*int h = rs.getInt("id");			 
			   System.out.println(h);*/
			 String []array =new String[]{ urs.getString(2)};
			 for(int j = 0; j < array.length; j++ ){
			   System.out.println(array[j]);
				 //return array[j];
			 }
			  i++;
			  /*for(int j = 0; j < str.length; j++ ){
			    str =new String[]{rs.getString(2)};
			    
			  }*/
			   
		  }		  
		}catch(SQLException e){
			e.printStackTrace();
			 System.out.println("rrr");
		}
		return str;
		
		
    }
}
public class DbSelect{
	public static void main(String[] args) {
		Select.dd();
		/*String []array = Select.dd();
		for(int i = 0; i < array.length ;i++){
			System.out.println(array[i]);
		   // String str = array[i];
		    
		}*/
	}
}

		
