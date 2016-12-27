package test_scripts;
import root.Controller;
import root.DataBase;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserProfile {

	@Mock
	DataBase db;
	
	
	@Before
	public void setup(){
	MockitoAnnotations.initMocks(this);
	}
	
	
	
	@Test
	public void check_unique_Username_Test() throws ClassNotFoundException, SQLException {
		Controller c=new Controller();
		c.setdb(db);
		
		String dummy_username="abc";
		when(db.ccheck_unique_username(dummy_username)).thenReturn(true);	
		boolean ans=c.check_unique_username(dummy_username);
		
		assertTrue(ans);
		
		
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void check_unique_Username_IllegalArgs_Test() throws ClassNotFoundException, SQLException {
		Controller c=new Controller();
		c.setdb(db);
		
		String dummy_username=null;
		when(db.ccheck_unique_username(dummy_username)).thenReturn(true);	
		boolean ans=c.check_unique_username(dummy_username);
		
		assertTrue(ans);
		
		
	}
	
	@Test
	public void check_login_details_Test() throws ClassNotFoundException, SQLException {
		Controller c=new Controller();
		c.setdb(db);
		
		when(db.ccheck_login_details("admin@gmail.com", "pass")).thenReturn(new Integer(1));	
		when(db.ccheck_login_details("moderator@gmail.com", "pass")).thenReturn(new Integer(2));	
		when(db.ccheck_login_details("enduser@gmail.com", "pass")).thenReturn(new Integer(3));	
		int usertype=c.ccheck_login_details("enduser@gmail.com", "pass");
		assertEquals(usertype,3);
		
		usertype=c.ccheck_login_details("admin@gmail.com", "pass");
		assertEquals(usertype,1);
			
		
	}
	
	
	@Test
	public void get_username_test() throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		Controller c=new Controller();
		c.setdb(db);
		
		when(db.cgetusername("admin@gmail.com", "pass")).thenReturn(new String("admin"));	
		when(db.cgetusername("enduser@gmail.com", "pass")).thenReturn(new String("user"));	
		when(db.cgetusername("moderator@gmail.com", "pass")).thenReturn(new String("moderator"));	
		String dummy_uname=c.getusername("enduser@gmail.com", "pass");
		assertEquals(dummy_uname,"user");
		
		 dummy_uname=c.getusername("admin@gmail.com", "pass");
		assertEquals(dummy_uname,"admin");		
		
	}
	
}
