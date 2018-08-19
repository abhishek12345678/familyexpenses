<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.Date" %>
        <%@page import="com.model.User" %>
        <%@page import="java.sql.Connection" %>
         <%@page import="java.sql.ResultSet" %>
          <%@page import="java.sql.PreparedStatement" %>
  
      <%@page import="java.sql.DriverManager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
 </style>
</head>
<body>

<%
         Date dd=new Date();
Connection con1 = null;
String name=null;
int i2=0;
PreparedStatement pStmt1;
         String email=(String)session.getAttribute("keyEmail");
        			out.print("");
      	request.getSession().setAttribute("keyEmail", email); %>
      <!--  <p>Message: ${message}</p> -->
      <h2><pre>                                 Welcome Dear User.             <a href='accountsetting.html'>Account Settings</a>  <a href='registereduser.html'><button class="button">Logout</button></pre></a></h2>

     
<% 
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
	
	con1 = DriverManager.getConnection(url, user1, password);
	System.out.println("--Connection Opened--");
	
} catch (Exception e) {
	System.out.println("Exception "+e);
}

//int i = 0;

try {
String sql = "select userName from users where userEmail=? ";
pStmt1 = con1.prepareStatement(sql);
pStmt1.setString(1,email );
			ResultSet rs = pStmt1.executeQuery();

while(rs.next()){
	

	name = rs.getString(1);
	
	
	
	

	System.out.println(i2+" Row(s) all rows are selected");
}
}
catch (Exception e) {
System.out.println("Exception "+e);
}
%>
       <h1><% out.println(name); %></h1>    <%
      
       out.print("<html><body><h2>Welcome your Dashboard</h2></body></html>");	
   	
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