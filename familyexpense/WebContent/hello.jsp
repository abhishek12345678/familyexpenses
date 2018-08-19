<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
     <%@page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>SO question 2370960</title>
        <style>
        h3{
        text-align:center;
         color:green;
       
        }
        
      pre{
      text-align:center;
      text-align:top;
     color:red;
      } 
       h2{
      text-align:center;
      text-align:top;
     color:red;
      }   
         h1{
      text-align:center;
     color:red;
      }  
       
       
.container {
    position: relative;
    width: 100%;
  
    max-width: 400px;
}

.container img {
    width: 100%;
    height: auto;
}

.container .btn {
    position: absolute;
    top: 50%;
    left: 160%;
    transform: translate(-50%, -50%);
    -ms-transform: translate(-50%, -50%);
    background-color: #f1f1f1;
    color: black;
    font-size: 16px;
    padding: 16px 30px;
    border: none;
    cursor: pointer;
    border-radius: 5px;
    text-align: center;
}

.container .btn:hover {
    background-color: black;
    color: white;
}
h1
{
text-align:center;
}
body {
   
    background-image:url("background.jpg");
   background-size:100% 140%;
   }
   .button {
  display: inline-block;
  padding: 10px 15px;
  font-size: 14px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  outline: none;
  
  color: #fff;
  background-color: #4CAF50;
  border: none;
  border-radius: 15px;
  box-shadow: 0 4px #999;
}

.button:hover {background-color: #3e8e41}

.button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}
div{
align:left;

}
 </style>
    </head>
    <body>
     <%
         Date dd=new Date();
         String email=(String)request.getAttribute("keyEmail");
        			out.print("");
        			String name=(String)request.getAttribute("name");
        			session.setAttribute("keyEmail", email);			
      session.setAttribute("name", name); 
      		 %>
      <!--  <p>Message: ${message}</p> -->
      <h2><pre>                                 Welcome Dear User           <a href='accountsetting.html'>Account Settings</a>  <a href='registereduser.html'><button class="button">Logout</button></a></pre></h2>
       <h1><% out.println(name); %></h1>

         <%
      //<div><% request.getRequestDispatcher("expenses.html").include(request, response);</div>
		out.print("<html><body><h2>Welcome your Dashboard </h2></body></html>");	
	
		out.print("<html><body><h2><a href='expenses.html'>Enter your Expenses Amount</a></h2></body></html>");	
		
		
			
		out.print("<html><body><h2><a href='EstimationAmount.jsp'>Enter your Estimation Amount</a></h2></body></html>");	
		out.print("<html><body><h2><a href='button.html'>seprate update</a></h2></body></html>");	
		out.print("<html><body><h2><a href='allupdate.html'>All Update</a></h2></body></html>");
		out.print("<html><body><h2><a href='del.jsp'>delete by date</a></h2></body></html>");
		out.print("<html><body><h2><a href='showdata.jsp'>show by date and month</a></h2></body></html>");
	      //  request.getRequestDispatcher("DashboardServlet").forward(request, response);
            %>
       
    </body>
</html>