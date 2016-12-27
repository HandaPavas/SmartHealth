
package root;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Controller {
	
private DataBase db;

	
	public void setdb(DataBase db)
	{
		this.db=db;
	}
	
	
	public boolean check_unique_username(String uname) throws SQLException, ClassNotFoundException
	{
		
		if(uname==null)
		{
			throw new IllegalArgumentException();
		}
		 boolean ans= db.ccheck_unique_username(uname);
		 return ans;
	}
	
	public int ccheck_login_details(String email1, String pass) throws SQLException, ClassNotFoundException
	{
		int usertype=db.ccheck_login_details(email1, pass);
		return usertype;
	}

	public String getusername(String email,String password) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		String username=db.cgetusername( email, password);
		return username;
	}

	public boolean csend_request(String username,String toname) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		if(username==null || toname==null)
		{
			throw new IllegalArgumentException();
		}
		 boolean ans= db.csend_request(username,toname);
		 return ans;
		
	}
	
	public boolean cif_already_friends(String username,String toname) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		if(username==""|| toname=="")
		{
			throw new IllegalArgumentException();
		}
		boolean ans= db.cif_already_friends(username,toname);
		 return ans;
	}
	
	
	static String view_all_posts_on_forums(String forumurl) throws ClassNotFoundException, SQLException, IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ResultSet rs;
		System.out.println("Enter forum url(You can see from above data)");
		String allposts="";
		 rs=DatabaseFuncs.viewposts_on_forum(forumurl);
		 		
		 while(rs.next())
			{
			
			allposts=allposts+"\n"+"Username : "+rs.getString(1)+"\n"+"Time created : "+rs.getString(2)
			+"\n"+"Post Text : "+rs.getString(4); 
			
			}	
				
		
		 return allposts;		 
	}
	

	static void create_forum(Forum fobj) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{		
		
		DatabaseFuncs.create_forum(fobj);
		//System.out.println("Forum Successfully Created");	
	}
	
	
	static ResultSet view_forums() throws ClassNotFoundException, SQLException, IOException
	{
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		     ResultSet rs=null;		
			 rs= DatabaseFuncs.show_forums("all");
		
		/*while(rs.next())
		{
			System.out.print("Forum Topic : "+rs.getString(2));
			System.out.println("\tURL : "+rs.getString(3));
			System.out.println("Summary : "+rs.getString(4));
			System.out.println("Created by : "+rs.getString(7));
			System.out.println("*************************");
		}	*/
			 
			 return rs;
	}
	
	static ResultSet view_forums_self(String name) throws ClassNotFoundException, SQLException, IOException
	{
		
		     ResultSet rs=null;		
			 rs= DatabaseFuncs.show_forums(name);
		
			 
			 return rs;
	}
	
	
	static void create_post(Post pobj) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		//Post pobj=new Post();
		//pobj.create_post(username);
		DatabaseFuncs.post_on_forum(pobj);
	}
	
	static ResultSet view_posts_on_forum(String forumurl) throws ClassNotFoundException, SQLException, IOException
	{
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ResultSet rs;
		//System.out.println("Enter forum url(You can see from above data)");
		//String allposts="";
		 rs=DatabaseFuncs.viewposts_on_forum(forumurl);
		 		
	
		 return rs;
	}
	


	
	static ResultSet all_end_users(String name) throws SQLException, ClassNotFoundException
	{//retrieves all endusers
		ResultSet rs=DatabaseFuncs.all_end_users(name);
		return rs;
	}
	
	static boolean if_user_exists(String uname) throws SQLException, ClassNotFoundException
	{//Checks if user exists
		Boolean ans=DatabaseFuncs.if_user_exists(uname);
		System.out.println(ans);
		return ans;
	}
	
	

	static void update_user_in_database(EndUser ureg) throws ClassNotFoundException, SQLException
	{
		//Update user details in database
		DatabaseFuncs.update_user_to_database(ureg);
		
	}
	
	static EndUser get_user_details(String username) throws ClassNotFoundException, SQLException
	{
		//Update user details in database
		EndUser uobj=DatabaseFuncs.get_user_details(username);
		return uobj;
	}
	

	static Moderator get_moderator_details(String username) throws ClassNotFoundException, SQLException
	{
		//Update user details in database
		Moderator mobj=DatabaseFuncs.get_moderator_details(username);
		System.out.println("Returning");
		return mobj;
	}
	
	
	
	static void delete_profile(String uname) throws SQLException, ClassNotFoundException
	{
		//User who has status=2 in database is deactivated.So this func sets that status=2. 
		
		DatabaseFuncs.delete_profile(uname);

	}
	
	static void Add_user_to_database(EndUser ureg) throws ClassNotFoundException, SQLException
	{
		//Add user details to database on registration
		DatabaseFuncs.Add_user_to_database(ureg);
	}
		
	static void  Add_moderator_to_database(Moderator mreg) throws ClassNotFoundException, SQLException
	{
		//Add moderator details to database on registration
		DatabaseFuncs.Add_moderator_to_database(mreg);
	}
	
	static void update_moderator_in_database(Moderator mreg) throws ClassNotFoundException, SQLException
	{
		//Update user details in database
		DatabaseFuncs.update_moderator_to_database(mreg);
		
	}

	
	static int check_login_details(String emailid,String password) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
        int ans=DatabaseFuncs.check_login_details(emailid,password);
		return ans;	
		
	}
	
	static String get_username(String email,String password) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		String username=DatabaseFuncs.getusername( email, password);
		return username;
	}
	
	static ResultSet get_all_username() throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		ResultSet username=DatabaseFuncs.getallusername();
		return username;
	}
	
	
	static ResultSet view_request(String username) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		//Returns true if there are any requests
		ResultSet rs= DatabaseFuncs.view_request(username);
		return(rs);
	}
	
	
	
	
	
	static void delete_forum(String username,String url) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		DatabaseFuncs.close_forum(url,username);
	  
	}
	
		
	
	static void respond_to_request(String requested,String requester,int opt) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		DatabaseFuncs.respond_to_req( requested, requester, opt);
	}
	
	
	static ResultSet view_friends(String username) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		ResultSet rs=DatabaseFuncs.view_friends(username);
		return rs;
	}
	
	
	static void send_request(String username,String toname) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		boolean ans=DatabaseFuncs.check_if_admin_moderator(toname);
		if(ans)
		 {
			System.out.println("You cannot send request to admin / moderator");				
		 }
		else
		{
			ans= DatabaseFuncs.check_if_alreadyfriends(username,toname);
			if(ans)
			{
				System.out.println("You both are Already Friends");
			}
			else
			{
				ans= DatabaseFuncs.check_if_entry_friend(username,toname);
				if(ans)
				{
					DatabaseFuncs.update_friend(username,toname);
				}				
			DatabaseFuncs.send_request(username,toname);
			System.out.println("Request Sent");
			
			}
		}		
	}
	
	
	static boolean if_already_friends(String username,String toname) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		
			 boolean ans= DatabaseFuncs.check_if_alreadyfriends(username,toname);
			return ans;
				
	}
	
	
	
	
	static void view_forum(int option) throws ClassNotFoundException, SQLException, IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ResultSet rs=null;
		if(option==3)
		{
			 rs= DatabaseFuncs.show_forums("all");
		}
		else
			if(option==4)
		     {
				System.out.println("\nView Forum posts by: ");						
				String name=br.readLine();
				 rs= DatabaseFuncs.show_forums(name);
		     }
		while(rs.next())
		{
			System.out.print("Forum Topic : "+rs.getString(2));
			System.out.println("\tURL : "+rs.getString(3));
			System.out.println("Summary : "+rs.getString(4));
			System.out.println("Created by : "+rs.getString(7));
			System.out.println("*************************");
		}		
	}
	
	
	

	static void comment_on_post(String username,String forumurl) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		ResultSet rs;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("On which post do you want to comment?");
		int postno=Integer.parseInt(br.readLine());		
		 rs=DatabaseFuncs.viewposts_on_forum(forumurl);		
		while(postno>0)
		{
			rs.next();
			postno=postno-1;			
		}
		
		Comment cobj;
		//Post pob=new Post();
	//	cobj=pob.create_comment(username);		
		String pname=rs.getString(1);
		String ptime=rs.getString(2);
		//DatabaseFuncs.comment_on_post(cobj,pname,ptime);		
	}
	
	static void post_comment(Comment cobj,String pname,String ptime) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		
		DatabaseFuncs.comment_on_post(cobj,pname,ptime);		
	}
	
	static void rate_on_post(String username,String pname,String ptime,int stars) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		/*ResultSet rs;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Which post do you want to rate?");
		int postno=Integer.parseInt(br.readLine());		
		 rs=DatabaseFuncs.viewposts_on_forum(forumurl);		
		while(postno>0)
		{
			rs.next();
			postno=postno-1;			
		}
		
		System.out.println("How many stars do you want to give?");	
		int stars=Integer.parseInt(br.readLine());	
		String pname=rs.getString(1);
		String ptime=rs.getString(2);
		*/
		DatabaseFuncs.rate_on_post(pname,ptime,username,stars);		
	}
	
	
	static ResultSet view_comments_on_post(String pname,String ptime) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{		
		ResultSet rs=DatabaseFuncs.view_comments_on_post(pname,ptime);
		/*while(rs.next())
		{
			System.out.println("Commenter :"+rs.getString(3));
			System.out.println("Comment :"+rs.getString(5));
		}*/
		
		return rs;
	}
	
	
	
	static List<String> view_full_forums() throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{
		ResultSet rs= DatabaseFuncs.show_forums("all");
		int forumid;
		List<String> fullforums = new ArrayList<String>();
		
		while(rs.next())
		{
			String onefullforum="";
			System.out.print("Forum Topic : "+rs.getString(2));
			System.out.println("\tURL : "+rs.getString(3));
			System.out.println("Summary : "+rs.getString(4));
			System.out.println("Created by : "+rs.getString(7));
			onefullforum=onefullforum+"Forum Topic : "+rs.getString(2)+"\tURL : "+rs.getString(3)+"\n"+"Summary : "+rs.getString(4)+"\n"+"Created by : "+rs.getString(7);
			forumid=Integer.parseInt(rs.getString(1));
			onefullforum=onefullforum+"\n"+"POSTS:\n";
			ResultSet rs1=DatabaseFuncs.viewposts_byfid_on_forum(forumid);
			int count=1;
			
						
			 while(rs1.next())
				{
				 
				 System.out.println("Post Number : "+count);
				 count=count+1;
				System.out.print("Username : "+rs1.getString(1));
				System.out.println("\tTime created : "+rs1.getString(2));
				System.out.println("Post Text : "+rs1.getString(4));
				System.out.println("Comments : ");
				System.out.println("+++++++++++++++++"+onefullforum);
				onefullforum=onefullforum+"Poster Name : "+rs1.getString(1)+"\tTime created : "+rs1.getString(2)+"\n"+"Post Text : "+rs1.getString(4)+"\n"+"Comments : "+"\n";
				System.out.println(onefullforum);
				
				ResultSet rs2=DatabaseFuncs.view_comments_on_post(rs1.getString(1),rs1.getString(2));
				while(rs2.next())
				{
					System.out.println("Commenter :"+rs2.getString(3));
					System.out.println("Comment :"+rs2.getString(5));
					onefullforum=onefullforum+"Commenter :"+rs2.getString(3)+"\n"+"Comment :"+rs2.getString(5)+"\n\n";
					
				}
				System.out.println("*************************");
				}
			
			System.out.println("*************************");
			
			fullforums.add(onefullforum);
			System.out.println(onefullforum);
		}
		
		return fullforums;
				
	}
	
	
	static void add_health_data(int choice, String value,String username) throws NumberFormatException, IOException, ClassNotFoundException, SQLException
	{		
		DatabaseFuncs.add_health_data( choice,value,username);
	}
	
	static void view_friend_data(String username,String friend) throws ClassNotFoundException, SQLException, NumberFormatException, IOException
	{
		boolean ans= DatabaseFuncs.check_if_alreadyfriends(username,friend);
		if(!ans)
		{
			System.out.println("You both are not friends! You cannot see his data ");
		}
		else
		{
			ResultSet rs= DatabaseFuncs.see_friends_health_data( friend);
			System.out.print("Health Data of your friend, "+friend);
			String property;
			while(rs.next())
			{
				if(Integer.parseInt(rs.getString(3))==1)
				{
					property="Running Distance";
				}
				else
				if(Integer.parseInt(rs.getString(3))==1)
				{
					property="Calories Burnt";
				}
				else
				if(Integer.parseInt(rs.getString(3))==1)
				{
					property="Blood Pressure";
				}
				System.out.print("Username : "+rs.getString(3));
				System.out.println("was : "+rs.getString(4));
				System.out.println("as on Date : "+rs.getString(5));
				
			}
		}
	}
	
	static ResultSet view_friend_health_data(String friend) throws ClassNotFoundException, SQLException, NumberFormatException, IOException
	{
			ResultSet rs= DatabaseFuncs.see_friends_health_data(friend);
			return rs;
			
	}
	
	
   
	
	
	


}
