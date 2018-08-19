<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="java.util.Date" %>
        <%@page import="com.model.User" %>
        <%@page import="java.sql.Connection" %>
         <%@page import="java.sql.ResultSet" %>
          <%@page import="java.sql.PreparedStatement" %>
  <%@page import="java.util.ArrayList" %>
      <%@page import="java.sql.DriverManager" %>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300' rel='stylesheet' type='text/css'>
<style type="text/css">
.form-style-8{
    font-family: 'Open Sans Condensed', arial, sans;
    width: 500px;
    padding: 30px;
    background: #FFFFFF;
    margin: 30px auto;
    box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
    -moz-box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
    -webkit-box-shadow:  0px 0px 15px rgba(0, 0, 0, 0.22);

}
.form-style-8 h2{
    background: #4D4D4D;
    text-transform: uppercase;
    font-family: 'Open Sans Condensed', sans-serif;
    color: #FFFFFF;
    font-size: 18px;
    font-weight: 100;
    padding: 20px;
    margin: -30px -30px 30px -30px;
}
.form-style-8 input[type="text"],
.form-style-8 input[type="date"],
.form-style-8 input[type="datetime"],
.form-style-8 input[type="email"],
.form-style-8 input[type="number"],
.form-style-8 input[type="search"],
.form-style-8 input[type="time"],
.form-style-8 input[type="url"],
.form-style-8 input[type="password"],
.form-style-8 textarea,
.form-style-8 select 
{
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    outline: none;
    display: block;
    width: 100%;
    padding: 7px;
    border: none;
    border-bottom: 1px solid #ddd;
    background: transparent;
    margin-bottom: 10px;
    font: 16px Arial, Helvetica, sans-serif;
    height: 45px;
}
.form-style-8 textarea{
    resize:none;
    overflow: hidden;
}
.form-style-8 input[type="button"], 
.form-style-8 input[type="submit"]{
    -moz-box-shadow: inset 0px 1px 0px 0px #45D6D6;
    -webkit-box-shadow: inset 0px 1px 0px 0px #45D6D6;
    box-shadow: inset 0px 1px 0px 0px #45D6D6;
    background-color: #2CBBBB;
    border: 1px solid #27A0A0;
    display: inline-block;
    cursor: pointer;
    color: #FFFFFF;
    font-family: 'Open Sans Condensed', sans-serif;
    font-size: 14px;
    padding: 8px 18px;
    text-decoration: none;
    text-transform: uppercase;
}
.form-style-8 input[type="button"]:hover, 
.form-style-8 input[type="submit"]:hover {
    background:linear-gradient(to bottom, #34CACA 5%, #30C9C9 100%);
    background-color:#34CACA;
}
body {
   
    background-image:url("background.jpg");
   background-size:100% 110%;
   }
   .navbar {
    overflow: hidden;
    background-color: #333;
    font-family: Arial, Helvetica, sans-serif;
}

.navbar a {
    float: left;
    font-size: 16px;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

.dropdown {
    float: left;
    overflow: hidden;
}

.dropdown .dropbtn {
    font-size: 16px;    
    border: none;
    outline: none;
    color: white;
    padding: 14px 16px;
    background-color: inherit;
    font-family: inherit;
    margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
    background-color: red;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    float: none;
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {
    background-color: #ddd;
}

.dropdown:hover .dropdown-content {
    display: block;
}
</style>
<link href="css/jquery.datepick.css" rel="stylesheet">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/jquery.plugin.min.js"></script>
<script src="js/jquery.datepick.js"></script>
<script>
$(function() {
	$('#popupDatepicker').datepick(); 
});

function showDate(date) {
	alert('The date chosen is ' + date);
}
</script>
</head>
<body>
<div class="navbar">
 
  <a href='expenses.html'> Expenses Amount</a>
  <a href='EstimationAmount.jsp'>Enter your Estimation Amount</a>
	<a href='button.html'>seprate update</a>
	<a href='updateall.jsp'>All Update</a>
	<a href='del.jsp'>delete</a>
	<a href='showdata.jsp'>show</a>
	<a href='accountsetting.html'>Account Settings</a>	
	<a href='registereduser.html'>Logout</a>
</div>
<%
int i1=0;
//String email=(String)request.getAttribute("keyEmail");
String email = (String)session.getAttribute("keyEmail");
//out.print
Connection con=null;

PreparedStatement pStmt1;
PreparedStatement pStmt2;
PreparedStatement pStmt3;
PreparedStatement pStmt4;
PreparedStatement pStmt5;
PreparedStatement pStmt6,pStmt7,pStmt8,pStmt9,pStmt10,pStmt11,pStmt12;

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
		System.out.println("--Connection Opened of del --");
		
	} catch (Exception e) {
		System.out.println("Exception "+e);
	}


try {



String sql = "select monthly from fe where userEmail=? && monthly=?";
pStmt1 = con.prepareStatement(sql);
pStmt2 = con.prepareStatement(sql);
pStmt3 = con.prepareStatement(sql);
pStmt4 = con.prepareStatement(sql);
pStmt5 = con.prepareStatement(sql);
pStmt6 = con.prepareStatement(sql);
pStmt7 = con.prepareStatement(sql);
pStmt8 = con.prepareStatement(sql);
pStmt9 = con.prepareStatement(sql);
pStmt10 = con.prepareStatement(sql);
pStmt11= con.prepareStatement(sql);
pStmt12 = con.prepareStatement(sql);
pStmt1.setString(1, email);
pStmt1.setString(2, "january");
pStmt2.setString(1, email);
pStmt2.setString(2, "february");
pStmt3.setString(1, email);
pStmt3.setString(2, "march");
pStmt4.setString(1, email);
pStmt4.setString(2, "april");
pStmt5.setString(1, email);
pStmt5.setString(2, "may");
pStmt6.setString(1, email);
pStmt6.setString(2, "june");
pStmt7.setString(1, email);
pStmt7.setString(2, "july");
pStmt8.setString(1, email);
pStmt8.setString(2, "aug");
pStmt9.setString(1, email);
pStmt9.setString(2, "sep");
pStmt10.setString(1, email);
pStmt10.setString(2, "oct");
pStmt11.setString(1, email);
pStmt11.setString(2, "nov");
pStmt12.setString(1, email);
pStmt12.setString(2, "december");
ResultSet rs1 = pStmt1.executeQuery();
ResultSet rs2 = pStmt2.executeQuery();
ResultSet rs3 = pStmt3.executeQuery();
ResultSet rs4 = pStmt4.executeQuery();
ResultSet rs5 = pStmt5.executeQuery();
ResultSet rs6 = pStmt6.executeQuery();
ResultSet rs7 = pStmt7.executeQuery();
ResultSet rs8 = pStmt8.executeQuery();
ResultSet rs9 = pStmt9.executeQuery();
ResultSet rs10 = pStmt10.executeQuery();
ResultSet rs11 = pStmt11.executeQuery();
ResultSet rs12 = pStmt12.executeQuery();
ArrayList<String> al = new ArrayList<String>();
if(rs6.next())
{
	al.add( rs6.getString(1));
	
	}
if(rs5.next())
{
	al.add( rs5.getString(1));
	
	}
if(rs4.next())
{
	al.add( rs4.getString(1));
	
	}
if(rs3.next())
{
	al.add( rs3.getString(1));
	
	}
if(rs2.next())
{
	al.add( rs2.getString(1));
	
	}
if(rs1.next())
{
	al.add( rs1.getString(1));
	
	}
if(rs7.next())
{
	al.add( rs7.getString(1));
	
	}
if(rs8.next())
{
	al.add( rs8.getString(1));
	
	}
if(rs9.next())
{
	al.add( rs9.getString(1));
	
	}
if(rs10.next())
{
	al.add( rs10.getString(1));
	
	}
if(rs11.next())
{
	al.add( rs11.getString(1));
	
	}
if(rs12.next())
{
	al.add( rs12.getString(1));
	
	}
//al.add( rs6.getString(1));


%>
<center>

    <h1><%//out.print(email); %></h1>
<div class="form-style-8">
  <h2>Show By Month</h2>
  <form action="show" method="get">
  Month:  <select name="monthly">
        <% // if(rs6.next()){ %>
           <%  for(int i = 0; i < al.size(); i++) {
           String option = (String)al.get(i);
   %>
        <option value="<%= option %>"><%= option %></option>   
        <% } %>
             <% //} %>
        </select>
    <input type="submit" value="Show" />
  </form>
</div>

<br>
<br>
    
    
</center>

<%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
try {
con.close();
System.out.println("--Connection Closed of del--");
} catch (Exception e) {
System.out.println("Exception "+e);
}
%>
<%
int i2=0;
//String email=(String)request.getAttribute("keyEmail");
String email2 = (String)session.getAttribute("keyEmail");
//out.print
Connection con1=null;

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
		System.out.println("--Connection Opened of del --");
		
	} catch (Exception e) {
		System.out.println("Exception "+e);
	}


try {



String sql = "select currentdate from fe where userEmail=?";
pStmt = con.prepareStatement(sql);
pStmt.setString(1, email);
ResultSet rs = pStmt.executeQuery();
%>
<center>

<div class="form-style-8">
<h2>Show By Date</h2>
<form action="show" method="get">
  Date:     <select name="showdate">
        <%  while(rs.next()){ %>
            <option><%= rs.getString(1)%></option>
        <% } %>
        </select>


<input type="submit" value="show" />
</form>
</div>
<br>
<br>
    
    
</center>

<%
//**Should I input the codes here?**
        }
        catch(Exception e)
        {
             out.println("wrong entry"+e);
        }
try {
con.close();
System.out.println("--Connection Closed of del--");
} catch (Exception e) {
System.out.println("Exception "+e);
}
%>



</body>
</html>