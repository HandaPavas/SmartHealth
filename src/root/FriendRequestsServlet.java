package root;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FriendRequestsServlet
 */
@WebServlet("/FriendRequestsServlet")
public class FriendRequestsServlet extends HttpServlet {
	
	//ArrayList friendrequests = new ArrayList();
	//String[] friendrequests = new String[100];
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> friendrequests = new ArrayList<String>();//list storing the names of all friends who have sent you friend requests
		PrintWriter out = response.getWriter(); 
		HttpSession sess= request.getSession(true);
		String name=(String)sess.getAttribute("Username");

		try {
			ResultSet rs=Controller.view_request(name);//calls controller function which views all the requests

			int i=0;
			while(rs.next())
			{
				System.out.println("hello2");
				friendrequests.add(rs.getString(1));
				System.out.println(rs.getString(1));
				i++;

			} 
			if(i!=0)
			{
				//sess.setAttribute("flist",friendlist[--i]);
				request.setAttribute("friendrequests",friendrequests);
				request.setAttribute("message","Friends");
			}
			else
			{
				//sess.setAttribute("friendlist"," ");
				request.setAttribute("message","No Friends");//if no request then set a message with same
			}
			System.out.println("hello3");
			sess.setAttribute("friendlist",friendrequests);
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/ViewFriendRequests.jsp");
			rd.forward(request,response);

			



		} catch (Exception e) {
			System.out.println("Caught in exception");
			e.printStackTrace();
		} 

	}

}
