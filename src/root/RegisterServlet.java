package root;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	String email1=null;
	String email2=null;
	String username=null;
	String password=null;
	String firstname=null;
	String lastname=null;
	String pic1=null;
	String pic2=null;
	String pic3=null;
	String streetnumber=null;
	String streetname=null;
	String municipality=null;
	String postalarea=null;
	String district=null;
	String usertype=null;
	String phone=null;
	String about=null;

	boolean ans,anse;
	boolean ans2;
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		PrintWriter out = response.getWriter(); 
		try
		{

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
			usertype=request.getParameter("usertype");
			phone=request.getParameter("phonenumber");
			about=request.getParameter("about");
			ans2=true;
			ans=DatabaseFuncs.check_unique_username(username);//Checks Usernames Uniqueness
			anse=DatabaseFuncs.check_unique_email(email1);//Checks Email's Uniqueness
			if(email1.equals(email2)){//Checks whether Email1 not similar to email2
				ans2=false;
			}




			if(anse==false||ans==false || ans2==false)
			{
				System.out.println("Username  or Email Id Already Exist !!");
				out.print("Wrong Details");
				response.sendRedirect("Register.jsp");
			}
			else 
			{
				out.print(usertype);
				if(usertype.equals("enduser")){//Call Enduser Object If Usertype selected is Enduser
					EndUser ureg=new EndUser(username, password,email1,email2,firstname, lastname, about,
							pic1,pic2, pic3,streetnumber,streetname, municipality, district,
							postalarea);
					
					/*ureg.putdata( email1,email2,username, password,firstname, lastname,
							pic1,pic2, pic3,streetnumber,streetname, municipality,
							postalarea, district, about);*/
					
					Controller.Add_user_to_database(ureg);
					response.sendRedirect("main.html");

					out.print("Enduser Successfully Registered");

				}
				else{//Call Moderator Object If Usertype selected is Moderator

					Moderator mreg=new Moderator(username, password,email1,email2,firstname, lastname, about,
							pic1,pic2, pic3,streetnumber,streetname, municipality, district,
							postalarea, phone);
					
					/*mreg.putdata( email1,email2,username, password,firstname, lastname,
							pic1,pic2, pic3,streetnumber,streetname, municipality,
							postalarea, district, about, phone);*/
				
					Controller.Add_moderator_to_database(mreg);
					
					response.sendRedirect("main.html");

					out.print("Moderator Successfully Registered");
				}
			}

		}
		catch (Exception e)
		{
			System.out.println(e);
		}

	}

}
