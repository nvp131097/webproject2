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

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

/**
 * Servlet implementation class Deposite
 */
public class Deposite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
	String deposite = req.getParameter("deposite");
		try {
			ServletContext ctx = getServletContext();
			Connection con = (Connection) ctx.getAttribute("mycon");
			
			String accnum = (String) ctx.getAttribute("accountnum");
			PreparedStatement ps = con.prepareStatement("Select Balance from accountdetail where Account_Num=?");
			
			ps.setString(1, accnum);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				double deposite1 = Double.parseDouble(deposite);
				double b1 = rs.getDouble(1)+deposite1;
				
				out.print("<html><body><div>");
				out.print("<br><h4><p>Your updated balance is: "+b1+"</p></h4>");
				out.print("</div></body></html>");
				RequestDispatcher rd = req.getRequestDispatcher("action.jsp");
				rd.include(req, resp);
				
				PreparedStatement ps1 = con.prepareStatement("update accountdetail set Balance=? where Account_Num=?");
				ps1.setDouble(1, b1);
				ps1.setString(2, accnum);
				
				ps1.executeUpdate();
				
			
				
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
       
    
}
