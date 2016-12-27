package root;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddHealthDataServlet")
public class AddHealthDataServlet extends HttpServlet {
	
	String property,value;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		PrintWriter out = response.getWriter(); 
		HttpSession sess= request.getSession(true);
		String name=(String)sess.getAttribute("Username");
		
		try
		{
			//boolean ans;
			System.out.print("property");
			property=request.getParameter("prop");
			value=request.getParameter("propvalue");
			System.out.print(property);
			
			if(property.equals("RUNNING DISTANCE"))
			{
				Controller.add_health_data(1, value, name);
				
			}
			else
				if(property.equals("CALORIES BURNT"))
				{
					Controller.add_health_data(2, value, name);
				}
				else
					if(property.equals("BLOOD PRESSURE"))
					{
						Controller.add_health_data(3, value, name);
					}
			
			
		}
		catch (Exception e)
		{
			System.out.println("Caught in AddHealthDataServlet Exception");
		}

		
		
		
		
	}

}
