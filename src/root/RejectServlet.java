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
 * Servlet implementation class RejectServlet
 */
@WebServlet("/RejectServlet")
public class RejectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RejectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter(); 
		HttpSession sess= request.getSession(true);
		String name=(String)sess.getAttribute("Username");
		String frname= request.getParameter("requestername");
		
		try {
			Controller.respond_to_request(name,frname, 2);
			response.sendRedirect("FriendRequestsServlet");
		} catch (Exception e) {
			System.out.println("Caught in Reject request Servlet Exception");
			e.printStackTrace();
		}
		
	}
		//doGet(request, response);
	

}
