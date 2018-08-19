package com.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;

/**
 * Servlet implementation class estimatedform
 */
public class estimatedform extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public estimatedform() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.setContentType("text/html");
		PrintWriter out = response.getWriter();
       
		Date date =new Date();
		int mon=date.getMonth();
		int year=date.getYear();
		int y=year+1900;
	    HttpSession session = request.getSession();
        String mail = (String)session.getAttribute("keyEmail");
     session.setAttribute("keyEmail", mail);
     String montharray[] = {"january","february","march","april","may","june","july","aug","sep","oct","nov","december"};
     
        out.print("<html>");
		out.print("<body>");
		out.print("<form action='EstimtedAmount' method='get'>");
		out.print("Monthly="+montharray[mon]);
	//	out.print("<input type='test' name='month' placeholder='march' required>");
		out.print("year"+y);
		//out.print("<input type='test' name='year' placeholder='2018' required>");
		out.print("amount");
		out.print("<input type='test' name='amount' placeholder='50000' required>");
		out.print("<input type='submit' name='EstimatedAmount' value='EstimatedAmount' >");
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
