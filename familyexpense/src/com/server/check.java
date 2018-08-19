package com.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;

/**
 * Servlet implementation class check
 */
public class check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public check() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        User user = new User();
        Double SUM= null;
        String d="";
        int amount=0;
    
        Double ea = null;
        String userdate="";
	    HttpSession session = request.getSession();
       
	    SUM = (Double)session.getAttribute("KeySum");
	  String expensesmaill = (String)session.getAttribute("keyEmail");
	    int perday=(Integer)session.getAttribute("perday");
	    
		d=(String) session.getAttribute("d");
		out.print("Welcome Home Dear User. Today is "+new Date()+"<br/>");
		userdate  =(String) session.getAttribute("userdate");
		amount = (Integer)session.getAttribute("estamount");
		
	  
	    	out.print(" Email Id :"+expensesmaill);
	    	out.print("<br/>");
		
	
			 //out.print(SUM);
			// out.println("date is"+d);
			 if(userdate.equals(d)) {
				 out.println("date already exist");
				 
			 }
			 else {
				 out.print("estimed amount: " +amount);
				out.println("perday is:"+perday); 
				out.print("Total = "+SUM);
				out.print("<br/>");
				out.println("record insert"); 
			 }
			// ArrayList<Double> userList = new ArrayList<Double>();
			 
				int i1=0;
						
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

//					Expenses expenses = new Expenses();

					String sql = "select Amount from estimatedamount where userEmail=?";
					pStmt = con.prepareStatement(sql);
					pStmt.setString(1, expensesmaill);
					ResultSet rs = pStmt.executeQuery();
					
					while(rs.next()){
				
						
						ea=((double) rs.getInt(1));
						i1++;
							
					}} catch (Exception e) {
							System.out.println("Exception "+e);
						}

						
				try {
					con.close();
					System.out.println("--Connection Closed--");
				} catch (Exception e) {
					System.out.println("Exception "+e);
				}


				if(i1>0) {
					
					
					if(ea<SUM) {
						
					
					
						out.print("Now your sum of amount is greater than your estimeted amount");
						
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
