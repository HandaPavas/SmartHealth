package root;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Forum {
	private static int forum_id=0;
	private String topic,url,summary;
	private String createdby,deletedby;
	
	Forum(int id,String tpic,String furl,String fsummary,String cby,String dby)
	{
		forum_id=id;
		topic=tpic;
		url=furl;
		summary=fsummary;
		createdby=cby;
		deletedby=dby;
	}
	int getforumid()
	{
		return forum_id;
	}
	String getftopic()
	{
		return topic;
	}
	String getfurl()
	{
		return url;
	}
	String getfsummary()
	{
		return summary;
	}
	String getfcreatedby()
	{
		return createdby;
	}
	String getfdeletedby()
	{
		return deletedby;
	}
	void create_forum(String createdbymod) throws IOException, ClassNotFoundException, SQLException
	{
		boolean ans=false;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		forum_id=DatabaseFuncs.getforum_id();
		while(ans==false)
		{System.out.println("Enter topic of forum");
		topic=br.readLine();
		ans=DatabaseFuncs.check_unique_forum_name(topic);
		if(ans==false)
		{
			System.out.println("Topic name already exists! Enter again!!");
		}
		}
		ans=false;
		while(ans==false)
		{
		System.out.println("Enter url of forum");
		url=br.readLine();
		ans=DatabaseFuncs.check_unique_forum_url(url);
		if(ans==false)
		{
			System.out.println("URL  already exists! Enter again!!");
		}
		}
		System.out.println("Enter summary of forum");
		summary=br.readLine();
		createdby=createdbymod;	

	}
	

	
	

}
