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
 * Servlet implementation class AcceptServlet
 */
@WebServlet("/AcceptServlet")
public class AcceptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public AcceptServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Inside AcceptServlet");
		PrintWriter out = response.getWriter(); 
		HttpSession sess= request.getSession(true);
		String name=(String)sess.getAttribute("Username");
		String frname= request.getParameter("frname");
		String action = request.getParameter("action");

		System.out.println(name);
		System.out.println(frname);

		System.out.println("I have the names of both");
		if("ACCEPT".equals(action))
		{
			try {
				DatabaseFuncs.respond_to_req(name,frname, 1);
			} catch (Exception e) {
				System.out.println("Caught inAccept request Servlet Exception");
				e.printStackTrace();
			} 
			System.out.println("I have responded to accept request");
			response.sendRedirect("UserPage.jsp");

		}
		else{
			try {
				DatabaseFuncs.respond_to_req(name,frname, 2);
			} catch (Exception e) {
				System.out.println("Caught inReject request Servlet Exception");
				e.printStackTrace();
			} 
			System.out.println("I have responded to reject request");
			response.sendRedirect("UserPage.jsp");

		}

	}

}
