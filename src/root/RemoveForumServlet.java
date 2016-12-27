package root;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RemoveForumServlet
 */
@WebServlet("/RemoveForumServlet")
public class RemoveForumServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter(); 
		HttpSession sess= request.getSession(true);
		String name=(String)sess.getAttribute("Username");
		
		try{
			
		
		String furl=request.getParameter("furl");
		Controller.delete_forum(name, furl);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ModeratorPage.jsp");
		dispatcher.forward(request, response);
		
		}
		catch (Exception e)
		{
			System.out.println("Caught in RemoveForumServlet");
		}
		
	}

}
