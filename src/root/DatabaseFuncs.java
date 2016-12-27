package root;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class DatabaseFuncs  {

	public DatabaseFuncs() {

		Connect.getConnection();

	}

	static ResultSet all_end_users(String name) throws SQLException, ClassNotFoundException
	{
		
		//Returns all the end users in the system
		Connect.getConnection();	
		ResultSet rs;
		int b=3;
		int stat=1;
		String sqlquery=" select Username from user where UserTypeId= '"+b+"' AND Status='"+stat+"'AND Username not LIKE'"+name+"' ";
		rs=Connect.st.executeQuery(sqlquery);
		
		return(rs);

	}
	

	static boolean if_user_exists(String uname) throws SQLException, ClassNotFoundException
	{
		//If a user of the given username exists?
		
		Connect.getConnection();	
		ResultSet rs;
		int b=1;
		int uid=3;
		String sqlquery="select Username from user where Username like '"+uname+"' AND Status= '1' AND UserTypeID= '3' ";
		System.out.println("Query Executed Successfully");
		rs=Connect.st.executeQuery(sqlquery);
		if(rs.next())
		{
			System.out.println("HIII");
			return true;
		}
		else
			
			return false;
	}
	
	static EndUser get_user_details(String username) throws SQLException
	{
		Connect.getConnection();	
		ResultSet rs;
		String sqlquery="select * from user where Username like '"+username+"' ";
		rs=Connect.st.executeQuery(sqlquery);
		rs.next();
		//System.out.println("Database:  "+rs.getString(1));
		//System.out.println(rs.getString(2));
		EndUser uobj=new EndUser(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),rs.getString(15));
		
		return uobj;



	}

	static Moderator get_moderator_details(String username) throws SQLException
	{
		Connect.getConnection();	
		ResultSet rs;
		String sqlquery="select user.Username, Password, Email1 ,Email2 ,"
				+ "FirstName  ,LastName,AboutMe ,PhotoURL1,PhotoURL2 ,PhotoURL3 ,"
				+ "StreetNumber,StreetName,MajorMunicipality ,GoverningDistrict  ,PostalArea,"
				+ "UserTypeID, Status, Phone from user join moderator on user.Username = moderator.Username and user.Username = '"
				+ username+"'";
		//System.out.println(sqlquery);
		//System.out.println("Retrieved from user Table");
		rs=Connect.st.executeQuery(sqlquery);
		
		//rs.next();
		//begin temp code
		ArrayList<String> lst=new ArrayList<String>();
		int i = 1;
		 ResultSetMetaData rsmd = rs.getMetaData();
		 //String name = rsmd.getColumnName(1);
		int num_column = rsmd.getColumnCount();
		while (rs.next()) {
	        for (i = 1; i <= num_column; i++) {
	        	lst.add( rs.getString(i));
	        	System.out.print(rs.getString(i)+" ");
	        }
	        System.out.println();

	    }
		//end
		Moderator mobj=new Moderator(lst.get(0),lst.get(1),lst.get(2),lst.get(3),lst.get(4),lst.get(5),lst.get(6),lst.get(7),lst.get(8),lst.get(9),lst.get(10),lst.get(11),lst.get(12),lst.get(13),lst.get(14),lst.get(17));
		System.out.println("Returning from database");
		return mobj;



	}
	static void update_user_to_database(EndUser obj) throws SQLException, ClassNotFoundException
	{
		//Updates data of enduser. 
		Connect.getConnection();
		System.out.println("Databse: -->"+obj.fname);
		String sqlquery="UPDATE user set Password='"+obj.password+"',Email2='"+obj.emailid2+"',FirstName='"+obj.fname+"',LastName='"+obj.lname+"',AboutMe='"+obj.aboutme+"',PhotoURL1='"+obj.pic1+"',PhotoURL2='"+obj.pic2+"',PhotoURL3='"+obj.pic3+"',StreetNumber='"+obj.streetnum+"',StreetName='"+obj.streetname+"',MajorMunicipality='"+obj.muncipty+"',GoverningDistrict='"+obj.district+"',PostalArea='"+obj.postarea+"' where Username like '"+obj.username+"' " ;
		Connect.st.executeUpdate(sqlquery);

		sqlquery="UPDATE enduser set Karma='"+obj.getkarma()+"' " ;
		Connect.st.executeUpdate(sqlquery);
	}



	//Function to Update the moderator
	static void update_moderator_to_database(Moderator obj) throws SQLException, ClassNotFoundException
	{
		Connect.getConnection();
		String sqlquery="UPDATE user set Password='" +obj.password+"',Email2='"+obj.emailid2+"',FirstName='"+obj.fname+"',LastName='"+obj.lname+"',AboutMe='"+obj.aboutme+"',PhotoURL1='"+obj.pic1+"',PhotoURL2='"+obj.pic2+"',PhotoURL3='"+obj.pic3+"',StreetNumber='"+obj.streetnum+"',StreetName='"+obj.streetname+"',MajorMunicipality='"+obj.muncipty+"',GoverningDistrict='"+obj.district+"',PostalArea='"+obj.postarea+"' where Username like '"+obj.username+"' " ;
		Connect.st.executeUpdate(sqlquery);

		sqlquery="UPDATE moderator set Phone='"+obj.getMPhone()+"' " ;
		Connect.st.executeUpdate(sqlquery);

	}

	static boolean check_unique_username(String uname) throws SQLException, ClassNotFoundException
	{
		//IF USERNAME IS NOT UNIQUE,IT RETURNS FALSE
		Connect.getConnection();	
		ResultSet rs;
		String sqlquery="select * from user where Username like '"+uname+"'";
		rs=Connect.st.executeQuery(sqlquery);
		if(rs.next())
		{
			return false;
		}

		return true;
	}

	static boolean check_unique_sec_email(String uname,String smail) throws SQLException, ClassNotFoundException
	{
		//IF SECONDARY EMAIL IS SAME AS PRIMARY EMAIL,IT RETURNS FALSE
		Connect.getConnection();	
		ResultSet rs;
		String sqlquery="select * from user where Username like '"+uname+"' AND Email1 like '"+smail+"'";
		rs=Connect.st.executeQuery(sqlquery);
		if(rs.next())
		{
			return false;
		}

		return true;

	}
	static boolean check_unique_email(String email) throws SQLException, ClassNotFoundException
	{
		//IF SECONDARY EMAIL IS SAME AS PRIMARY EMAIL,IT RETURNS FALSE
		Connect.getConnection();	
		ResultSet rs;
		String sqlquery="select * from user where Email1 like '"+email+"'";
		rs=Connect.st.executeQuery(sqlquery);
		if(rs.next())
		{
			return false;
		}

		return true;

	}

	static void Add_user_to_database(EndUser obj) throws SQLException, ClassNotFoundException
	{

		Connect.getConnection();
		String sqlquery="insert into user values('"+obj.username+"','"+obj.password+"','"+obj.emailid1+"','"+obj.emailid2+"','"+obj.fname+"','"+obj.lname+"','"+obj.aboutme+"','"+obj.pic1+"','"+obj.pic2+"','"+obj.pic3+"','"+obj.streetnum+"','"+obj.streetname+"','"+obj.muncipty+"','"+obj.district+"','"+obj.postarea+"','"+obj.usertype+"','"+obj.status+"')" ;
		Connect.st.execute(sqlquery);
		String current_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());


		sqlquery="insert into enduser values('"+obj.username+"','"+obj.getkarma()+"','"+current_date+"')";
		Connect.st.execute(sqlquery);



	}

	static void Add_moderator_to_database(Moderator obj) throws SQLException, ClassNotFoundException
	{
		Connect.getConnection();
		String sqlquery="insert into user values('"+obj.username+"','"+obj.password+"','"+obj.emailid1+"','"+obj.emailid2+"','"+obj.fname+"','"+obj.lname+"','"+obj.aboutme+"','"+obj.pic1+"','"+obj.pic2+"','"+obj.pic3+"','"+obj.streetnum+"','"+obj.streetname+"','"+obj.muncipty+"','"+obj.district+"','"+obj.postarea+"','"+obj.usertype+"','"+obj.status+"')" ;
		Connect.st.execute(sqlquery);
		//sqlquery="insert into loginattempt values(,'"+obj.username+"','"+obj.password+"',)" ;
		//st.execute(sqlquery);


		sqlquery="insert into moderator values('"+obj.username+"','"+obj.getMPhone()+"')";
		Connect.st.execute(sqlquery);


	}
	
	static void delete_profile(String uname) throws SQLException, ClassNotFoundException
	{
		//User who has status=2 in database is deactivated.So this func sets that status=2. 
		
		Connect.getConnection();
		int b=2;
		String sqlquery="UPDATE user set Status='"+b+"' where Username like '"+uname+"' " ;
		Connect.st.executeUpdate(sqlquery);


	}


	static void Add_admin_to_database(Admin obj) throws SQLException, ClassNotFoundException
	{
		Connect.getConnection();
		String sqlquery="insert into user values('"+obj.username+"','"+obj.password+"','"+obj.emailid1+"','"+obj.emailid2+"','"+obj.fname+"','"+obj.lname+"','"+obj.aboutme+"','"+obj.pic1+"','"+obj.pic2+"','"+obj.pic3+"',"+obj.streetnum+",'"+obj.streetname+"','"+obj.muncipty+"','"+obj.district+"','"+obj.postarea+"','"+obj.usertype+"','"+obj.status+"')" ;
		Connect.st.execute(sqlquery);
		//sqlquery="insert into loginattempt values(,'"+obj.username+"','"+obj.password+"',)" ;
		//st.execute(sqlquery);


		sqlquery="insert into administrator values('"+obj.username+"','"+obj.getAdminPhone()+"')";
		Connect.st.execute(sqlquery);


	}

	static void send_request(String fromuser,String touser) throws SQLException, ClassNotFoundException
	{
		//RETURNS TRUE IF BOTH ARE ALREADY FRIENDS
		String current_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

		Connect.getConnection();	


		String sqlquery="insert into friendship values( '"+fromuser+"','"+touser+"','"+current_date+"',NULL,NULL,NULL,NULL )";
		Connect.st.executeUpdate(sqlquery);

	}

	static String getusername(String email,String pass) throws SQLException, ClassNotFoundException
	{
		//RETURNS TRUE IF BOTH ARE ALREADY FRIENDS

		Connect.getConnection();	
		ResultSet rs;
		String sqlquery=" select Username from user where Email1 like '"+email+"' AND Password like '"+pass+"'";
		rs=Connect.st.executeQuery(sqlquery);
		rs.next();
		return(rs.getString(1));

	}

	static ResultSet getallusername() throws SQLException, ClassNotFoundException
	{
		

		Connect.getConnection();	
		ResultSet rs;
		String sqlquery=" select Username from user";
		rs=Connect.st.executeQuery(sqlquery);
		rs.next();
		return(rs);

	}

	static ResultSet view_request(String requested) throws SQLException, ClassNotFoundException
	{
		//RETURNS TRUE IF BOTH ARE ALREADY FRIENDS
		Connect.getConnection();	
		ResultSet rs;
		String sqlquery="select Requester_Username from friendship where Requested_Username like '"+requested+"' AND WhenConfirmed IS NULL  AND WhenRequested IS NOT NULL AND WhenRejected IS  NULL";
		rs=Connect.st.executeQuery(sqlquery);
		return rs;

	}

	static void respond_to_req(String requested,String requester,int opt) throws SQLException, ClassNotFoundException
	{

		Connect.getConnection();	

		String curr_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		String sqlquery=null;
		if(opt==1)//Accept request
		{
			sqlquery="UPDATE friendship SET WhenConfirmed= '"+curr_date+"' where Requested_Username like '"+requested+"' AND Requester_Username like '"+requester+"'" ;
		}
		else if(opt==2)//reject request
			{
				sqlquery="UPDATE friendship SET WhenRejected= '"+curr_date+"' where Requested_Username like '"+requested+"' AND Requester_Username like '"+requester+"'" ;				
			}
		Connect.st.executeUpdate(sqlquery);


	}

	static void unfriend(String user,String unfriend) throws SQLException, ClassNotFoundException
	{

		Connect.getConnection();	

		String curr_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		String sqlquery=null;

		sqlquery="UPDATE friendship SET WhenUnfriended= '"+curr_date+"' where Requested_Username like '"+user+"' AND Requester_Username like '"+unfriend+"' OR Requested_Username like '"+unfriend+"' AND Requester_Username like '"+user+"'" ;				

		Connect.st.executeUpdate(sqlquery);


	}

	static void update_friend(String user,String tofriend) throws SQLException, ClassNotFoundException
	{

		Connect.getConnection();	

		String curr_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		String sqlquery=null;

		sqlquery="UPDATE friendship SET WhenUnfriended= NULL,WhenRejected=NULL, WhenWithdrawn=NULL,WhenRequested='"+curr_date+"',WhenConfirmed=NULL where Requested_Username like '"+user+"' AND Requester_Username like '"+tofriend+"' OR Requested_Username like '"+tofriend+"' AND Requester_Username like '"+user+"'" ;				

		Connect.st.executeUpdate(sqlquery);


	}

	static boolean check_if_alreadyfriends(String fromuser,String touser) throws SQLException, ClassNotFoundException
	{
		//RETURNS TRUE IF BOTH ARE ALREADY FRIENDS
		Connect.getConnection();	
		ResultSet rs;
		String sqlquery="select * from friendship where Requester_Username like '"+fromuser+"' AND Requested_Username like '"+touser+"' AND WhenConfirmed IS NOT NULL AND WhenRejected IS NULL AND WhenUnfriended IS NULL";
		rs=Connect.st.executeQuery(sqlquery);
		if(rs.next())
		{
			return true;
		}

		sqlquery="select * from friendship where Requester_Username like '"+touser+"' AND Requested_Username like '"+fromuser+"' AND WhenConfirmed IS NOT NULL AND WhenRejected IS NULL AND WhenUnfriended IS NULL";
		rs=Connect.st.executeQuery(sqlquery);
		if(rs.next())
		{
			return true;
		}

		return false;
	}

	static boolean check_if_entry_friend(String fromuser,String touser) throws SQLException, ClassNotFoundException
	{
		//RETURNS TRUE IF BOTH ARE ALREADY FRIENDS
		Connect.getConnection();	
		ResultSet rs;
		/*String sqlquery="select * from friendship where Requester_Username like '"+fromuser+"' AND Requested_Username like '"+touser+"' ";
		rs=Connect.st.executeQuery(sqlquery);
		if(rs.next())
		{
			return true;
		}*/

		String sqlquery="select * from friendship where Requester_Username like '"+touser+"' AND Requested_Username like '"+fromuser+"' ";
		rs=Connect.st.executeQuery(sqlquery);
		if(rs.next())
		{
			return true;
		}

		return false;
	}

	static boolean check_if_already_sent_friend(String fromuser,String touser) throws SQLException, ClassNotFoundException
	{
		//RETURNS TRUE IF BOTH ARE ALREADY FRIENDS
		Connect.getConnection();	
		ResultSet rs;
		String sqlquery="select * from friendship where Requester_Username like '"+fromuser+"' AND Requested_Username like '"+touser+"' ";
		rs=Connect.st.executeQuery(sqlquery);
		if(rs.next())
		{
			return true;
		}

		return false;
	}


	static ResultSet view_friends(String username) throws SQLException, ClassNotFoundException
	{
		//RETURNS TRUE IF BOTH ARE ALREADY FRIENDS
		Connect.getConnection();	
		ResultSet rs;
		String sqlquery="select Requested_Username from friendship where Requester_Username like '"+username+"'  AND WhenConfirmed IS NOT NULL AND WhenUnfriended IS NULL AND WhenRejected IS NULL  UNION select Requester_Username from friendship where Requested_Username like '"+username+"'  AND WhenConfirmed IS NOT NULL AND WhenUnfriended IS NULL AND WhenRejected IS NULL   ";
		rs=Connect.st.executeQuery(sqlquery);	
		
		return rs;
	}


	static boolean check_qualification(String qual) throws SQLException, ClassNotFoundException
	{
		//RETURNS TRUE IF Qualification exists
		Connect.getConnection();	
		ResultSet rs;
		String sqlquery="select * from qualification where Description like '"+qual+"'" ;
		rs=Connect.st.executeQuery(sqlquery);
		if(rs.next())
		{
			return true;
		}

		return false;
	}

	static int getforum_id() throws SQLException, ClassNotFoundException
	{
		//RETURNS TRUE IF THE DETAILS ARE CORRECT
		Connect.getConnection();	
		ResultSet rs;
		int usertype;
		String sqlquery="select MAX(ForumID) from forum";
		rs=Connect.st.executeQuery(sqlquery);
		rs.next();
		int fid=rs.getInt(1);
		return(fid+1);

	}



	static int check_login_details(String email1, String pass) throws SQLException, ClassNotFoundException
	{
		//RETURNS TRUE IF THE DETAILS ARE CORRECT
		Connect.getConnection();	
		ResultSet rs;
		int usertype;
		String sqlquery="select * from user where Email1 like '"+email1+"' AND Password like '"+pass+"'";
		rs=Connect.st.executeQuery(sqlquery);
		if(rs.next())
		{
			usertype=Integer.parseInt(rs.getString(16));
			return (usertype);
		}

		return 0;
	}
	static boolean check_if_admin_moderator(String uname) throws SQLException, ClassNotFoundException
	{
		//RETURNS TRUE IF THE USER IS ADMIN/MODERATOR
		Connect.getConnection();	
		ResultSet rs;
		String sqlquery="select * from user where Username like '"+uname+"' AND UserTypeID = 1 OR Username like '"+uname+"' AND UserTypeID = 2";
		rs=Connect.st.executeQuery(sqlquery);
		if(rs.next())
		{
			return true;
		}

		return false;
	}


	static void create_forum(Forum obj) throws ClassNotFoundException, SQLException
	{
		/*Calendar cid=Calendar.getInstance();
		SimpleDateFormat df=new SimpleDateFormat("YYYY-MM-DD");
		String current_date=df.format(cid.getTime());
		 */
		String timestamp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

		Connect.getConnection();
		String sqlquery="insert into forum values('"+obj.getforumid()+"','"+obj.getftopic()+"','"+obj.getfurl()+"','"+obj.getfsummary()+"','"+timestamp+"',NULL,'"+obj.getfcreatedby()+"',NULL)" ;

		Connect.st.executeUpdate(sqlquery);
	}

	static boolean check_unique_forum_name(String ftopic) throws SQLException, ClassNotFoundException
	{
		//RETURNS TRUE IF FORUM IS unique, false if forum name is already in use
		Connect.getConnection();	
		ResultSet rs;
		String sqlquery="select * from forum  where Topic like '"+ftopic+"'" ;
		rs=Connect.st.executeQuery(sqlquery);
		if(rs.next())
		{
			return false;	
		}

		return true;
	}

	static boolean is_valid_forum(String furl) throws SQLException, ClassNotFoundException
	{
		//RETURNS TRUE IF FORUM exists, false if forum name is already in use
		Connect.getConnection();	
		ResultSet rs;
		String sqlquery="select * from forum  where URL like '"+furl+"'" ;
		rs=Connect.st.executeQuery(sqlquery);
		if(rs.next())
		{
			return true;	
		}

		return false;
	}



	static boolean check_unique_forum_url(String furl) throws SQLException, ClassNotFoundException
	{
		//RETURNS TRUE IF FORUM url IS unique, false if forum url is already in use
		Connect.getConnection();	
		ResultSet rs;
		String sqlquery="select * from forum  where URL like '"+furl+"'" ;
		rs=Connect.st.executeQuery(sqlquery);
		if(rs.next())
		{
			return false;	
		}

		return true;
	}

	boolean check_if_forum_open(String ftopic) throws SQLException, ClassNotFoundException
	{
		//RETURNS TRUE IF FORUM IS OPEN, FORUM NOT CLOSED
		Connect.getConnection();	
		ResultSet rs;
		String sqlquery="select * from forum  where Topic like '"+ftopic+"' AND WhenClosed IS NULL" ;
		rs=Connect.st.executeQuery(sqlquery);
		if(rs.next())
		{
			return true;	
		}

		return false;
	}

	static ResultSet show_forums(String username) throws SQLException, ClassNotFoundException
	{
		//RETURNS TRUE IF FORUM IS OPEN, FORUM NOT CLOSED
		Connect.getConnection();	
		ResultSet rs;
		String sqlquery;
		if(username.equals("all"))
		{
			sqlquery="select * from forum where WhenClosed IS NULL " ;
		}
		else
		{
			sqlquery="select * from forum  where CreatedByModerator_Username like '"+username+"' AND  WhenClosed IS NULL " ;
		}
		rs=Connect.st.executeQuery(sqlquery);
		return rs;

	}

	static void close_forum(String furl,String modname) throws ClassNotFoundException, SQLException
	{
		String current_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());


		Connect.getConnection();

		String sqlquery="UPDATE forum SET WhenClosed= '"+current_date+"',DeletedByModerator_Username= '"+modname+"'  where URL like '"+furl+"'" ;
		Connect.st.executeUpdate(sqlquery);
	}

	static ResultSet view_comments_on_post(String postuser,String postdate) throws ClassNotFoundException, SQLException
	{

		Connect.getConnection();
		ResultSet rs;
		String sqlquery="select * from comment where Post_Username like '"+postuser+"' AND Post_TimeCreated = '"+postdate+"'" ;

		rs=Connect.st.executeQuery(sqlquery);
		return rs;
	}

	static ResultSet view_rating_on_post(String postuser,String postdate) throws ClassNotFoundException, SQLException
	{

		Connect.getConnection();
		ResultSet rs;
		String sqlquery="select * from rating where Post_Username like '"+postuser+"' AND Post_TimeCreated = '"+postdate+"'" ;

		rs=Connect.st.executeQuery(sqlquery);
		return rs;
	}

	static void post_on_forum(Post obj) throws ClassNotFoundException, SQLException
	{
		String current_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

		Connect.getConnection();
		ResultSet rs;
		String sqlquery="select * from forum where URL like '"+obj.getforumurl()+"' " ;
		rs=Connect.st.executeQuery(sqlquery);
		rs.next();
		int forumid=Integer.parseInt(rs.getString(1));
		sqlquery="insert into post values('"+obj.getpuname()+"','"+current_date+"','"+forumid+"','"+obj.getptext()+"','"+obj.getppic()+"','"+obj.getplink()+"','"+obj.getpvid()+"')" ;
		Connect.st.executeUpdate(sqlquery);
	}

	static ResultSet viewposts_on_forum(String forum_url) throws ClassNotFoundException, SQLException
	{

		Connect.getConnection();
		ResultSet rs;
		String sqlquery="select * from forum where URL like '"+forum_url+"' " ;
		rs=Connect.st.executeQuery(sqlquery);
		rs.next();
		int forumid=Integer.parseInt(rs.getString(1));

		sqlquery="select * from post where ForumID='"+forumid+"' " ;
		rs=Connect.st.executeQuery(sqlquery);
		return rs;
	}

	static void rate_on_post(String pname,String ptime,String username,int stars) throws SQLException
	{
		Connect.getConnection();
		String sqlquery="insert into rating values('"+pname+"','"+ptime+"','"+username+"','"+stars+"')" ;
		Connect.st.executeUpdate(sqlquery);


	}
	static ResultSet viewposts_byfid_on_forum(int forumid) throws ClassNotFoundException, SQLException
	{

		Connect.getConnection();
		ResultSet rs;

		String sqlquery="select * from post where ForumID='"+forumid+"' " ;
		rs=Connect.st.executeQuery(sqlquery);
		return rs;
	}


	static void comment_on_post(Comment obj,String postuname, String posttime) throws ClassNotFoundException, SQLException
	{
		String current_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

		Connect.getConnection();
		System.out.println("hello5");

		String sqlquery="insert into comment values('"+postuname+"','"+posttime+"','"+obj.getcommenter()+"','"+current_date+"','"+obj.getcommenttext()+"','"+obj.getppic()+"','"+obj.getplink()+"','"+obj.getpvid()+"')" ;
		System.out.println("hello5...");
		Connect.st.executeUpdate(sqlquery);
		System.out.println("hello5!!");
	}



	static int datum_id() throws SQLException, ClassNotFoundException
	{
		//RETURNS TRUE IF THE DETAILS ARE CORRECT
		Connect.getConnection();	
		ResultSet rs;

		String sqlquery="select MAX(DatumID) from datum";
		rs=Connect.st.executeQuery(sqlquery);
		rs.next();
		int did=rs.getInt(1);
		return(did+1);

	}

	static void add_health_data(int choice, String value, String username) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		String current_date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());		
		Connect.getConnection();
		int datid=datum_id();
		String sqlquery="insert into datum values('"+datid+"','"+username+"','"+choice+"','"+value+"','"+current_date+"')" ;
		Connect.st.executeUpdate(sqlquery);
	}


	static ResultSet see_friends_health_data( String friend) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		Connect.getConnection();	
		ResultSet rs;

		String sqlquery="select * from datum where Username like '"+friend+"'";
		rs=Connect.st.executeQuery(sqlquery);

		return rs;
	}

}
