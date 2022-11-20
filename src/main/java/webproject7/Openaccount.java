
package webproject7;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Openaccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String account = request.getParameter("user_account");
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String birthday = request.getParameter("birthday");
		String licence = request.getParameter("licenceNumber");
		String pin = request.getParameter("pin");
		String que1 = request.getParameter("question1");
		String ans1 = request.getParameter("answer1");
		String que2 = request.getParameter("question2");
		String ans2 = request.getParameter("answer2");
		String que3 = request.getParameter("question3");
		String ans3 = request.getParameter("answer3");
		String que4 = request.getParameter("question4");
		String ans4 = request.getParameter("answer4");
		String balance = request.getParameter("balance");
		String cond = request.getParameter("condition");
		
		
		if(pin.length()==4) {
			
		out.print("<html><head><link rel='stylesheet' href='Style.css'></head><body>");
		out.println("<div><h4>Your account type: "+account);
		out.println("<br><br>Your First Name: "+firstname);
		out.println("<br><br>Your Last Name: "+lastname);
		out.println("<br><br>Your Birthdate: "+birthday);
		out.println("<br><br>Your PIN: "+pin);
		out.println("<br><br>Your account balance: "+balance);
		
		
		
		LocalDate date =  LocalDate.parse(birthday);
		int day = date.getDayOfMonth();
		int year = date.getYear();
		
		ServletContext ctx = getServletContext();
		out.println("<br><br><p1>Your account Number is: "+day+licence+year+"</p1>");
		String accnum = day+licence+year;
		
				try {
		
		Connection con = (Connection) ctx.getAttribute("mycon");
		PreparedStatement ps = con.prepareStatement("insert into accountdetail values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, null);
		ps.setString(2, account);
		ps.setString(3, accnum);
		ps.setString(4, pin);
		ps.setString(5, firstname);
		ps.setString(6, lastname);
		ps.setString(7, birthday);
		ps.setString(8, licence);
		ps.setString(9, balance);
		ps.setString(10, que1);
		ps.setString(11, ans1);
		ps.setString(12, que2);
		ps.setString(13, ans2);
		ps.setString(14, que3);
		ps.setString(15, ans3);
		ps.setString(16, que4);
		ps.setString(17, ans4);
		
		int i = ps.executeUpdate();
		
		
		out.print("<br><br><a href='loginaccount.jsp'>LOGIN</a>");
		
		
		out.print("<br><br>Your account is successfully Open...</h4></div>");
				
		}
				
		catch(Exception e) {
			System.out.println(e);
		}

	}
		else {
			out.print("<html><head><link rel='stylesheet' href='Style.css'></head><body>");
			out.print("<br><div><h4><p>please enter correct pin.....<p></h4></div>");
			out.print("</body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("openaccount.jsp");
			rd.include(request, response);
			
		}

	}

	
}
