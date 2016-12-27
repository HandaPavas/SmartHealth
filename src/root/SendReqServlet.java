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
 * Servlet implementation class SendRequest
 */
@WebServlet("/SendReqServlet")
public class SendReqServlet extends HttpServlet {



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sess= request.getSession(true);
		String name=(String)sess.getAttribute("Username");
		String sendto=request.getParameter("frname");
		try {
			
				boolean ans= DatabaseFuncs.check_if_entry_friend(name,sendto);//Checks if already friends
				if(!ans)
				{
					ans= DatabaseFuncs.check_if_already_sent_friend(name,sendto);//Checks if already sent friend request
					if(ans){
						response.sendRedirect("FriendReqAlready.jsp");
					}
					else
						DatabaseFuncs.send_request(name,sendto);
				}

				//request.setAttribute("SentRequest?","yes");
				response.sendRedirect("UserPage.jsp");
			
			
		} catch (Exception e) {

			System.out.print("Caught in SendReqServlet Exception");
		}


	}

}
