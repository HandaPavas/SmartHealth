package root;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	String email=null;
	String pass=null;

	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		 PrintWriter out = response.getWriter(); 
		try
		{
			
			email=request.getParameter("email");
			pass=request.getParameter("password");
		
			int ans= Controller.check_login_details(email,pass);// checks validity of login details
			if(ans==0)
			{
				out.print("Wrong Details");
				response.sendRedirect("main.html");
			}
			else if(ans==3)
			{
				String username= Controller.get_username(email,pass);//if enduser then passes to userPage
				HttpSession sess= request.getSession(true);
				sess.setAttribute("Username", username);
				response.sendRedirect("UserPage.jsp");

				out.print("Successful Login");
				
			}
			else if(ans==2){
				String username= Controller.get_username(email,pass);//if moderator then passes to ModeratorPage
				HttpSession sess= request.getSession(true);
				sess.setAttribute("Username", username);
				response.sendRedirect("ModeratorPage.jsp");
			}
			
		}
		 catch (Exception e)
		{
			System.out.println("Caught  Exception");
		}
		
	}

}

