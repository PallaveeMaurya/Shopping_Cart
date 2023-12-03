package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebServlet("/test2")
public class SessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out= response.getWriter();
		 
		 //getting old session object for the same user
		 HttpSession session=request.getSession(false);
		 if(session==null) {
			 out.println("<h1>No session information available wrt the user</h1>");
		 }else {
			 out.println("<table border='2'><tr><th>AttributeName</th><th>AttributeValue</th></tr>");
			 
			 //Retrieving the information from session object and process data
			 Enumeration<String> names=session.getAttributeNames();
			 
			 //Process the information using while loop from enumeration object
			 
			 while(names.hasMoreElements()) {
				 String name=(String) names.nextElement();
				 Object value=session.getAttribute(name);
				 out.println("<tr><td>"+name+"</td><td>"+value+"</td></tr>");
			 }
			 out.println("</table>");
			 
			 //Extra information is also retrieved
			 long creationTime= session.getCreationTime();
			 long lastAccessedTime=session.getLastAccessedTime();
			 int maxInactiveInterval=session.getMaxInactiveInterval();
			 out.println("<h1>Creation Time is:: "+ new Date(creationTime)+ "</h1>");
			 out.println("<h1>Last Accessed Time is:: "+ new Date(lastAccessedTime)+ "</h1>");
			 out.println("<h1>Max Inactive Interval is:: "+ new Date(maxInactiveInterval)+ "</h1>");

		 }
		 out.close();
	}

}
