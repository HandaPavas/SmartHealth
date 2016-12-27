package root;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect {

	public static Connection con = null;
	public static Statement st;
	public static void getConnection(){
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/smarthealthdb","root","pavas@94");	
			System.out.println("Connected to DB");
			st=con.createStatement();

		}
		catch(Exception e){ 
			System.out.println("Error Connecting to Database");




		}

	}

}
