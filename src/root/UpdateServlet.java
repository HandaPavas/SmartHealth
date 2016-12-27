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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {

	String email1,email2,username, password, firstname,lastname, pic1,pic2,pic3,streetnumber,streetname, municipality,
	postalarea, district,usertype,phone,about;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter(); 
		HttpSession sess= request.getSession(true);
		String name=(String)sess.getAttribute("Username");
		try
		{
			//retrieves all your's information

			email1=request.getParameter("email1");
			email2=request.getParameter("email2");
			password=request.getParameter("password");
			username=request.getParameter("username");
			firstname=request.getParameter("firstname");
			lastname=request.getParameter("lastname");
			pic1=request.getParameter("pic1");
			pic2=request.getParameter("pic2");
			pic3=request.getParameter("pic3");
			streetnumber=request.getParameter("streetnumber");
			streetname=request.getParameter("streetname");
			municipality=request.getParameter("municipality");
			postalarea=request.getParameter("postaladdress");
			district=request.getParameter("district");
			System.out.println("Inside Update Servlet");
			usertype=request.getParameter("usertype");
			System.out.println("Got UserType");
			System.out.print(usertype);
			about=request.getParameter("aboutme");

			
			if(usertype.equals("3/")){//if enduser
				System.out.println("You are EndUser");
				EndUser ureg=new EndUser( username, password,email1,email2,firstname, lastname, about,
						pic1,pic2, pic3,streetnumber,streetname, municipality, district,
						postalarea);
				System.out.println("Entered Inside Enduser Update");
				/*ureg.putdata( email1,email2,username, password,firstname, lastname,
							pic1,pic2, pic3,streetnumber,streetname, municipality,
							postalarea, district, about);*/

				Controller.update_user_in_database(ureg);
				response.sendRedirect("UserPage.jsp");

				System.out.print("Enduser Successfully Registered");

			}
			else{//if moderator
				phone=request.getParameter("phone");

				Moderator mreg=new Moderator(username, password,email1,email2,firstname, lastname, about,
						pic1,pic2, pic3,streetnumber,streetname, municipality, district,
						postalarea, phone);

				/*mreg.putdata( email1,email2,username, password,firstname, lastname,
							pic1,pic2, pic3,streetnumber,streetname, municipality,
							postalarea, district, about, phone);*/

				Controller.update_moderator_in_database(mreg);

				response.sendRedirect("UserPage.jsp");

				out.print("Moderator Successfully Registered");
			}


		}
		catch (Exception e)
		{
			System.out.println(e);
		}

	}
}


