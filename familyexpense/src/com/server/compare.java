package com.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class compare
 */
public class compare extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public compare() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		//Expenses expenses = new Expenses();
		HttpSession session = request.getSession();
		String email11 = (String)session.getAttribute("keyEmail");
		//String ea=request.getParameter("ExtimationAmount");
		int ea1=Integer.parseInt(request.getParameter("ExtimationAmount"));
		//out.println(email11);
		out.print(ea1);
		
int i=0;
		
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
	

			String sql = "insert into estimatedamount values(?,?)";
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, email11);
			pStmt.setLong(2, ea1);
			
			
			i =pStmt.executeUpdate();
			
			System.out.println(i+" Row(s) inserted");
			
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
	out.print(ea1);
	out.println(email11);
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
