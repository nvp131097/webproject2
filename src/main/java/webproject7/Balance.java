package webproject7;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Balance
 */
public class Balance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	String deposite = request.getParameter("deposite");
		try {
			ServletContext ctx = getServletContext();
			Connection con = (Connection) ctx.getAttribute("mycon");
			
			String accnum = (String) ctx.getAttribute("accountnum");
			PreparedStatement ps = con.prepareStatement("Select Balance from accountdetail where Account_Num=?");
			
			ps.setString(1, accnum);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				double b1 = rs.getDouble(1);
				out.print("<html><head><link rel='stylesheet' href='Style.css'></head><body><div>");
				out.print("<br><h4><p>Your balance is: "+b1+"</p></h4>");
				RequestDispatcher rd = request.getRequestDispatcher("action.jsp");
				rd.include(request, response);
				out.print("</div></body></html>");
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
