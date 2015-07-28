<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% 
    String path = request.getContextPath();//拿到/structs2.0_0020(本文件)
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    //                http                   ://     localhost/               8080:   
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>入口页面</title>
</head>
<body>
  <h1>这是入口页面</h1>
  <h1>外部页面所需的所有url调用都由struts.xml提供</h1>
  <!-- struts.xml提供方法调用 -->
  <a href="<%=basepath %>methodpackage/amethod.action">lank to amethod </a><br>
  
  <!-- 直接方法调用 -->
  <a href="<%=basepath %>methodpackage/amethodshow!adds.action">lank to amethodshow</a>
</body>
</html>