
package com.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.JDBCHelper;
import com.model.User;

/**
 * Servlet implementation class AccountServlet
 */
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
     
	    HttpSession session = request.getSession();
        String mail = (String)session.getAttribute("keyEmail");
        session.setAttribute("keyEmail", mail);
    	response.setContentType("text/html");
	int forget=0;
		User user = new User();
		
		user.userEmail= mail;
		user.userName = request.getParameter("txtName");
		user.userPhone = request.getParameter("phone");
		user.userSecurityQuestion = request.getParameter("nick");
	
		
		JDBCHelper helper = new JDBCHelper();
		helper.openConnection();
		 forget = helper.accountforget(user);
		 System.out.println(forget+" Row(s) inserted");
		helper.closeConnection();
		
		if(forget>0){
			out.print("record update");
			request.getRequestDispatcher("EditDesh.jsp").forward(request, response);
			//request.getRequestDispatcher("check").include(request, response);	
		
		}else{
			out.print("Login is a Failure");	
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
