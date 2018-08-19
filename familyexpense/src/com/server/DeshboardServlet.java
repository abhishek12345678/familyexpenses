package com.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.JDBCHelperExpenses;
import com.model.Expenses;
import com.model.User;

/**
 * Servlet implementation class DeshboardServlet
 */
@WebServlet({ "/DeshboardServlet", "/Deshboard", "/desh.do" })
public class DeshboardServlet extends HttpServlet {
	private static final Object Date = null;


	public void init(ServletConfig config) throws ServletException {
		System.out.println("--Servlet Initialized--");
	}

	
	public void destroy() {
		System.out.println("--Servlet Destroyed--");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        User user = new User();
        Date dd=new Date();
      
       String month="";
    
       Double SUM=.0;
      
       

		user.userEmail= request.getParameter("txtEmail");
	
	    HttpSession session = request.getSession();
  
       session.setAttribute("keyEmail", user.userEmail);
	  //  SUM = (Double)session.getAttribute("KeySum");
		session.setAttribute("keyEmail", user.userEmail);
		out.print("Welcome Home Dear User. Today is "+dd+"<br/>");
		   	out.print("Email Id:"+user.userEmail);
	  
		out.print("<html><body><h3>Welcome your Dashboard<br/><br/><a href='accountsetting.html'>Account Settings</a></h3></body></html>");	
	
		out.print("<html><body><h3><a href='expenses.html'>Click for Enter Your Perday Amount</a></h3></body></html>");	
	
		out.print("<html>");
		out.print("<body>");
		out.print("<form action='show' method='get'>");
		out.print("for show by Date");
		out.print("<input style='color:blue;margin-left:30px;' type='number' name='showdate' placeholder='MM/DD/YYYY' required>");
		out.print("for show by monthly");
		out.print("<input type='number' name='monthly' placeholder='march' required>");
		
		out.print("<input type='submit' name='show' value='show' >");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
		
		out.print("<html><body><h3><a href='registereduser.html'>Logout</a></h3></body></html>");	
		out.print("<html><body><h3><a href='EstimatedAmount.html'>estimatedamount</a></h3></body></html>");	
		out.print("<html><body><h3><a href='button.html'>seprateupdate</a></h3></body></html>");	
		out.print("<html><body><h3><a href='delete.html'>delete by date</a></h3></body></html>");
		out.print("<html><body><h3><a href='show.html'>show by date and month</a></h3></body></html>");
		// form for show the investment amount
			
		
		
		
	}
		
	
}
