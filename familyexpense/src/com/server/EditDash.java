package com.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;

/**
 * Servlet implementation class EditDash
 */
public class EditDash extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDash() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        User user = new User();
        Double SUM=.0;

	    HttpSession session = request.getSession();
        String expensesmail = (String)session.getAttribute("keyEmail");
	    SUM = (Double)session.getAttribute("KeySum");
	
	  String mail = (String)session.getAttribute("keyEmail");
	
		out.print("Welcome Home Dear User. Today is "+new Date()+"<br/>");
	   
	
	    	out.print(" Email:"+expensesmail);
	
		out.print("<html><body><h3>Welcome your Dashboard<br/><br/><a href='ForgetPassword.html'>Account Settings</a></h3></body></html>");	
	
		out.print("<html><body><h3><br/><a href='expenses.html'>per day Amount</a></h3></body></html>");	
	
		
		
	
		out.print("<html><body><h3><a href='registereduser.html'>Logout</a></h3></body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
