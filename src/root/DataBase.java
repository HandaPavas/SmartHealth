package root;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public interface DataBase {
	
	public boolean ccheck_unique_username(String uname) throws SQLException, ClassNotFoundException; //Unique Username
	public int ccheck_login_details(String email1, String pass) throws SQLException, ClassNotFoundException;
	public String cgetusername(String email,String password) throws NumberFormatException, IOException, ClassNotFoundException, SQLException;
	
	public boolean crespond_to_request(String requested,String requester,int opt) throws NumberFormatException, IOException, ClassNotFoundException, SQLException;
	public boolean csend_request(String username,String toname) throws NumberFormatException, IOException, ClassNotFoundException, SQLException;
	public boolean cif_already_friends(String username,String toname) throws NumberFormatException, IOException, ClassNotFoundException, SQLException;
	
	/*

	public ResultSet all_end_users(String name) throws SQLException, ClassNotFoundException;
	

	public boolean if_user_exists(String uname) throws SQLException, ClassNotFoundException;
	
	
	public EndUser get_user_details(String username) throws SQLException; Moderator get_moderator_details(String username) throws SQLException; void update_user_to_database(EndUser obj) throws SQLException, ClassNotFoundException;
	
	//Function to Update the moderator
	public void update_moderator_to_database(Moderator obj) throws SQLException, ClassNotFoundException;
	
	public boolean check_unique_username(String uname) throws SQLException, ClassNotFoundException; boolean check_unique_sec_email(String uname,String smail) throws SQLException, ClassNotFoundException;
	
	public boolean check_unique_email(String email) throws SQLException, ClassNotFoundException;
	
	public void Add_user_to_database(EndUser obj) throws SQLException, ClassNotFoundException; void Add_moderator_to_database(Moderator obj) throws SQLException, ClassNotFoundException;
	
	public void delete_profile(String uname) throws SQLException, ClassNotFoundException;
	

	public void Add_admin_to_database(Admin obj) throws SQLException, ClassNotFoundException;
	
	public void send_request(String fromuser,String touser) throws SQLException, ClassNotFoundException;
	public String getusername(String email,String pass) throws SQLException, ClassNotFoundException;
	
	public ResultSet view_request(String requested) throws SQLException, ClassNotFoundException;
	
	public void respond_to_req(String requested,String requester,int opt) throws SQLException, ClassNotFoundException;
	
	public void unfriend(String user,String unfriend) throws SQLException, ClassNotFoundException;
	
	public void update_friend(String user,String tofriend) throws SQLException, ClassNotFoundException;
	public boolean check_if_alreadyfriends(String fromuser,String touser) throws SQLException, ClassNotFoundException;
	
	public boolean check_if_entry_friend(String fromuser,String touser) throws SQLException, ClassNotFoundException;
	
	public boolean check_if_already_sent_friend(String fromuser,String touser) throws SQLException, ClassNotFoundException;
	
	public ResultSet view_friends(String username) throws SQLException, ClassNotFoundException;
	public boolean check_qualification(String qual) throws SQLException, ClassNotFoundException;
	
	public int getforum_id() throws SQLException, ClassNotFoundException;
	
	public int check_login_details(String email1, String pass) throws SQLException, ClassNotFoundException;
	
	public boolean check_if_admin_moderator(String uname) throws SQLException, ClassNotFoundException;
	

	public void create_forum(Forum obj) throws ClassNotFoundException, SQLException;
	

	public boolean check_unique_forum_name(String ftopic) throws SQLException, ClassNotFoundException;
	public boolean is_valid_forum(String furl) throws SQLException, ClassNotFoundException;
	
	public boolean check_unique_forum_url(String furl) throws SQLException, ClassNotFoundException;
	

	public boolean check_if_forum_open(String ftopic) throws SQLException, ClassNotFoundException;
	

	public ResultSet show_forums(String username) throws SQLException, ClassNotFoundException;
	
	

	public void close_forum(String furl,String modname) throws ClassNotFoundException, SQLException;
	
	public ResultSet view_comments_on_post(String postuser,String postdate) throws ClassNotFoundException, SQLException;
	

	public ResultSet view_rating_on_post(String postuser,String postdate) throws ClassNotFoundException, SQLException;
	
	public void post_on_forum(Post obj) throws ClassNotFoundException, SQLException;
	
	public ResultSet viewposts_on_forum(String forum_url) throws ClassNotFoundException, SQLException;
	

	public void rate_on_post(String pname,String ptime,String username,int stars) throws SQLException;
	
	public ResultSet viewposts_byfid_on_forum(int forumid) throws ClassNotFoundException, SQLException;
	


	public void comment_on_post(Comment obj,String postuname, String posttime) throws ClassNotFoundException, SQLException;
	
*/
	

}
