package root;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CreateForumServlet")
public class CreateForumServlet extends HttpServlet {
	
	List<Forum> forums = new ArrayList<Forum>();
	
	String forum_title,forum_url,forum_summary;
	int forum_id;
	//Forum fobj;
	//Change these things.Make them accessible by forum type object.
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		HttpSession sess= request.getSession(true);
		String name=(String)sess.getAttribute("Username");
		
		try
		{
			boolean ans;
			forum_title=request.getParameter("forumtitle");
			forum_url=request.getParameter("forum_url");
			forum_summary=request.getParameter("forum_summary");
			
			ans=DatabaseFuncs.check_unique_forum_name(forum_title);
			if(ans==false)
			{
				System.out.println("ForumName Already Exist !!");
				out.print("Forum Title already exists");
				response.sendRedirect("CreateForum.jsp");
			}
			else
			{
				ans=DatabaseFuncs.check_unique_forum_url(forum_url);
				if(ans==false)
				{
					System.out.println("Forum Url Already Exist !!");
					out.print("Forum URL already exists");
					response.sendRedirect("CreateForum.jsp");
				}
				else
				{
					forum_id=DatabaseFuncs.getforum_id();
					Forum fobj=new Forum(forum_id,forum_title,forum_url,forum_summary,name,null);
					Controller.create_forum(fobj);
					forums.add(fobj);
					request.setAttribute("allforums",forums);
					response.sendRedirect("ModeratorPage.jsp");
					out.print("Forum successfully created");
										
					
				}
			}
			

			


		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		
		
		
		
	}

}
