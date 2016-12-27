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


@WebServlet("/PostonForumServlet")
public class PostonForumServlet extends HttpServlet {
	
	
	//Make a function in controller class that returns a string that contains all posts related to a a forum.
	//Format that string using \ns and all.
	String furl,posttext,piclink,tlink,vidlink;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		PrintWriter out = response.getWriter(); 
		HttpSession sess= request.getSession(true);
		String name=(String)sess.getAttribute("Username");
		
		
		try
		{
			furl=request.getParameter("furl");
			posttext=request.getParameter("posttext");
			piclink=request.getParameter("piclink");
			tlink=request.getParameter("tlink");
			vidlink=request.getParameter("vlink");
			
			
					Post pobj=new Post(name,furl,posttext,piclink,tlink,vidlink);
					Controller.create_post(pobj);
					response.sendRedirect("ViewForumsServlet");
					out.print("Post successfully created");
					
			

		}
		catch (Exception e)
		{
			System.out.println("Caught in PostonForumServlet");
		}

		
		
	}

}
