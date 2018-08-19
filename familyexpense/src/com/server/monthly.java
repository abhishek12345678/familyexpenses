package com.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.db.JDBCHelperExpenses;
import com.model.Expenses;

/**
 * Servlet implementation class monthly
 */
public class monthly extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public monthly() {
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
		
		
		ArrayList<Double> userList = new ArrayList<Double>();
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

//	Expenses expenses = new Expenses();

	String sql = "select perdayexpenses from fe where userEmail=?";
	pStmt = con.prepareStatement(sql);
	pStmt.setString(1, email11);
	ResultSet rs = pStmt.executeQuery();
	
	while(rs.next()){
		
		
		
		//user.userID = rs.getInt(1);
		//expenses.perdayexpenses = rs.getInt(1);
		//user.userEmail = rs.getString(3);
		//.userPassword = rs.getString(4);
		
		userList.add((double) rs.getInt(1));
		i++;
			
	}} catch (Exception e) {
			System.out.println("Exception "+e);
		}

		
try {
	con.close();
	System.out.println("--Connection Closed--");
} catch (Exception e) {
	System.out.println("Exception "+e);
}


if(i>0) {
	//out.print(date);
	Double sum = 0.0;
	out.println(email11);
	//for( int j=0;j <userList.size();j++) {
	//	sum +=userList.get();
		//out.println(userList(j));
		for(Double d:userList) {
			sum +=d;
		}
		out.print(sum);
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
