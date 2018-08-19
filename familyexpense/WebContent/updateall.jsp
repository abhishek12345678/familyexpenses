<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="css/update.css">
    <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
    <title>Sign in</title>
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
<style>
   .button1 {
  display: inline-block;
  padding: 15px 25px;
  font-size: 24px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color: #4CAF50;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
}

.button1:hover {background-color: #3e8e41}

.button1:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
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



    <div class="main">
        <p class="sign" align="center">Edit all amounts</p>
        <form class="form1"  action="allupdate" method="get">
       
            <input class="un " type="text" align="center" name="food" placeholder="Food Money" pattern="[0-9]{1,}" title="amount must in digits" required/>
            <input class="un " type="text" align="center" name="shop" placeholder="Shopping  Money"pattern="[0-9]{1,}" title="amount must in digits" required/>
            <input class="un " type="text" align="center"  name="party" placeholder="Party Money" pattern="[0-9]{1,}" title="amount must in digits" required/>
            <input class="un " type="text" align="center" name="travel" placeholder="Travel Money"pattern="[0-9]{1,}" title="amount must in digits" required/>
            <input class="un " type="text" align="center" name="education" placeholder="Education Money"pattern="[0-9]{1,}" title="amount must in digits" required/>
            <input class="un " type="text" align="center" name="health" placeholder="Health Money"pattern="[0-9]{1,}" title="amount must in digits" required/>
            <input class="un " type="text" align="center" name="utilities" placeholder="Utilities Money"pattern="[0-9]{1,}" title="amount must in digits" required/>
            <input class="un " type="text" id="popupDatepicker" name="currentdate" placeholder='MM/DD/YYYY' required/>
            <input class="submit" type="submit" value="update" align="center">
            
            </form>
            
                
    </div>
     
</body>

</html>