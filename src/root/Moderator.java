package root;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Moderator extends User{
	
	static String phoneno;
//	private String qualification;
	
	Moderator(String uname,String pass,String email1,String email2,String firstname,String lastname,String about,
			String pc1,String pc2,String pc3,String streetnumber,String strtname,String municipality,String dstrct,
			String postalarea,String phone)
	{
		username=uname;
		fname=firstname;
		lname=lastname;
		emailid1=email1;
		emailid2=email2;
		password=pass;
		streetnum=streetnumber;
		streetname=strtname;
		muncipty=municipality;
		district=dstrct;
		postarea=postalarea;
		aboutme=about;
		pic1=pc1;
		pic2=pc2;
		pic3=pc3;
		phoneno=phone;
		usertype=2;
		status=1;


	}
	
	String getMPhone()
	{
		return phoneno;
	}
	
	void putdata(String email1,String email2,String uname,String pass,String firstname,String lastname,
			String pc1,String pc2,String pc3,String streetnumber,String strtname,String municipality,
			String postalarea,String dstrct,String about,String phone)  throws NumberFormatException, 
	IOException, ClassNotFoundException, SQLException
	{  
		username=uname;
		fname=firstname;
		lname=lastname;
		emailid1=email1;
		emailid2=email2;
		password=pass;
		streetnum=streetnumber;
		streetname=strtname;
		muncipty=municipality;
		district=dstrct;
		postarea=postalarea;
		aboutme=about;
		pic1=pc1;
		pic2=pc2;
		pic3=pc3;
		phoneno=phone;
		usertype=2;


	}


}
