<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>第一种方法</p>
	<p>通过jsp的setProerty和getProerty从form表单中输入和获取值</p>
  <jsp:useBean id="user" class="cust.com.bean.User"></jsp:useBean>
  
  <jsp:setProperty property="*" name="user"/> 
  <form action="http://localhost:8080/jsp_teach/BeanTest.jsp" method="post">
  	用户名：<input type="text" name="username"/>
  	<br/>
  	<input type="submit" value="提交"/>
  </form>
  
  <jsp:setProperty property="id" name="user" value="12"></jsp:setProperty>
 
  <p>获取到的值：</p>
  <jsp:getProperty property="username" name="user"/>
  <jsp:getProperty property="id" name="user"/>
  
  <p>第二种方法</p>
  <p>调用setUsername()方法，隐藏设置值</p>
  <%user.setUsername("姜晗"); %>
  <%=user.getUsername() %>
</body>
</html>