<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<html>
<head>
<meta charset="UTF-8">
<title>Balance</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="center">
<h2 class="headingval"> Balance:</h2>


<% 
try {
Connection con = null;
	String url = "jdbc:mysql://localhost:3306/atm";
	String username = "atm"; 
	String password = "Sanskar@2021";

Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(url, username, password); 
	System.out.println("connection object "+con);

	PreparedStatement checkUser = con.prepareStatement("select * from logged");
	
ResultSet resultSet = checkUser.executeQuery();
resultSet.next();
int loggedUser = resultSet.getInt(1);

	
	PreparedStatement getBalance = con.prepareStatement("select balance from newuser where login_id=?");
	getBalance.setInt(1, loggedUser);
	ResultSet BalanceSet = getBalance.executeQuery();
	BalanceSet.next();
	int balance = BalanceSet.getInt(1);

%>
<h3> <%=balance %></h3>
<a href="dashboard.jsp" class="submit_login_btn">Dashboard</a>
<%} catch (Exception e) 
	{
		e.printStackTrace();
	}
 %>
</div>
</body>
</html>