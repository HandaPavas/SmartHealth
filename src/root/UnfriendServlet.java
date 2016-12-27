package root;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UnfriendServlet
 */
@WebServlet("/UnfriendServlet")
public class UnfriendServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter(); 
		HttpSession sess= request.getSession(true);
		String name=(String)sess.getAttribute("Username");
		String frname= request.getParameter("frname");
		
		System.out.println("yes "+frname);
		try {
			DatabaseFuncs.unfriend(name, frname);// Unfriends your friend
			response.sendRedirect("ViewFriendServlet");
		} catch (Exception e) {
			System.out.println("Caught in Unfriend Servlet Exception");
			e.printStackTrace();
		}
	}

}
