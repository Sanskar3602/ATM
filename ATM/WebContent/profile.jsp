<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="center">



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
	PreparedStatement getAddress = con.prepareStatement("select address from newuser where login_id=?");
	PreparedStatement getAge = con.prepareStatement("select age from newuser where login_id=?");
	PreparedStatement getUser = con.prepareStatement("select login_id from newuser where login_id=?");
	PreparedStatement getPass = con.prepareStatement("select password from newuser where login_id=?");
	getBalance.setInt(1, loggedUser);
	getAddress.setInt(1, loggedUser);
	getAge.setInt(1, loggedUser);
	getUser.setInt(1, loggedUser);
	getPass.setInt(1, loggedUser);
	
	ResultSet BalanceSet = getBalance.executeQuery();
	ResultSet AddressSet = getAddress.executeQuery();
	ResultSet AgeSet = getAge.executeQuery();
	ResultSet UserSet = getUser.executeQuery();
	ResultSet PassSet = getPass.executeQuery();
	BalanceSet.next();
	AddressSet.next();
	AgeSet.next();
	UserSet.next();
	PassSet.next();
	int balance = BalanceSet.getInt(1);
	int user = UserSet.getInt(1);
	String pass = PassSet.getString(1);
	String address = AddressSet.getString(1);
	int age = AgeSet.getInt(1);
	

%>
<h2 class="headingval"> User Id: <%= user %></h2>
<h2 class="headingval"> Password: <%= pass %></h2>
<h2 class="headingval"> Age: <%= age %></h2>
<h2 class="headingval"> Balance: <%= balance %></h2>
<h2 class="headingval"> Address: <%= address %></h2>
<a href="dashboard.jsp" class="submit_login_btn">Dashboard</a>
<%} catch (Exception e) 
	{
		e.printStackTrace();
	}
 %>
</div>
</body>
</html>