<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="register.js"></script>
</head>
<body>
	<center>
		<form action="" enctype="application/x-www-form-urlencoded">
			<table border="1">
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username" value="" id="username"/>
						<div id="divcheck"></div>
						<input type="button" name="checkUserName" value="查看用户名" id="checkUserName"/>
					</td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" name="psw" id="psw" value=""></td>
				</tr>
				<tr>
					<td>确认密码:</td>
					<td><input type="password" name="confpsw" id="confpsw" value=""></td>
				</tr>
				<tr>
					<td>出生日期</td>
					<td><input type="text" name="birthday" value=""></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>