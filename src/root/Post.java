package root;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Post {

	private String username;
	private String forumurl;
	private String textentry;
	private String picloc,linkloc,vidloc;
	
	
	
	Post(String name,String furl,String text,String pl,String tl,String vl)
	{
		username=name;
		 forumurl=furl;
		 textentry=text;
		 picloc=pl;
		 linkloc=tl;
		 vidloc=vl;
	}
	
	String getforumurl()
	{
		return forumurl;
	}
	String getpuname()
	{
		return username;
	}
	String getptext()
	{
		return textentry;
	}
	String getppic()
	{
		return picloc;
	}
	String getplink()
	{
		return linkloc;
	}
	String getpvid()
	{
		return vidloc;
	}
	
	void create_post(String createdbyuser) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		System.out.println("Enter forum url");
		forumurl=br.readLine();
		username=createdbyuser;
		System.out.println("Enter the post");
		textentry=br.readLine();
		System.out.println("Enter link of pic if any otherwise press N ");
		picloc=br.readLine();
		if(picloc.equals("N"))
		{
			picloc=null;
		}
		
		System.out.println("Enter link  if any otherwise press N ");
		linkloc=br.readLine();
		if(linkloc.equals("N"))
		{
			linkloc=null;
		}
		
		System.out.println("Enter link of video if any otherwise press N ");
		vidloc=br.readLine();
		if(vidloc.equals("N"))
		{
			vidloc=null;
		}
			

	}
	
	
}
