import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import vo.*;
import util.DataBase;
public class test {

	public static void main(String[] args) throws SQLException{
		//System.out.println("hahaha");
		//System.out.println("hhhhh");
		DataBase db=new DataBase();
		//db.changeZHtoID();
		db.changeJLtoID();
		
	}
}
