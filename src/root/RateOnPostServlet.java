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
 * Servlet implementation class RateOnPostServlet
 */
@WebServlet("/RateOnPostServlet")
public class RateOnPostServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		PrintWriter out = response.getWriter(); 
		HttpSession sess= request.getSession(true);
		String name=(String)sess.getAttribute("Username");
		String pname=request.getParameter("postname");
		System.out.println("hello3");
		String ptime=request.getParameter("posttime");
		int stars=Integer.parseInt(request.getParameter("rating"));
		
		try
		{
			Controller.rate_on_post(name, pname, ptime, stars);
			out.println("Rating Successful!!");
			
			
		}
		catch (Exception e)
		{
			System.out.println("Caught in CommentonPostServlet");
		}
		
	}

}
