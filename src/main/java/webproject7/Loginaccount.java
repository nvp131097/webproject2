package webproject7;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Loginaccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		response.setHeader("Cache-Control", "no-cache");
		 response.setHeader("Cache-control", "no-store");
		 response.setHeader("Pragma", "no-cache");
		 response.setHeader("Expires","0");
		 response.setDateHeader("Expires",0);
		
		String accnum = request.getParameter("accountnum");
		String pin = request.getParameter("pin");
		
		
		
		
		ServletContext ctx = getServletContext();
		ctx.setAttribute("accountnum", accnum);
		try {
			Connection con = (Connection) ctx.getAttribute("mycon");
			PreparedStatement ps = con.prepareStatement("select PIN,que1,ans1,que2,ans2,que3,ans3,que4,ans4 from  accountdetail where Account_Num=?");
			
			ps.setString(1, accnum);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				if(pin.equals(rs.getString(1))){
					
					HttpSession session = request.getSession();
					session.setAttribute("accountnum", accnum);
					
					ArrayList<String> question = new ArrayList<String>();
					question.add(rs.getString(2));
					question.add(rs.getString(4));
					question.add(rs.getString(6));
					question.add(rs.getString(8));
					
					ArrayList<String> answer = new ArrayList<String>();
					answer.add(rs.getString(3));
					answer.add(rs.getString(5));
					answer.add(rs.getString(7));
					answer.add(rs.getString(9));
					
					Random r = new Random();
					int i = r.nextInt(4);
					String question1 = question.get(i);	
					//out.print(question1);
					
					String answer1 = answer.get(i);	
					
					
					ctx.setAttribute("ans", answer1);
					
					out.print("<html><head><link rel='stylesheet' href='Style.css'><title>Apna Bank</title></head><body>");
					out.print("<div><form action='question.jsp'>");
					out.print("<br><h1>Apna Bank</h1>");
					out.print("<br><h2>Security question: </h2><br>"+question1);
					out.print("<br><br><input type='text' name='ans'>");
					out.print("<br><br><input type='submit' value='submit'>");
					out.print("</form></div>");
					out.print("</body></html>");
					
				}
				else {
					out.print("<br><div><h3><p>please enter correct pin...<p></h3></div>");
					RequestDispatcher rd = request.getRequestDispatcher("loginaccount.jsp");
					rd.include(request, response);
				}
		}
			
	}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
