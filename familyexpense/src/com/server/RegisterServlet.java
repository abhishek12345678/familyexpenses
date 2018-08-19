package com.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.JDBCHelper;
import com.model.User;


@WebServlet({ "/RegisterServlet", "/Register", "/Register.do" })
public class RegisterServlet extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("--Servlet Initialized--");
	}

	public void destroy() {
		System.out.println("--Servlet Destroyed--");
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--Request Came--");
		Connection con = null;
		
		Statement stmt;
		PreparedStatement pStmt;
		
		User user = new User();
		int i=0;
		int i1=0;
		user.userName = request.getParameter("txtName");
		user.userEmail = request.getParameter("txtEmail");
		user.userPhone = request.getParameter("phone");
		user.userPassword = request.getParameter("txtPassword");
		user.userSecurityQuestion=request.getParameter("nick");
		//System.out.println("Data Received: "+name+" - "+email+" - "+password);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		System.out.println(user);
		
		if( user.userName.isEmpty()  || user.userEmail.isEmpty() || user.userPhone.isEmpty() || user.userPassword.isEmpty() || user.userSecurityQuestion.isEmpty() ) {
		
			
			String st="<link href='css/blink.css' rel='stylesheet'>";
			out.print("<html>");
			out.print("<head>"+st+"</head>");
			out.print("<body>");
			out.print("<h1 style= text-align:center><blink>Enter all field</blink></h1>");
			out.print("</body>");
			out.print("</html>");
			request.getRequestDispatcher("party.html").include(request, response);
			request.getRequestDispatcher("newuser.html").include(request, response);
		}
		else
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("--Driver Loaded--");
			} catch (Exception e) {
				System.out.println("Exception "+e);
			}
			
			try {
				String url = "jdbc:mysql://localhost/familyexpensesdb";
				String user1 = "root";
				String password = "";
				
				con = DriverManager.getConnection(url, user1, password);
				System.out.println("--Connection Opened--");
				
			} catch (Exception e) {
				System.out.println("Exception "+e);
			}

			//int i = 0;
			
			try {
				
				String sql = "insert into users values(?,?,?,?,?)";
				pStmt = con.prepareStatement(sql);
				pStmt.setString(1, user.userEmail);
				pStmt.setString(2, user.userName);
				pStmt.setString(3,user.userPassword);
				pStmt.setString(4, user.userPhone);
				pStmt.setString(5, user.userSecurityQuestion);
				
				i = pStmt.executeUpdate();
				JDBCHelper helper = new JDBCHelper();
				helper.openConnection();
				//i = helper.registerUser(user);
				i1 = helper.estimated(user);
				helper.closeConnection();
				System.out.println(i+" Row(s) inserted");
				
			} catch (Exception e) {
				System.out.println("Exception "+e);
				Exception b=e;
				
				out.print("please follow the proper syntax and email already exist");
				out.print("<html>");
				out.print("<body>");
				out.print("<form action='newuser.html' method='get'>");
				out.print("<input type='submit' name='Back' value='Back' >");
				out.print("</form>");
				out.print("</body>");
				out.print("</html>");
				
			}
			
			//out.print("Enter all field");
			//request.getRequestDispatcher("newuser.html").include(request, response);
		}
		
		
		if(i>0){
			
			if(i1>0)
			//out.print("<html><body><h3>Registered Successfully<br/><br/><a href='registereduser.html'>Enter Home</a></h3></body></html>");
			request.getRequestDispatcher("registereduser.html").forward(request, response);
			
			
		}
		
	}


	
}