package root;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class EndUser extends User {

	private static int karma;

	EndUser(String uname,String pass,String email1,String email2,String firstname,String lastname,String about,
			String pc1,String pc2,String pc3,String streetnumber,String strtname,String municipality,String dstrct,
			String postalarea)
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
		karma=1;
		usertype=3;
		status=1;
	}
	
	/*void putdata(String email1,String email2,String uname,String pass,String firstname,String lastname,
			String pc1,String pc2,String pc3,String streetnumber,String strtname,String municipality,
			String postalarea,String dstrct,String about)  throws NumberFormatException, 
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
		karma=1;
		usertype=3;
		status=1;

	}*/
	int getkarma()
	{
		return karma;
	}


}
