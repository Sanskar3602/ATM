<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deposit Page</title>
<style>
body {
	background-color: #fff;
	font-family: 'Poppins', sans-serif;
}
h1   {color: blue;}
p    {cogilor: red;}

.form-login {
	display: inline-block;
	margin: auto;
	background-color: #c7fff7;
	padding: 2rem 2rem;
}
.loginid_input{
	border-radius: 8px;
	border: 1px solid gray;
	padding: .3rem .3rem;
}

.pass_input{
	border-radius: 8px;
	border: 1px solid gray;
	padding: .3rem .3rem;
}

.submit_login_btn{
	font-family: 'Poppins', sans-serif;
	padding: .5rem 1rem;
	background-color: black;
	color: white;
	border: none;
	border-radius: 8px;
}

.table_row{
margin-bottom: .3rem;
}

.input_container{
display: flex;
align-items: center;
justify-content: space-between;
margin-bottom: .5rem;

}

.icon_container{
margin-bottom: 1rem;
}

.image_icon{
border: 2px solid black;
height: 1.5rem;
padding: .3rem;
border-radius: 50%;

}

.input-container
</style>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="styles.css">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
</head>

<body>
<div class="center">
<h2 class="headingval">Deposit</h2>

<form class="form-login" action="DepositServlet" method="post">
				
				<div class="input_container">
					<td>Enter Amount:<span class="required" style="color: red">*</span></td>
					<td><input class="loginid_input" type="text" name="amount" /></td>
				</div>
				
				<div class="input_container">
				
					<td>Enter Password:<span class="required" style="color: red">*</span></td>
					<td><input class="pass_input" type="password" name="pass" /></td>
				
				</div>

			
			<br/>
			<input class="submit_login_btn" type="submit" value="Deposit" /></form>
			<br/>
		
			</div>
</body>
</html>