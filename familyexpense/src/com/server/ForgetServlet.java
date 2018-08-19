package com.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.JDBCHelper;
import com.model.User;

/**
 * Servlet implementation class ForgetServlet
 */
@WebServlet({ "/Forget", "/ForgetServlet" })
public class ForgetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ForgetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("--Request Came--");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int forget=0;
		User user = new User();
		
		user.userEmail= request.getParameter("txtEmail");
		user.userSecurityQuestion = request.getParameter("nick");
		user.userPassword = request.getParameter("textpassword");
		
		JDBCHelper helper = new JDBCHelper();
		helper.openConnection();
		 forget = helper.forget(user);
		 System.out.println(forget+" Row(s) inserted");
		helper.closeConnection();
		
		if(forget>0){
			
			HttpSession session = request.getSession();
			//session.setAttribute("keyName", "Fionna");
			session.setAttribute("keyEmail", user.userEmail);
			
			request.getRequestDispatcher("registereduser.html").forward(request, response);
			
			//out.print("<html><body><h3>Login is a Success<br/><br/><a href='registereduser.html'>LogIn</a></h3></body></html>");	
		}else{
			
			out.print("Some error kuch bhi");
			request.getRequestDispatcher("ForgetPassword.html").include(request, response);
		}
		
	}
	}


