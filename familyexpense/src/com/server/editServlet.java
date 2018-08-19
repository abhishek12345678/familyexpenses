package com.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class editServlet
 */
public class editServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		 HttpSession session = request.getSession();
	        String expensesmail = (String)session.getAttribute("keyEmail");
	        session.setAttribute("keyEmail", expensesmail);
	        out.println(expensesmail);
	        
	        
	out.print("<html>");
	out.print("<body>");
	out.print("<form action='food' method='get'>");
	out.print("Food");
	out.print("<input type='text' name='Food' placeholder='500' required>");
	out.print("Date");
	out.print("<input type='text' name='Date' placeholder='MM/DD/YYYY' required>");
    out.print("<input type='submit' name='update' value='update' >");
	out.print("</form>");
	out.print("</body>");
	out.print("</html>");
	
	out.print("<html>");
	out.print("<body>");
	out.print("<form action='shopping' method='get'>");
	out.print("Shopping");
	out.print("<input type='text' name='Shopping' placeholder='500'required>");
	out.print("Date");
	out.print("<input type='text' name='Date' placeholder='MM/DD/YYYY' required>");
    out.print("<input type='submit' name='update' value='update' >");
	out.print("</form>");
	out.print("</body>");
	out.print("</html>");
	
	out.print("<html>");
	out.print("<body>");
	out.print("<form action='party' method='get'>");
	out.print("Party");
	out.print("<input type='text' name='Party' placeholder='500' required>");
	out.print("Date");
	out.print("<input type='text' name='Date'  placeholder='MM/DD/YYYY' required>");
    out.print("<input type='submit' name='update' value='update' >");
	out.print("</form>");
	out.print("</body>");
	out.print("</html>");
	
	out.print("<html>");
	out.print("<body>");
	out.print("<form action='travel' method='get'>");
	out.print("Travel");
	out.print("<input type='text' name='Travel' placeholder='500' required>");
	out.print("Date");
	out.print("<input type='text' name='Date' placeholder='MM/DD/YYYY' required>");
    out.print("<input type='submit' name='update' value='update' >");
	out.print("</form>");
	out.print("</body>");
	out.print("</html>");
	
	out.print("<html>");
	out.print("<body>");
	out.print("<form action='education' method='get'>");
	out.print("Education");
	out.print("<input type='text' name='Education' placeholder='500'required>");
	out.print("Date");
	out.print("<input type='text' name='Date' placeholder='MM/DD/YYYY' required>");
    out.print("<input type='submit' name='update' value='update' >");
	out.print("</form>");
	out.print("</body>");
	out.print("</html>");
	
	out.print("<html>");
	out.print("<body>");
	out.print("<form action='health' method='get'>");
	out.print("Health");
	out.print("<input type='text' name='Health' placeholder='500' required>");
	out.print("Date");
	out.print("<input type='text' name='Date' placeholder='MM/DD/YYYY' required>");
    out.print("<input type='submit' name='update' value='update' >");
	out.print("</form>");
	out.print("</body>");
	out.print("</html>");
	
	out.print("<html>");
	out.print("<body>");
	out.print("<form action='utilities' method='get'>");
	out.print("Utilities");
	out.print("<input type='text' name='Utilities' placeholder='500'required>");
	out.print("Date");
	out.print("<input type='text' name='Date' placeholder='MM/DD/YYYY' required>");
    out.print("<input type='submit' name='update' value='update' >");
	out.print("</form>");
	out.print("</body>");
	out.print("</html>");
	
	
	out.print("<html>");
	out.print("<body>");
	out.print("<form action='allupdate.html' method='get'>");

    out.print("<input type='submit' name='allupdate' value='allupdate' >");
	out.print("</form>");
	out.print("</body>");
	out.print("</html>");
	
	
	
	
	
	
	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
