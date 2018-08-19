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
 * Servlet implementation class estimatedupdate
 */
public class estimatedupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public estimatedupdate() {
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
		Integer etupdate=Integer.parseInt(request.getParameter("Estimationupdate"));
		
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
	//String email = (String)session.getAttribute("keyEmail");
	//String date1=request.getParameter("datecurrent");
			String sql = "update estimatedamount set Amount=? where userEmail=?";
			pStmt = con.prepareStatement(sql);
			pStmt.setLong(1, etupdate);
			pStmt.setString(2, email11 );
			
			
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
	
	out.print("Amount is update");

	
	//out.println("<br/>");
	/*out.print("click below button to go back to your Dashboard");
	out.print("<br/>");
	out.print("<html>");
	out.print("<body>");
	out.print("<form action='DashboardServlet' method='get'>");
	out.print("<input type='submit' name='Go Back' value='Go Back' >");
	out.print("</form>");
	out.print("</body>");
	out.print("</html>");*/

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
