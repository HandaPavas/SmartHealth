package root;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ViewHealthDataServlet")
public class ViewHealthDataServlet extends HttpServlet {
	
	String frndname;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter(); 
		HttpSession sess= request.getSession(true);
		String name=(String)sess.getAttribute("Username");
		
		try
		{
			frndname=request.getParameter("healthfrnd");
			
			ResultSet rs=Controller.view_friend_health_data(frndname);
			StringBuffer healthdatastr=new StringBuffer(frndname);
			//System.out.print("Health Data of your friend, "+friend);
			String property=null;
			while(rs.next())
			{
				if(Integer.parseInt(rs.getString(3))==1)
				{
					property="Running Distance";
				}
				else
				if(Integer.parseInt(rs.getString(3))==2)
				{
					property="Calories Burnt";
				}
				else
				if(Integer.parseInt(rs.getString(3))==3)
				{
					property="Blood Pressure";
				}
				healthdatastr.append(property+" was : "+rs.getString(4)+" as on Date : "+rs.getString(5)+"\n");
				System.out.println(healthdatastr);
			}
			
			request.setAttribute("healthdatastr",healthdatastr);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HealthDataMainPage.jsp");
			dispatcher.forward(request, response);


		}
		catch (Exception e)
		{
			System.out.println("Caught in ViewHealthDataServlet");
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter(); 
		HttpSession sess= request.getSession(true);
		String name=(String)sess.getAttribute("Username");
		
		try
		{
			frndname=request.getParameter("healthfrnd");
			
			ResultSet rs= DatabaseFuncs.see_friends_health_data(frndname);
			String healthdatastr=frndname+"\n";
			//System.out.print("Health Data of your friend, "+friend);
			String property=null;
			while(rs.next())
			{
				if(Integer.parseInt(rs.getString(3))==1)
				{
					property="Running Distance";
				}
				else
				if(Integer.parseInt(rs.getString(3))==2)
				{
					property="Calories Burnt";
				}
				else
				if(Integer.parseInt(rs.getString(3))==3)
				{
					property="Blood Pressure";
				}
				healthdatastr=healthdatastr+property+" was : "+rs.getString(4)+" as on Date : "+rs.getString(5)+"\n\n";
			}
			
			request.setAttribute("healthdatastr",healthdatastr);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/HealthDataMainPage.jsp");
			dispatcher.forward(request, response);


		}
		catch (Exception e)
		{
			System.out.println("Caught in ViewHealthDataServlet");
		}

		
		
	}

}
