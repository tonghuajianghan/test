<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
     <p>bean的应用</p>
     <%-- <jsp:usebean id="beanbasic" class="javabeantest.BeanBasic" scope="session"/> --%>
       <%--  <jsp:getProperty property="getId" name="beanbasic"/> --%>
       <jsp:useBean id="beanbasic" class="vo.BeanBasic"></jsp:useBean>
       <jsp:getProperty property="id" name="beanbasic"/><br>
       <jsp:getProperty property="name" name="beanbasic"/>
</body>
</html>