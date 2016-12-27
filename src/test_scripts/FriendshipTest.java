package test_scripts;

import static org.junit.Assert.*;
import root.Controller;
import root.DataBase;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class FriendshipTest {

	@Mock
	DataBase db;
	
	
	@Before
	public void setup(){
	MockitoAnnotations.initMocks(this);
	}



	@Test
	public void send_request_test() throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		Controller c=new Controller();
		c.setdb(db);
		
		when(db.csend_request("user1", "user2")).thenReturn(true);	
        boolean ans=c.csend_request("user1", "user2");	
		assertTrue(ans);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void send_request_test_IllegalArgs() throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		Controller c=new Controller();
		c.setdb(db);
		
		when(db.csend_request("user1", "user2")).thenReturn(true);	
        boolean ans=c.csend_request(null, "user2");	
		assertTrue(ans);
		
	}
	
	@Test
	public void if_already_friends__test() throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		Controller c=new Controller();
		c.setdb(db);
		
		when(db.cif_already_friends("user1", "user2")).thenReturn(true);	
        boolean ans=c.cif_already_friends("user1", "user2");	
		assertTrue(ans);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void if_already_friends_IllegalArgs_test() throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		Controller c=new Controller();
		c.setdb(db);
		
		when(db.cif_already_friends("user1", "user2")).thenReturn(true);	
        boolean ans=c.cif_already_friends(null, "");	
		assertTrue(ans);
		
	}
	
}
