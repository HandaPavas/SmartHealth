package root;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Admin extends User{

	private String phoneno;
	
	String getAdminPhone()
	{
		return phoneno;
	}
	
	void putdata()  throws NumberFormatException, IOException
	{  
		int flag=0;
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	System.out.println("Enter username : ");
	username=br.readLine();        //Left:Check uniqueness
	System.out.println("Enter firstname : ");
	fname=br.readLine(); 
	System.out.println("Enter lastname : ");
	lname=br.readLine(); 
	System.out.println("Enter primary EmailId : ");
	while(flag!=1)
	{emailid1=br.readLine(); 
	String regular_exp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	Boolean check = emailid1.matches(regular_exp);
	if(check==false)
		System.out.println("Invalid Email, Try again, Enter :");
	else
		flag=1;
	}
	flag=0;
	System.out.println("Enter alternative EmailId : ");
	while(flag!=1)
	{emailid2=br.readLine(); 
	String regular_exp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	Boolean check = emailid2.matches(regular_exp);
	if(check==false)
		System.out.println("Invalid Email, Try again, Enter :");
	else
		flag=1;
	} 
	System.out.println("Enter password : ");
	password=br.readLine(); 
	System.out.println("Enter Phone Number : ");
	phoneno=br.readLine(); 
	System.out.println("Enter Street Number : ");
	streetnum=br.readLine(); 
	System.out.println("Enter Street Name : ");
	streetname=br.readLine(); 
	System.out.println("Enter Municipality Area : ");
	muncipty=br.readLine(); 
	System.out.println("Enter District : ");
	district=br.readLine(); 
	System.out.println("Enter Postal address : ");
	postarea=br.readLine(); 
	System.out.println("Enter Url Of Picture 1: ");
	pic1=br.readLine(); 
	System.out.println("Enter Url Of Picture 2: ");
	pic2=br.readLine(); 
	System.out.println("Enter Url Of Picture 3: ");
	pic3=br.readLine(); 
	System.out.println("Enter some words about yourself : ");
	aboutme=br.readLine(); 	
	usertype=1;   //1 for admin
	status=1;
	
	

	}
}
