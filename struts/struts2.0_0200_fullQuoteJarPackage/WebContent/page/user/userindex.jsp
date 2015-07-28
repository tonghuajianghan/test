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
   <p>前台页面所需要的路径名，全由struts.xml提供</p>
   <p>这是user的入口</p>
   <p>userindex.jsp</p><br>
   <p>1)用于练习前台通过url穿参给后台class</p>
   <p>2)用于练习basepath</p>
   
   <div>相同的路径,验证basepath</div> 
   <a href="<%=basepath %>/userpage/au.action">userpage by basepath</a> <br>
   <a href="http://localhost:8080/structs2.0_0110_param/userpage/au.action">userpage</a>
   <br><br>
   
   <div>传参</div>
   <a href="http://localhost:8080/structs2.0_0110_param/userpage/au.action?student=jianghan">userpage</a>
   <br><br>
   
   <div>mvc穿参(未完成)</div>
   <a href="<%=basepath %>usermanager/aum.action">usermanagerbetter</a><br>
   <a href="<%=basepath %>usermanager/aum.action?name=jianghan&age=5">usermanagerbetter</a><br>
   <a href="<%=basepath %>usermanager/aum.action?name=dasheng&age=9">usershow</a><br>
   
</body>
</html>