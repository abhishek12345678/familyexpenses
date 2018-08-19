package com.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.JDBCHelper;
import com.model.Expenses;
import com.model.User;

/**
 * Servlet implementation class EstimtedAmount
 */
public class EstimtedAmount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EstimtedAmount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Expenses expenses = new Expenses();
		Date date=new Date();
		 String montharray[] = {"january","february","march","april","may","june","july","aug","sep","oct","nov","december"};
		HttpSession session = request.getSession();
	int mon=date.getMonth();
	int year=date.getYear();
	int y=year+1900;
    String email11 = (String)session.getAttribute("keyEmail");
		//Expenses expenses=new Expenses();
		expenses.userEmail=email11;
		//response.setContentType("text/html");
		//out.print(email11);
		System.out.println(email11);
		int forget=0;
		//expenses.Amount=0;
		//String month=null;
		//User user = new User();
	//	expenses.userEmail=req
		expenses.monthly=montharray[mon];
		expenses.year =y;
		expenses.Amount = Integer.parseInt( request.getParameter("amount"));
	//	month =request.getParameter("monthly");
		

		
		
			//out.print(month);
			JDBCHelper helper = new JDBCHelper();
			helper.openConnection();
			 forget = helper.insertestimated(expenses);
			 System.out.println(forget+" Row(s) updated");
			helper.closeConnection();
			
			if(forget>0){
				
				JDBCHelper helper1 = new JDBCHelper();
				helper1.openConnection();
				 forget = helper1.updatestimed(expenses);
				 System.out.println(forget+" Row(s) updated");
				helper1.closeConnection();
				
			
				
				String st="<link href='css/blink.css' rel='stylesheet'>";
				out.print("<html>");
				out.print("<head>"+st+"</head>");
				out.print("<body>");
				

				out.print("<h1 style= text-align:center><blink>Amount Insert</blink></h1>");
			
				out.print("</body>");
				out.print("</html>");
				request.getRequestDispatcher("expenses.html").include(request, response);
				//out.print("<html><body><h3>Login is a Success<br/><br/><a href='registereduser.html'>LogIn</a></h3></body></html>");	
			}else{
				out.print("estimated don't upload");	
			}
				
			}
		
		
		
		
				
		

	}




