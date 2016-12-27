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
 * Servlet implementation class ViewForumModServletSelf
 */
@WebServlet("/ViewForumModServletSelf")
public class ViewForumModServletSelf extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter(); 
		HttpSession sess= request.getSession(true);
		String name=(String)sess.getAttribute("Username");
		
		List<String[]> forums = new ArrayList<String[]>();
        ResultSet rs=null;
		
		try
		{			
			rs=Controller.view_forums();
			//Forum fobj;
			int i=0;
			while(rs.next())
			{
				String[] oneforum=new String[4];
				oneforum[0]=rs.getString(2);   //forum title
				oneforum[1]=rs.getString(3);  //forum url
				oneforum[2]=rs.getString(4);   	//forum summary
				oneforum[3]=rs.getString(7);	//created by
				i++;
				forums.add(oneforum);
			}
			
			if(i!=0){
				request.setAttribute("allforums",forums);
				request.setAttribute("message","Forums");
			}
			else{
				request.setAttribute("message", "No Forum");
			}
			request.setAttribute("allforums",forums);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewAllForumsMod.jsp");
			dispatcher.forward(request, response);
		}
		catch (Exception e)
		{
			System.out.println("Caught in ViewForumsModServlet");
		}

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter(); 
		HttpSession sess= request.getSession(true);
		String name=(String)sess.getAttribute("Username");
		
		List<String[]> forums = new ArrayList<String[]>();
        ResultSet rs=null;
		
		try
		{			
			rs=Controller.view_forums();
			//Forum fobj;
			
			while(rs.next())
			{
				String[] oneforum=new String[4];
				oneforum[0]=rs.getString(2);   //forum title
				oneforum[1]=rs.getString(3);  //forum url
				oneforum[2]=rs.getString(4);   	//forum summary
				oneforum[3]=rs.getString(7);	//created by
				
				forums.add(oneforum);
			}
			
			
			request.setAttribute("allforums",forums);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ViewAllForumsMod.jsp");
			dispatcher.forward(request, response);
		}
		catch (Exception e)
		{
			System.out.println("Caught in ViewForumsModServlet");
		}

		
	}

}
