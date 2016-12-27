package root;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CommentOnPostServlet
 */
@WebServlet("/CommentOnPostServlet")
public class CommentOnPostServlet extends HttpServlet {
	
	String comment,piclink,tlink,vidlink,pname,ptime;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		PrintWriter out = response.getWriter(); 
		HttpSession sess= request.getSession(true);
		String name=(String)sess.getAttribute("Username");
		
		
		try
		{
			System.out.println("hello1");
			comment=request.getParameter("commenttext");
			System.out.println(comment);
			piclink=request.getParameter("cpiclink");
			System.out.println(piclink);
			tlink=request.getParameter("ctlink");
			System.out.println(tlink);
			vidlink=request.getParameter("cvlink");
			System.out.println(vidlink);
			System.out.println("hello2");
			pname=request.getParameter("postname");
			System.out.println(pname);
			System.out.println("hello3");
			ptime=request.getParameter("posttime");
			System.out.println(ptime);
			
			System.out.println("hello4");
			Comment cobj=new Comment(name,comment,piclink,tlink,vidlink);
			System.out.println("hello5");
			Controller.post_comment(cobj, pname, ptime);
			
			System.out.println("hello6");
			response.sendRedirect("CommentSuccessful.jsp");
			out.print("Comment successfully created");
			

		}
		catch (Exception e)
		{
			System.out.println("Caught in CommentonPostServlet");
		}

		
	}

}
