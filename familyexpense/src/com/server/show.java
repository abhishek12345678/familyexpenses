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

import com.db.JDBCHelper;
import com.model.Expenses;

/**
 * Servlet implementation class show
 */
public class show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public show() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String st="<link href='css/drop.css' rel='stylesheet'>";
		out.print("<html>");
		out.print("<head>"+st+"</head>");
		out.print("<body>");
		
		
	
		
		
		HttpSession session = request.getSession();
	      //  String expensesmail = (String)session.getAttribute("mail");
		 String expensesmail = (String)session.getAttribute("keyEmail");
	        session.setAttribute("maill", expensesmail);
	     //   out.println(expensesmail);
	        
	        Expenses expenses= new Expenses();
	        		expenses.userEmail=expensesmail;
	        		int i=0;
	        		String n=null;
	        	String	showdate=null;
	        	String monthly= null;
	        monthly=request.getParameter("monthly");
	        expenses.monthly=monthly;
	        showdate =request.getParameter("showdate");
	       expenses.currentdate=showdate;
	       
	    
		if( monthly!=null) {
			Connection con=null;
			
			PreparedStatement pStmt;

			PreparedStatement pStmt2;
			PreparedStatement pStmt3;
			PreparedStatement pStmt4;
			PreparedStatement pStmt5;
			PreparedStatement pStmt6;
			PreparedStatement pStmt7;
			PreparedStatement pStmt8;
			PreparedStatement pStmt9;
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
			
			
			ArrayList<String> expenseslist = new ArrayList<String>();
			ArrayList<Integer> foodlist = new ArrayList<Integer>();
			ArrayList<Integer> shoppinglist = new ArrayList<Integer>();
			ArrayList<Integer> partylist = new ArrayList<Integer>();
			ArrayList<Integer> travellist = new ArrayList<Integer>();
			ArrayList<Integer> educationlist = new ArrayList<Integer>();
			ArrayList<Integer> healthlist = new ArrayList<Integer>();
			ArrayList<Integer> utilitieslist = new ArrayList<Integer>();
			ArrayList<Integer> perdayexpenseslist = new ArrayList<Integer>();
			try {
				
				String sql = "select currentdate from fe where userEmail=? && monthly=? ";
				String sql2="select food from fe where userEmail=? && monthly=? ";
				String sql3="select shopping from fe where userEmail=? && monthly=? ";
				String sql4="select party from fe where userEmail=? && monthly=? ";
				String sql5="select travel from fe where userEmail=? && monthly=? ";
				String sql6="select education from fe where userEmail=? && monthly=? ";
				String sql7="select health from fe where userEmail=? && monthly=? ";
				String sql8="select Utilities from fe where userEmail=? && monthly=? ";
				String sql9="select perdayexpenses from fe where userEmail=? && monthly=? ";
				pStmt = con.prepareStatement(sql);
				pStmt2 = con.prepareStatement(sql2);
				pStmt3 = con.prepareStatement(sql3);
				pStmt4 = con.prepareStatement(sql4);
				pStmt5 = con.prepareStatement(sql5);
				pStmt6 = con.prepareStatement(sql6);
				pStmt7 = con.prepareStatement(sql7);
				pStmt8 = con.prepareStatement(sql8);
				pStmt9 = con.prepareStatement(sql9);
				pStmt.setString(1, expenses.userEmail);
				pStmt.setString(2,expenses.monthly);
				pStmt2.setString(1, expenses.userEmail);
				pStmt2.setString(2,expenses.monthly);
				pStmt3.setString(1, expenses.userEmail);
				pStmt3.setString(2,expenses.monthly);
				pStmt4.setString(1, expenses.userEmail);
				pStmt4.setString(2,expenses.monthly);
				pStmt5.setString(1, expenses.userEmail);
				pStmt5.setString(2,expenses.monthly);
				pStmt6.setString(1, expenses.userEmail);
				pStmt6.setString(2,expenses.monthly);
				pStmt7.setString(1, expenses.userEmail);
				pStmt7.setString(2,expenses.monthly);
				pStmt8.setString(1, expenses.userEmail);
				pStmt8.setString(2,expenses.monthly);
				pStmt9.setString(1, expenses.userEmail);
				pStmt9.setString(2,expenses.monthly);
				//pStmt.setString(3,expenses.currentdate);
				ResultSet rs = pStmt.executeQuery();
				ResultSet rs2 = pStmt2.executeQuery();
				ResultSet rs3 = pStmt3.executeQuery();
				ResultSet rs4 = pStmt4.executeQuery();
				ResultSet rs5 = pStmt5.executeQuery();
				ResultSet rs6 = pStmt6.executeQuery();
				ResultSet rs7 = pStmt7.executeQuery();
				ResultSet rs8 = pStmt8.executeQuery();
				ResultSet rs9 = pStmt9.executeQuery();
				i++;
			
				
				//expenses.health = rs.getInt(7);
				//expenses.Utilities = rs.getInt(8);
				//expenses.perdayexpenses = rs.getInt(9);
				while(rs.next()){
					
				expenses.currentdate=rs.getString(1);
				expenseslist.add(expenses.currentdate);
				while(rs2.next()){
				expenses.food = rs2.getInt(1);
					
				
					foodlist.add(expenses.food);	
				}
					while(rs3.next()){
						expenses.shopping = rs3.getInt(1);
							
						
							shoppinglist.add(expenses.shopping);	
					}
					while(rs4.next()){
						expenses.party = rs4.getInt(1);
							
						
							partylist.add(expenses.party);	
					}
					while(rs5.next()){
						expenses.travel = rs5.getInt(1);
							
						
							travellist.add(expenses.travel);	
					}
					while(rs6.next()){
						expenses.education = rs6.getInt(1);
							
						
							educationlist.add(expenses.education);	
					}
					while(rs7.next()){
						expenses.health = rs7.getInt(1);
							
						
							healthlist.add(expenses.health);	
					}
					while(rs8.next()){
						expenses.Utilities = rs8.getInt(1);
							
						
						utilitieslist.add(expenses.Utilities);	
					}
					while(rs9.next()){
						expenses.perdayexpenses = rs9.getInt(1);
							
						
						perdayexpenseslist.add(expenses.perdayexpenses);	
					}
				
				}
				
				
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
				
				out.print("<div class=\"navbar\">\r\n" + 
		        		" \r\n" + 
		        		"  <a href='expenses.html'> Expenses Amount</a>\r\n" + 
		        		"  <a href='EstimationAmount.jsp'>Enter your Estimation Amount</a>\r\n" + 
		        		" <a href='accountsetting.html'>Account Settings</a>	\r\n" + 
		        		"	<a href='button.html'>seprate update</a>\r\n" + 
		        		"	<a href='updateall.jsp'>All Update</a>\r\n" + 
		        		"	<a href='del.jsp'>delete</a>\r\n" + 
		        		"	<a href='showdata.jsp'>show</a>\r\n" + 
		        		"	<a href='registereduser.html'>Logout</a>\r\n" + 
		        		"</div>");

				
				
				
				out.println("<table border='2' style=color:red; align=\"center\"");
				out.println("<tr >");
				out.println("<td width='10%' style=color:green;>");
				out.print("date");
				out.println("</td>");
				out.println("<td width='10%' style=color:green;>");
				out.print("food");
				out.println("</td>");
				out.println("<td style=color:green;>");
				out.print("shopping");
				out.println("</td>");
				out.println("<td style=color:green;>");
				out.print("party");
				out.println("</td>");
				out.println("<td style=color:green;>");
				out.print("travel");
				out.println("</td>");
				out.println("<td style=color:green;>");
				out.print("education");
				out.println("</td>");
				out.println("<td style=color:green;>");
				out.print("health");
				out.println("</td>");
				out.println("<td style=color:green;>");
				out.print("others");
				out.println("</td>");
				out.println("<td style=color:green;>");
				out.print("perday");
				out.println("</td>");
				out.println("</tr>");
				for(int d=0;d<expenseslist.size();d++) {
					//for(int k=0;k<foodlist.size();k++) {
					int food=foodlist.get(d);
					int shopping=shoppinglist.get(d);
					int travel=travellist.get(d);
					int party=partylist.get(d);
					int education=educationlist.get(d);
					String date=expenseslist.get(d);
					
					int health=healthlist.get(d);
					int utilities=utilitieslist.get(d);
					int perday=perdayexpenseslist.get(d);
					//out.print(expenseslist);
					
					out.println("<tr>");
					
					out.print("<td width='10%' style=color:green;>");
				out.print(date);
				out.print("</td>");
				out.print("<td width='10%' style=color:green;>");
				out.print(food);
				out.print("</td>");
				out.print("<td style=color:green;>");
				out.print(shopping);
				out.print("</td>");
				out.print("<td style=color:green;>");
				out.print(party);
				out.print("</td>");
				out.print("<td style=color:green;>");
				out.print(travel);
				out.print("</td>");
				out.print("<td style=color:green;>");
				out.print(education);
				out.print("</td>");
				out.print("<td style=color:green;>");
				out.print(health);
				out.print("</td>");
				out.print("<td style=color:green;>");
				out.print(utilities);
				out.print("</td>");
				out.print("<td style=color:green;>");
				out.print(perday);
				out.print("</td>");
					//out.println("<h3>");out.println("date is"+date+" | food is="+food+" | shopping is"+shopping+" | party is"+party+" | travel is"+travel+" | education is"+education+" | health is"+health+" | utilities is"+utilities+" | perday is"+perday);
					//out.println("</h3>");
					//out.println("</td>");
					out.println("</tr>");
					
				
					
					//}
				}
				out.println("</table>");
				}else {
					
					String st1="<link href='css/blink.css' rel='stylesheet'>";
					out.print("<html>");
					out.print("<head>"+st1+"</head>");
					out.print("<body>");
					

					out.print("<h1 style= text-align:center><blink>No Record available</blink></h1>");
				
					out.print("</body>");
					out.print("</html>");
					request.getRequestDispatcher("expenses.html").include(request, response);
				}
		}
		
		
		
		else {
			 ArrayList<Integer> showdatehere = new ArrayList<Integer>();
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



					String sql = "select food,shopping,party,travel,education,health,Utilities from fe where userEmail=? && currentdate=?";
					pStmt = con.prepareStatement(sql);
					pStmt.setString(1, expensesmail);
					pStmt.setString(2, showdate);
					ResultSet rs = pStmt.executeQuery();
					
					
					
					
					
					while(rs.next()){
						
					
						
						showdatehere.add((Integer) rs.getInt(1));
						showdatehere.add((Integer) rs.getInt(2));
						showdatehere.add((Integer) rs.getInt(3));
						showdatehere.add((Integer) rs.getInt(4));
						showdatehere.add((Integer) rs.getInt(5));
						showdatehere.add((Integer) rs.getInt(6));
						showdatehere.add((Integer) rs.getInt(7));
						i1++;
						System.out.print(i1);
							
					}} catch (Exception e) {
							System.out.println("Exception "+e);
							System.out.print(i1);
						}

						
				try {
					con.close();
					System.out.println("--Connection Closed--");
				} catch (Exception e) {
					System.out.println("Exception "+e);
				}
			if(i1>0) {
				out.print("<div class=\"navbar\">\r\n" + 
		        		" \r\n" + 
		        		"  <a href='expenses.html'> Expenses Amount</a>\r\n" + 
		        		"  <a href='EstimationAmount.jsp'>Enter your Estimation Amount</a>\r\n" + 
		        		" <a href='accountsetting.html'>Account Settings</a>	\r\n" + 
		        		"	<a href='button.html'>seprate update</a>\r\n" + 
		        		"	<a href='updateall.jsp'>All Update</a>\r\n" + 
		        		"	<a href='del.jsp'>delete</a>\r\n" + 
		        		"	<a href='showdata.jsp'>show</a>\r\n" + 
		        		"	<a href='registereduser.html'>Logout</a>\r\n" + 
		        		"</div>");

				
				
				for(int d=0;d<showdatehere.size();d++) {
					if(d==0) {
					int s1=showdatehere.get(d);
					out.print("<h3 text-align:center; color:red;>");out.println("food is:"+s1);out.print("</h3>");
					}
					if(d==1) {
						int s1=showdatehere.get(d);
						out.print("<h3 text-align:center; color:red;>");out.println("shopping is:"+s1);					out.print("</h3>");
						}
					if(d==2) {
						int s1=showdatehere.get(d);
						out.print("<h3>");out.println("party is: "+s1);					out.print("</h3>");
						}
					if(d==3) {
						int s1=showdatehere.get(d);
						out.print("<h3>");out.println("travel is: "+s1);					out.print("</h3>");
						}
					if(d==4) {
						int s1=showdatehere.get(d);
						out.print("<h3>");out.println("education is: "+s1);					out.print("</h3>");
						}
					if(d==5) {
						int s1=showdatehere.get(d);
						out.print("<h3>");out.println("health is: "+s1);					out.print("</h3>");
						}
					if(d==6) {
						int s1=showdatehere.get(d);
						out.print("<h3>");out.println("others is: "+s1);					out.print("</h3>");
						}
					
					out.print("<br/>");
					out.print("</body>");
					out.print("</html>");
					
				}
		}else {
			
			String st1="<link href='css/blink.css' rel='stylesheet'>";
			out.print("<html>");
			out.print("<head>"+st1+"</head>");
			out.print("<body>");
			

			out.print("<h1 style= text-align:center><blink>No Record available</blink></h1>");
		
			out.print("</body>");
			out.print("</html>");
			request.getRequestDispatcher("expenses.html").include(request, response);
		}
		}
		//if(!showdate.isEmpty()&&!monthly.isEmpty()) {
		//	out.print("write one");
		//}
		//if(showdate.isEmpty()&&monthly.isEmpty()) {
		//	out.print("choose one");
		//}
	}
		//------------------------------------------------------------------------
		
	   /*    
		}
		//--------------------------------------------------------------------
		*/
		
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
