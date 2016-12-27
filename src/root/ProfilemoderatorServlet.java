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
 * Servlet implementation class ProfilemoderatorServlet
 */
@WebServlet("/ProfilemoderatorServlet")
public class ProfilemoderatorServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);

}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		HttpSession sess= request.getSession(true);
		String name=(String)sess.getAttribute("Username");

		try{

			Moderator uobj=Controller.get_moderator_details(name);//retrieves all the details of the Moderator
			System.out.println("Object Value Retrieved");
			//	System.out.println(uobj.username);

			sess.setAttribute("username", uobj.username);
			System.out.println(uobj.username);
			sess.setAttribute("email1", uobj.emailid1);
			sess.setAttribute("email2", uobj.emailid2);
			sess.setAttribute("password", uobj.password);
			sess.setAttribute("firstname", uobj.fname);
			sess.setAttribute("lastname", uobj.lname);
			sess.setAttribute("streetnumber", uobj.streetnum);
			sess.setAttribute("streetname", uobj.streetname);
			sess.setAttribute("municipality", uobj.muncipty);
			sess.setAttribute("district", uobj.district);
			sess.setAttribute("postaladdress", uobj.postarea);
			sess.setAttribute("pic1", uobj.pic1);
			sess.setAttribute("pic2", uobj.pic2);
			sess.setAttribute("pic3", uobj.pic3);
			sess.setAttribute("aboutme", uobj.aboutme);
			sess.setAttribute("usertype", uobj.usertype);
			sess.setAttribute("phonenumber", uobj.getMPhone());

			response.sendRedirect("ProfileModerator.jsp");

		}catch(Exception e)
		{
			System.out.println("Caught Exception");
		}
	
}

}
