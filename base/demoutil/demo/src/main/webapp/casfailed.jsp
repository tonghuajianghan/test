<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="org.springframework.security.core.AuthenticationException" %>
<%@ page import="org.springframework.security.web.WebAttributes" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>Login to CAS failed!</title>
</head>

<body>
<h2>Login to CAS failed!</h2>

<font color="red">
    Your CAS credentials were rejected.<br/><br/>
    Reason:
<%
    Exception error = ((AuthenticationException) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION));
    if(error != null) {
    	System.out.println(error.getMessage());
%>
<%= error.getMessage() %>
<%
}
%>
</font>

</body>
</html>