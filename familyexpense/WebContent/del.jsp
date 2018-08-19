<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.Date" %>
        <%@page import="com.model.User" %>
        <%@page import="java.sql.Connection" %>
         <%@page import="java.sql.ResultSet" %>
          <%@page import="java.sql.PreparedStatement" %>
  <%@page import=" java.util.ArrayList" %>
      <%@page import="java.sql.DriverManager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<style type="text/css">
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
.form-style-6{
    font: 95% Arial, Helvetica, sans-serif;
    max-width: 400px;
    margin: 10px auto;
    padding: 16px;
    background: #F7F7F7;
}
.form-style-6 h1{
    background: #43D1AF;
    padding: 20px 0;
    font-size: 140%;
    font-weight: 300;
    text-align: center;
    color: #fff;
    margin: -16px -16px 16px -16px;
}
.form-style-6 input[type="text"],
.form-style-6 input[type="date"],
.form-style-6 input[type="datetime"],
.form-style-6 input[type="email"],
.form-style-6 input[type="number"],
.form-style-6 input[type="search"],
.form-style-6 input[type="time"],
.form-style-6 input[type="url"],
.form-style-6 textarea,
.form-style-6 select 
{
    -webkit-transition: all 0.30s ease-in-out;
    -moz-transition: all 0.30s ease-in-out;
    -ms-transition: all 0.30s ease-in-out;
    -o-transition: all 0.30s ease-in-out;
    outline: none;
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    width: 100%;
    background: #fff;
    margin-bottom: 4%;
    border: 1px solid #ccc;
    padding: 3%;
    color: #555;
    font: 95% Arial, Helvetica, sans-serif;
}
.form-style-6 input[type="text"]:focus,
.form-style-6 input[type="date"]:focus,
.form-style-6 input[type="datetime"]:focus,
.form-style-6 input[type="email"]:focus,
.form-style-6 input[type="number"]:focus,
.form-style-6 input[type="search"]:focus,
.form-style-6 input[type="time"]:focus,
.form-style-6 input[type="url"]:focus,
.form-style-6 textarea:focus,
.form-style-6 select:focus
{
    box-shadow: 0 0 5px #43D1AF;
    padding: 3%;
    border: 1px solid #43D1AF;
}

.form-style-6 input[type="submit"],
.form-style-6 input[type="button"]{
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    width: 100%;
    padding: 3%;
    background: #43D1AF;
    border-bottom: 2px solid #30C29E;
    border-top-style: none;
    border-right-style: none;
    border-left-style: none;    
    color: #fff;
}
.form-style-6 input[type="submit"]:hover,
.form-style-6 input[type="button"]:hover{
    background: #2EBC99;
}
body {
   
    background-image:url("background.jpg");
   background-size:100% 120%;
   }
</style>
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
   <h1><%//out.print(email); %></h1>
    <div class="form-style-6">
<h1>Delete By Date</h1>
<form action="del" method="get">
  Date:     <select name="Date">
        <%  while(rs.next()){ %>
            <option><%= rs.getString(1)%></option>
        <% } %>
        </select>


<input type="submit" value="Delete" />
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

<br>
<br>
<%


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

<div class="form-style-6">
  <h1>Delete By Month</h1>
  <form action="del" method="get">
  Month:  <select name="month">
        <% // if(rs6.next()){ %>
           <%  for(int i = 0; i < al.size(); i++) {
           String option = (String)al.get(i);
   %>
        <option value="<%= option %>"><%= option %></option>   
        <% } %>
             <% //} %>
        </select>
    <input type="submit" value="Delete" />
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