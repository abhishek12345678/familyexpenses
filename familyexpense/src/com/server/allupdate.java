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

import com.db.JDBCHelper;
import com.db.JDBCHelperExpenses;
import com.model.Expenses;
import com.model.User;

/**
 * Servlet implementation class allupdate
 */
public class allupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public allupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
     int day=0;
	    HttpSession session = request.getSession();
	    String mail1 = (String)session.getAttribute("keyEmail");
	    session.setAttribute("keyEmail", mail1);
	    String mail2 = (String)session.getAttribute("keyEmail");
	    Expenses expenses = new Expenses();
	    expenses.userEmail=mail1;
	    expenses.currentdate = String.format(request.getParameter("currentdate"));
		expenses.food =  Integer.parseInt(request.getParameter("food"));
		expenses.shopping =  Integer.parseInt(request.getParameter("shop"));
		expenses.party = Integer.parseInt( request.getParameter("party"));
		expenses.travel = Integer.parseInt( request.getParameter("travel"));
		expenses.education = Integer.parseInt( request.getParameter("education"));
		expenses.health = Integer.parseInt( request.getParameter("health"));
		expenses.Utilities = Integer.parseInt( request.getParameter("utilities"));
		
		day=expenses.food+expenses.shopping+expenses.travel+expenses.party+	expenses.education+expenses.health+expenses.Utilities;
		expenses.perdayexpenses=day;
		JDBCHelperExpenses helper = new JDBCHelperExpenses();
		helper.openConnection();
		int i = helper.update(expenses);
	
		helper.closeConnection();
	
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
			

			out.print("<h1 style= text-align:center><blink>Date not Exist</blink></h1>");
		
			out.print("</body>");
			out.print("</html>");
			request.getRequestDispatcher("allupdate.html").include(request, response);
		}
		
		//----------------------------------------------------------------------
		
		
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
