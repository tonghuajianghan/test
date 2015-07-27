<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Error Page For Examples</title>
</head>
<body bgcolor="white">
Invalid username and/or password, please try
<a href='<%= response.encodeURL("index.jsp") %>'>again</a>.
</body>
</html>
