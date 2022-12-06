<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DASHBOARD</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="center">
<h2 class="headingval" >DashBoard</h2>
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

%>
<p class="subheadingval">User Id: <%=loggedUser %></p>
	<div class="buttons-maincontainer">
			<div class="button_container">
				<a class="link_button" href="balance.jsp">Balance</a>
				<a class="link_button" href="miniStatement.jsp">Mini Statement</a>
				<a class="link_button" href="deposit.jsp">Deposit</a>
			</div>
			<div class="button_container">
				<a class="link_button" href="withdrawal.jsp">Withdrawal</a>
				<a class="link_button" href="profile.jsp">Profile</a>
				<a class="link_button" href="ChangePin.jsp">Change Password</a>
			</div>
			
			<br/>
			<form action="logout" method="post">
				<input type="submit" class="submit_login_btn" value="Log out" />
			</form>
			
			</div>
	<div>
	<%} catch (Exception e) 
	{
		e.printStackTrace();
	}
 %>
</body>
</html>