package root;

import java.io.IOException;
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
 * Servlet implementation class ViewFriendServlet
 */
@WebServlet("/ViewFriendServlet")
public class ViewFriendServlet extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> friendlist = new ArrayList<String>();
		PrintWriter out = response.getWriter(); 
		HttpSession sess= request.getSession(true);
		String name=(String)sess.getAttribute("Username");

		try {
			ResultSet rs=Controller.view_friends(name);
			System.out.println("hello");
			

			int i=0;
			while(rs.next())
			{
				System.out.println("hello2");
				friendlist.add(rs.getString(1));
				//System.out.println(friendlist[i]);
				i++;

			
			} //System.out.println("Length "+ friendlist.length);
			
			if(i!=0)
			{
				//sess.setAttribute("flist",friendlist[--i]);
				request.setAttribute("friendlist",friendlist);
				request.setAttribute("message","Friends");
			}
			else
			{
				//sess.setAttribute("friendlist"," ");
				request.setAttribute("message","NO Friends");
			}
			//System.out.println("hello3");
			request.setAttribute("friendlist",friendlist);
		//	System.out.println("hello4");
			//response.sendRedirect("Friends.jsp");
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/ViewFriends.jsp");
			//System.out.println("hello5");
			//response.sendRedirect("ViewFriends.jsp");
			rd.forward(request,response);
			//System.out.println("hello6");
			



		} catch (Exception e) {
			System.out.println(" Friends Caught in exception");
			e.printStackTrace();
		} 

	}

}
