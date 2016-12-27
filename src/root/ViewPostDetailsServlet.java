package root;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewPostDetailsServlet
 */
@WebServlet("/ViewPostDetailsServlet")
public class ViewPostDetailsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pname=request.getParameter("postname");
		String ptime=request.getParameter("posttime");
		String poststr=request.getParameter("postdis");
		//System.out.println(furl);
		List<String[]> comments = new ArrayList<String[]>();
         ResultSet rs=null;
		
		try
		{	
			//furl=request.getParameter("furl");
		
			rs=Controller.view_comments_on_post(pname, ptime);
			
			while(rs.next())
			{
				String[] onepost=new String[2];
				onepost[0]=rs.getString(3);   //commenter
				onepost[1]=rs.getString(5);   //comment
				//onepost[2]=rs.getString(4);    //post text
				
				comments.add(onepost);
			}
			
			
			request.setAttribute("poststr", poststr);
			request.setAttribute("allcomments",comments);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewCommentsOnPost.jsp");
			dispatcher.forward(request, response);
	}
		catch (Exception e)
		{
			System.out.println("Caught in ViewPostDetailsServlet");
		}
	}
	

}
