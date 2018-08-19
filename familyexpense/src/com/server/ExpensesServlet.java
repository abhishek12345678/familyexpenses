package com.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.JDBCHelperExpenses;
import com.model.Expenses;
import com.model.User;


@WebServlet({ "/ExpensesServlet", "/Expenses", "/Expenses.do" })
public class ExpensesServlet extends HttpServlet {
	
	private static final Object Date = null;


	public void init(ServletConfig config) throws ServletException {
		System.out.println("--Servlet Initialized--");
	}

	
	public void destroy() {
		System.out.println("--Servlet Destroyed--");
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--Request Came--");
		PrintWriter out = response.getWriter();
		Expenses expenses = new Expenses();
		
		HttpSession session = request.getSession();
		
		String email11 = (String)session.getAttribute("keyEmail");
		expenses.userEmail=email11;
		session.setAttribute("keyEmail", email11);
		session.setAttribute("keyEmail", expenses.userEmail);
		
		//-----------------------------fetch estimation amount
		
		int i2=0;
		int estimatedamount=0;
		String month="";
		int year=0;
		Connection con=null;
		
		PreparedStatement pStmt;
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
		
		
try {



	String sql = "select monthly,year,Amount from estimatedamount where userEmail=?";
	pStmt = con.prepareStatement(sql);
	pStmt.setString(1, email11);
	
	ResultSet rs = pStmt.executeQuery();
	
	
	
	
	
	while(rs.next()){
		
	
	
		month=rs.getString(1);
	year=rs.getInt(2);
	estimatedamount=rs.getInt(3);
		i2++;
		System.out.print(i2);
			
	}} catch (Exception e) {
			System.out.println("Exception "+e);
			System.out.print("estimated amount"+i2);
		}

		
try {
	con.close();
	System.out.println("--Connection Closed--");
} catch (Exception e) {
	System.out.println("Exception "+e);
}
		
		if(estimatedamount==0) {
			
			String st="<link href='css/blink.css' rel='stylesheet'>";
			out.print("<html>");
			out.print("<head>"+st+"</head>");
			out.print("<body>");
			

			out.print("<h1 style= text-align:center><blink>first enter estimation amount</blink></h1>");
		
			out.print("</body>");
			out.print("</html>");
			request.getRequestDispatcher("EstimationAmount.jsp").include(request, response);
	}
		else {

			//-------------------------------------------
			
			expenses.currentdate = String.format(request.getParameter("currentdate"));
			//session.setAttribute("userdate", expenses.currentdate);
			expenses.food =  Integer.parseInt(request.getParameter("food"));
			expenses.shopping =  Integer.parseInt(request.getParameter("shop"));
			expenses.party = Integer.parseInt( request.getParameter("party"));
			expenses.travel = Integer.parseInt( request.getParameter("travel"));
			expenses.education = Integer.parseInt( request.getParameter("education"));
			expenses.health = Integer.parseInt( request.getParameter("health"));
			expenses.Utilities = Integer.parseInt( request.getParameter("utilities"));
			expenses.monthly=month;
			expenses.year=year;
			expenses.Amount=estimatedamount;
			session.setAttribute("estamount",expenses.Amount);
			
			int perday=0;
			int monthly=0;
			int weekly=0;
			int i=0;
			String date="";
			
			perday=expenses.food+expenses.shopping+expenses.travel+expenses.party+	expenses.education+expenses.health+expenses.Utilities;
		session.setAttribute("perday", perday);
		expenses.perdayexpenses=perday;
			response.setContentType("text/html");
			session.setAttribute("userdate", expenses.currentdate );
			
			User user = new User();
		
			user.userEmail= request.getParameter("txtEmail");
			System.out.println(expenses);
			//------------------------------------------------------------
			
			int inc=0;
			Connection con1=null;
			
			PreparedStatement pStmt1;
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
					
					con1 = DriverManager.getConnection(url, user1, password);
					System.out.println("--Connection Opened--");
					
				} catch (Exception e) {
					System.out.println("Exception "+e);
				}
			
			
	try {



		String sql = "select currentdate from fe where userEmail=? && currentdate=?";
		pStmt1 = con1.prepareStatement(sql);
		pStmt1.setString(1, expenses.userEmail);
		pStmt1.setString(2,expenses.currentdate);
		ResultSet rs = pStmt1.executeQuery();
		
		while(rs.next()){
			
			
			
			
			date= rs.getString(1);
			inc++;
				
		}} catch (Exception e) {
				System.out.println("Exception "+e);
			}

			
	try {
		con1.close();
		System.out.println("--Connection Closed--");
	} catch (Exception e) {
		System.out.println("Exception "+e);
	}

			if(inc>0) {
				out.print(date);
				session.setAttribute("d", date);
				
			}
			
			
			//------------------------------------------------------------
			if(date.equals(expenses.currentdate)){
				//out.println("enter another date");
				response.sendRedirect("check.jsp");
			}
			else {
			JDBCHelperExpenses helper = new JDBCHelperExpenses();
			helper.openConnection();
			i =helper.add(expenses);
			helper.closeConnection();
			
			
		if(i>0){
			
		
		//	out.println(expenses.userEmail);
			
			
			
			
			String email1 = (String)session.getAttribute("keyEmail");
			ArrayList<Double> userList = new ArrayList<Double>();
			int i1=0;
					
					Connection con2=null;
					
					PreparedStatement pStmt2;
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
							
							con2 = DriverManager.getConnection(url, user1, password);
							System.out.println("--Connection Opened--");
							
						} catch (Exception e) {
							System.out.println("Exception "+e);
						}
					
					
			try {

//				Expenses expenses = new Expenses();

				String sql = "select perdayexpenses from fe where userEmail = ? && monthly = ? && year = ?";
				pStmt2 = con2.prepareStatement(sql);
				pStmt2.setString(1, email1);
				pStmt2.setString(2, month);
				pStmt2.setLong(3, year);
				ResultSet rs = pStmt2.executeQuery();
				
				while(rs.next()){
					
					
					userList.add((double) rs.getInt(1));
					i1++;
						
				}} catch (Exception e) {
						System.out.println("Exception "+e);
					}

					
			try {
				con2.close();
				System.out.println("--Connection Closed--");
			} catch (Exception e) {
				System.out.println("Exception "+e);
			}


			if(i1>0) {
				
				Double sum = 0.0;
				out.println(email1);
				
					for(Double d:userList) {
						sum +=d;
					}
					out.print(sum);
					//out.print("date is"+date);
					session.setAttribute("KeySum", sum);
					
					//request.getRequestDispatcher("DeshboardServlet").forward(request,response);
					response.sendRedirect("check.jsp");
				}
				
			
			
			}
			
		
		}

			
		}
	//------------------------------------------
	
	
	
	
}
}