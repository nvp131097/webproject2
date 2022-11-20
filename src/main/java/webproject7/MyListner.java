package webproject7;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class MyListner implements ServletContextListener {

    
   
	
    public void contextInitialized(ServletContextEvent sce)  { 
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root","Nvp@0710");
			ServletContext ctx = sce.getServletContext();
			ctx.setAttribute("mycon",con);
	 
	 }catch (Exception e) {
		 System.out.println(e);
	 }
		
    }
    
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    	ServletContext ctx = sce.getServletContext();
    	Connection con = (Connection) ctx.getAttribute("mycon");
   	 	try {
   	 		con.close();
   	 	}catch(Exception e){
   	 		System.out.println(e);
   	 	}
	}
	
}
