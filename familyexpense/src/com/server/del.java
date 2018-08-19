package com.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.JDBCHelper;

/**
 * Servlet implementation class del
 */
public class del extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public del() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		String email11 = (String)session.getAttribute("keyEmail");
		String month=null;
session.setAttribute("keyEmail", email11);
		month=request.getParameter("month");
		String date=request.getParameter("Date");
		int i=0;
		
		
		if(month!=null) {
			
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
					String user = "root";
					String password = "";
					
					con = DriverManager.getConnection(url, user, password);
					System.out.println("--Connection Opened--");
					
				} catch (Exception e) {
					System.out.println("Exception "+e);
				}
			
			
		try {
		String email = (String)session.getAttribute("keyEmail");
		//String date1=request.getParameter("Date");
				String sql = "delete from fe where userEmail=? && monthly=?";
				pStmt = con.prepareStatement(sql);
				pStmt.setString(1, email);
				pStmt.setString(2, month);
				
				
				i =pStmt.executeUpdate();
				
				System.out.println(i+" Row(s) deleted");
				
				
				
			} catch (Exception e) {
				System.out.println("Exception "+e);
			
			}
			
			
		try {
		con.close();
		System.out.println("--Connection Closed--");
		} catch (Exception e) {
		System.out.println("Exception "+e);
		}
		if(i>0) {
			String st="<link href='css/blink.css' rel='stylesheet'>";
			out.print("<html>");
			out.print("<head>"+st+"</head>");
			out.print("<body>");
			

			out.print("<h1 style= text-align:center><blink>Your all data is deleted on this month</blink></h1>");
		
			out.print("</body>");
			out.print("</html>");
			request.getRequestDispatcher("EditDesh.jsp").include(request, response);
			
		}else {
			String st="<link href='css/blink.css' rel='stylesheet'>";
			out.print("<html>");
			out.print("<head>"+st+"</head>");
			out.print("<body>");
			

			out.print("<h1 style= text-align:center><blink>month not exist</blink></h1>");
		
			out.print("</body>");
			out.print("</html>");
			request.getRequestDispatcher("del.jsp").include(request, response);
		}
		
		}
	
		else {
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
					String user = "root";
					String password = "";
					
					con = DriverManager.getConnection(url, user, password);
					System.out.println("--Connection Opened--");
					
				} catch (Exception e) {
					System.out.println("Exception "+e);
				}
			
			
	try {
		//String email = (String)session.getAttribute("keyEmail");
		//String date1=request.getParameter("Date");
				String sql = "delete from fe where userEmail=? && currentdate=?";
				pStmt = con.prepareStatement(sql);
				pStmt.setString(1, email11);
				pStmt.setString(2, date);
				
				
				i =pStmt.executeUpdate();
				
				System.out.println(i+" Row(s) deleted");
				
			} catch (Exception e) {
				System.out.println("Exception "+e);
			}
			
			
	try {
		con.close();
		System.out.println("--Connection Closed--");
	} catch (Exception e) {
		System.out.println("Exception "+e);
	}


	if(i>0) {
		String st="<link href='css/blink.css' rel='stylesheet'>";
		out.print("<html>");
		out.print("<head>"+st+"</head>");
		out.print("<body>");
		

		out.print("<h1 style= text-align:center><blink>Your all data is deleted on this date</blink></h1>");
	
		out.print("</body>");
		out.print("</html>");
		request.getRequestDispatcher("EditDesh.jsp").include(request, response);
		//request.getRequestDispatcher("newuser.html").include(request, response);
		
	}else {
		String st="<link href='css/blink.css' rel='stylesheet'>";
		out.print("<html>");
		out.print("<head>"+st+"</head>");
		out.print("<body>");
		

		out.print("<h1 style= text-align:center><blink>date not exist</blink></h1>");
	
		out.print("</body>");
		out.print("</html>");
		request.getRequestDispatcher("del.jsp").include(request, response);
	}
		}
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
