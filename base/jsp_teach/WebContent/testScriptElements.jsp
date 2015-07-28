<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cust.com.*,java.util.*" %>    
<%@ include file="HelloWorld.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <p>脚本元素</p>
   <p>Scriptlet</p>
   <% 
     Student s = new Student();
     s.setId(1);
   %>
   <p>表达式</p>
   <%=s.getId()%>
   
   <p>声明</p>
   <%!int  i=0;%>
       <% i++;%>
       第<%=i%>个人访问此页面；
   
</body>
</html>