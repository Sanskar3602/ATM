<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<html>
<head>
<meta charset="UTF-8">
<title>Mini Statement</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="center">
<h2 class="headingval"> Mini Statement:</h2>


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

	
	PreparedStatement getBalance = con.prepareStatement("select * from transactions where login_id=? order by trans_id desc limit 10 ");
	getBalance.setInt(1, loggedUser);
	ResultSet BalanceSet = getBalance.executeQuery();
	%>
	<TABLE class="table-trans" cellpadding="15" border="1">
	<%  
	while (BalanceSet.next())
	{ %>
		<% int loginID = BalanceSet.getInt(2);
			int deposit = BalanceSet.getInt(3);
			int withdrawal = BalanceSet.getInt(4);
			int isDeposit = 0;%>
			
		<TR>
		<TD>
		<%
			if(deposit == 0)
			{
				isDeposit = 0;
				%>Transaction Type: Withdrawal<% 
			}
			else if(withdrawal == 0)
			{
				isDeposit = 1;
				%>Transaction Type: Deposit<% 
			}
		%></TD>
	
			<% if(isDeposit == 1) {%>
			<TD>Deposit: <%=deposit %></TD>
			<%} %>
		
		
			<% if(isDeposit == 0) {%>
			<TD>Withdrawal: <%=withdrawal %></TD>
			<%} %>
		
		
		</TR>
	
	<%} %>
	 </TABLE>
<a href="dashboard.jsp" class="submit_login_btn">Dashboard</a>
<%} catch (Exception e) 
	{
		e.printStackTrace();
	}
 %>

</div>
</body>
</html>