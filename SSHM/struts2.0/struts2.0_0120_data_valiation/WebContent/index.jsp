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
<title>Insert title here</title>
</head>
<body>
   <p>index.jsp</p><br>
   <a href="<%=basepath %>usermanager/aum.action">usermanagerbetter</a><br>
   
   <p>.........</p>
   <p>项目改变还是原来的引用所以错了</p>
   <a href="http://localhost:8080/structs2.0_0110_param/userpage/au.action">userpage</a>
   <br><br>
   <a href="http://localhost:8080/structs2.0_0110_param/userpage/au.action?student=jianghan">userpage</a>
   <br><br>
   
   <p>.........</p>
   <a href="<%=basepath %>usermanager/aum.action?name=jianghan&age=5">usermanagerbetter</a><br>
   <br>
   
   <p>...........</p>
   <a href="<%=basepath %>datavaliation/ad.action">datavaliation</a><br>
   
   
</body>
</html>