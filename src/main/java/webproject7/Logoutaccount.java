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
 * Servlet implementation class Logoutaccount
 */
public class Logoutaccount extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		out.print("<html><title>Apna Bank</title><head><link rel='stylesheet' href='Style.css'></head><body>");
		out.print("<div><h1>Apna Bank</h1>"); 
		out.print("<br><h4><p>You are successfully Logged out.....</p></h4>");
		out.print("<br><a href='index.jsp'>HOME PAGE</a>");
		out.print("</div></body></html>");
		
	}

	

}
