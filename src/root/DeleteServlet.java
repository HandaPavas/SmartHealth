package root;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request,response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess= request.getSession(true);
		String name=(String)sess.getAttribute("Username");
		try {
			Controller.delete_profile(name);//delete Profile set the status to '2'so that it won't be visible to other users
			response.sendRedirect("UserPage.jsp");
		}
		catch (Exception e) {
			
			System.out.println("Caught in Delete Servlet Exception");
		}
		
	}

}
