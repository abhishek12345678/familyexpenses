package com.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Expenses;

/**
 * Servlet implementation class es
 */
@WebServlet("/es")
public class es extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public es() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
	
String email11 = (String)session.getAttribute("keyEmail");
		
		
		
		String month =request.getParameter("monthly");
	
		
		int i2=0;
		String month1 = null;
		int amount = 0;
		
		
		
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



	String sql = "select monthly,Amount  from fe where userEmail=? && monthly=?";
	pStmt = con.prepareStatement(sql);
	pStmt.setString(1, email11);
	pStmt.setString(2, month);
	
	
	ResultSet rs = pStmt.executeQuery();
	
	
	
	
	
	while(rs.next()){
		
	
	
		month1=rs.getString(1);
	amount =rs.getInt(2);
		i2++;
		System.out.print(i2);
		break;
			
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
		
		if(i2>0) {
			String st="<link href='css/blink.css' rel='stylesheet'>";
			out.print("<html>");
			out.print("<head>"+st+"</head>");
			out.print("<body>");
			

			out.print("<h1 style= text-align:center><blink>");
			out.println("Month is:"+month1);
			out.print("Amount is:"+amount);
			out.print("</blink></h1>");
			out.print("<body>");
			out.print("</html>");
			
			request.getRequestDispatcher("EstimationAmount.jsp").include(request, response);
	}else {
		
		String st1="<link href='css/blink.css' rel='stylesheet'>";
		out.print("<html>");
		out.print("<head>"+st1+"</head>");
		out.print("<body>");
		

		out.print("<h1 style= text-align:center><blink>No Record available</blink></h1>");
	
		out.print("</body>");
		out.print("</html>");
		request.getRequestDispatcher("EstimationAmount.jsp").include(request, response);
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
