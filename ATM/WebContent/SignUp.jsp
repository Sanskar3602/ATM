


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login/Sign-up Page</title>

<link rel="stylesheet" href="styles.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
</head>

<body>
<div class="center">
<h2 class="headingval">Signup</h2>
<form class="form-login" action="signup" method="post">
			
				<div class="icon_container">
					<img class="image_icon" alt="profile" src="http://cdn.onlinewebfonts.com/svg/img_364496.png">
				</div>
				<div class="input_container">
					<td>Username: </td>
					<td><input class="inputs sign_username" type="text" name="u_id" /></td>
				</div>
				
				<div class="input_container">
					<td>Password: </td>
					<td><input class="inputs sign_password" type="password" name="pass" /></td>
				</div>
				<div class="input_container">
					<td>Balance: </td>
					<td><input class="inputs sign_balance" type="text" name="bal" /></td>
				</div>
				<div class="input_container">
					<td>Age: </td>
					<td><input class="inputs sign_age" type="text" name="age" /></td>
				</div>
				<div class="input_container">
					<td>Address: </td>
					<td><input class="inputs sign_add" type="text" name="addr" /></td>
				</div>

			
			<br/>
			<input class="submit_sign_btn" type="submit" value="Submit" /></form>
			<br/>
			
			</div>
</body>
</html>