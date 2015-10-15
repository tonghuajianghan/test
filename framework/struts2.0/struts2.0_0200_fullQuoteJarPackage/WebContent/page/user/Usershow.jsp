<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.excute.model.*,java.util.*"%>
<%@ page import="com.excute.action.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usershow</title>
</head>
<body>
	<p>this is Usershow.</p>
	<p>make to valiation view to control param</p>
	<%
		User u = new User();
		UserManagerAction ua = new UserManagerAction();
	%>
	<%=u.getAge()%>
	<%=u.getName()%>
	<br>
	<%=ua.getAge()%>
	<%=ua.getName()%>

</body>
</html>