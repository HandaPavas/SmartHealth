package root;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Comment {

	private String commenter;
	private String commenttext;
	private String picloc,linkloc,vidloc;
	
	
	Comment(String cter,String ctext,String pl,String tl,String vl)
	{
		commenter=cter;
		commenttext=ctext;
		picloc=pl;
		linkloc=tl;
		vidloc=vl;
	}
	String getcommenter()
	{
		return commenter;
	}
	String getcommenttext()
	{
		return commenttext;
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
	
	void create_comment(String createdbyuser) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		
		commenter=createdbyuser;
		System.out.println("Enter the comment");
		commenttext=br.readLine();
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
