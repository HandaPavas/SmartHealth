package root;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeratorPage {
	
	void showOptionsformoderator(String username) throws NumberFormatException, IOException, SQLException, ClassNotFoundException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nPress\n1.Create a forum\n2.Delete a forum \n3.View Full & all forums\n4.Update Profile\n5.Delete Account\n6.Logout\n");
		int ch=Integer.parseInt(br.readLine());
		while(ch!=6)
		{
		if(ch==1)
		{
			//Controller.create_forum(username);
			
		}
		else
			if(ch==2)
			{
				//Controller.delete_forum(username);
			    
			}
			else
				if(ch==3)
				{
					Controller.view_full_forums();
				}
				else
					if(ch==4)
					{
						
					}
					else
						if(ch==5)
						{
						
						}
		System.out.println("\nPress\n1.Create a forum\n2.Delete a forum \n3.View Full & all forums\n4.Update Profile\n5.Delete Account\n6.Logout\n");
		ch=Integer.parseInt(br.readLine());
	}
					
	}
		

}
