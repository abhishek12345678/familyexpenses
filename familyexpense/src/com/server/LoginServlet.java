package com.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.db.JDBCHelper;
import com.model.User;


@WebServlet({ "/LoginServlet", "/Login.do" })
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("--Request Came--");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		User user = new User();
		
		user.userEmail= String.format(request.getParameter("txtEmail"));
		user.userPassword = String.format(request.getParameter("txtPassword"));
		int i1 = 0;
Connection con = null;
		
		Statement stmt;
		PreparedStatement pStmt;
		
		JDBCHelper helper = new JDBCHelper();
		helper.openConnection();
		boolean login = helper.loginUser(user);
		helper.closeConnection();
		
		if(login){
			
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
			String sql = "select userName from users where userEmail=? ";
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, user.userEmail);
						ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()){
				
			
				user.userName = rs.getString(1);
				
				
				
				

				System.out.println(i1+" Row(s) all rows are selected");
			}
		}
		 catch (Exception e) {
			System.out.println("Exception "+e);
		}
			
			// String message = "Hello World";
		     request.setAttribute("name", user.userName);
		       request.setAttribute("keyEmail", user.userEmail); // This will be available as ${message}
		        request.getRequestDispatcher("hello.jsp").forward(request, response);
			
			//request.getRequestDispatcher("deshboard.html").forward(request, response);
			
		}else{
			
			
			String st="<link href='css/blink.css' rel='stylesheet'>";
			out.print("<html>");
			out.print("<head>"+st+"</head>");
			out.print("<body>");
			out.print("<h1 style= text-align:center><blink>Login is a Failure</blink></h1>");
			out.print("</body>");
			out.print("</html>");
			
		request.getRequestDispatcher("registereduser.html").include(request, response);
			
			
				
		}
				
	}

}