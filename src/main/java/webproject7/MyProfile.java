package webproject7;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyProfile
 */
public class MyProfile extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		response.setHeader("Cache-Control", "no-cache");
		 response.setHeader("Cache-control", "no-store");
		 response.setHeader("Pragma", "no-cache");
		 response.setHeader("Expires","0");
		 response.setDateHeader("Expires",0);
		 
		 
		 HttpSession session = request.getSession(false);
			
		 String accnum = (String) session.getAttribute("accountnum");
			
		out.print("<html><title>Apna Bank</title><head><link rel='stylesheet' href='Style.css'></head><body>");
		out.print("<div><h1>Apna Bank</h1>");
		out.print("<h3>Welcome to My Profile</h3>");
		out.print("<h3><p1>Account Number: "+accnum+"</p1></h3>");
		out.print("<br><form action='action.jsp'><input type='submit' value='Home'></form>");
		out.print("<br><form action='Logoutaccount'><input type='submit' value='Logout'></form>");
		out.print("</div></body></html>");
		}
	

}
