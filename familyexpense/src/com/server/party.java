package com.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class party
 */
public class party extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public party() {
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
		int party=Integer.parseInt(request.getParameter("Party"));
		String date=request.getParameter("Date");
		
		//String mail = (String)session.getAttribute("maill");
		String mail = (String)session.getAttribute("keyEmail");
		session.setAttribute("keyEmail", mail);
		// ArrayList<Integer> showdatehere = new ArrayList<Integer>();
		 int food1=0;
		 int perday=0;
		int i=0;
		int i1=0;
		int sum=0;
		int sum1=0;
		//out.println(mail);
		//out.println(date);
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
			
			//----------------select---------------------
		try {
			String sql = "select party,perdayexpenses from fe where userEmail=? && currentdate=?";
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, mail);
			pStmt.setString(2, date);
			ResultSet rs = pStmt.executeQuery();
			
			
			
			
			
			if(rs.next()){
				
			
				
			food1	= rs.getInt(1);
				perday= rs.getInt(2);
				
				sum=perday-food1;
				sum1=sum+party;
				
				i1++;
				System.out.print(i1);}
				
				
				
				//---------------------------------------
				try {
					
					String sql1 = "update fe set party=?,perdayexpenses=? where userEmail=? && currentdate=?";
					pStmt = con.prepareStatement(sql1);
					pStmt.setLong(1, party);
					pStmt.setLong(2, sum1);
					pStmt.setString(3, mail);
					pStmt.setString(4, date);
					
					i =pStmt.executeUpdate();
					
					System.out.println(i+" Row(s) food edit");
					
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
			

			out.print("<h1 style= text-align:center><blink>Record Updated</blink></h1>");
		
			out.print("</body>");
			out.print("</html>");
			
			
			request.getRequestDispatcher("EditDesh.jsp").include(request, response);
		}else {
			
			String st="<link href='css/blink.css' rel='stylesheet'>";
			out.print("<html>");
			out.print("<head>"+st+"</head>");
			out.print("<body>");
			

			out.print("<h1 style= text-align:center><blink>date not exist</blink></h1>");
		
			out.print("</body>");
			out.print("</html>");
			request.getRequestDispatcher("party.html").include(request, response);
		}
				
				
				
				
		
		}
		catch (Exception e) {
			System.out.println("Exception "+e);
		}
	//----------------------update------------------------	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
