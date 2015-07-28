<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% 
    String path = request.getContextPath();//拿到/structs2.0_0020
    String basepath = request.getScheme() + "://" + request.getServerName() + request.getServerPort() + path + "/";
    //                http                   ://     localhost/               8080:   
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
  this is the first.jsp<br>
  <a href="second.jsp">second</a>  
</body>
</html>