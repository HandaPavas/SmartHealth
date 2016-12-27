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


@WebServlet("/ViewForumDetailsServlet")
public class ViewForumDetailsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String furl=request.getParameter("furl");
		System.out.println(furl);
		List<String[]> posts = new ArrayList<String[]>();
         ResultSet rs=null;
		
		try
		{	
			//furl=request.getParameter("furl");
		
			rs=Controller.view_posts_on_forum(furl);
			
			while(rs.next())
			{
				String[] onepost=new String[3];
				onepost[0]=rs.getString(1);   //postername
				onepost[1]=rs.getString(2);   //time created
				onepost[2]=rs.getString(4);    //post text
				
				posts.add(onepost);
			}
			
			
			request.setAttribute("forumurl", furl);
			request.setAttribute("allposts",posts);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewPostsOnForum.jsp");
			dispatcher.forward(request, response);
	}
		catch (Exception e)
		{
			System.out.println("Caught in ViewForumDetailsServlet");
		}
	}

}
