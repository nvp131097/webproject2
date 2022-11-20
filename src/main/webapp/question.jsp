<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Apna Bank</title>
</head>
<body>
<form method="post">
<%

	ServletContext ctx = getServletContext();
	String answer= (String)ctx.getAttribute("ans");
	String answer1 = request.getParameter("ans");
	
	if(answer.equals(answer1))
	{
		RequestDispatcher rd = request.getRequestDispatcher("action.jsp");
		rd.include(request, response);
	}
	
	else
	{
		out.print("<div><h4><p>Please enter correct information...</p></h4></div>");
		RequestDispatcher rd = request.getRequestDispatcher("loginaccount.jsp");
		rd.include(request, response);
	}
		
%>


</form>

</body>
</html>