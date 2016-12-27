package root;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	
	



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<String> allendusers = new ArrayList<String>();
		PrintWriter out = response.getWriter(); 
		//String[] allendusers=new String[100];
		//int i=0;
		HttpSession session= request.getSession(true);
		String myname=(String)session.getAttribute("Username");
		String name=request.getParameter("searchper");
		try {
			System.out.println("yes 1");
			Boolean ans=Controller.if_user_exists(name);//Checks if Username Exists in database
			Boolean ans1=Controller.if_already_friends(myname, name);//Checks if Already friends 
			System.out.println("yes 2");
			ResultSet rs=Controller.all_end_users(myname);//Retrieves all User which are not friends
			System.out.println("yes 3");
			while(rs.next())
			{
				System.out.println(rs.getString(1));
				allendusers.add(rs.getString(1));
				//allendusers[i]=rs.getString(1);
				//i++;
			}
			System.out.println("yes 5");
			request.setAttribute("endusers",allendusers);
			System.out.println("yes 6");
			if(!ans||myname.equals(name))//checks whether Loggedin is not equals to Search friend
			{
				request.setAttribute("FirstStr", "false");

			}
			else if(ans1){
				response.sendRedirect("ALreadyFriends.jsp");
			}
			else
			{
				request.setAttribute("FirstStr", name);
			}

			System.out.println("yes 7");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/OtherUser.jsp");
			dispatcher.forward(request, response);

		} 
		catch (Exception e) {
			System.out.println("Caught in Search Servlet Exception");
		}

	}

}
