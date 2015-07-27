<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>这是我第一个jsp</h1>
  
  <p>测试get</p>
  <p>输入一个数，servlet求这个数的平方根：</p>
	   <FORM action="qw" method="get">
	      <Input Type="text" name="number"/>
	      <Input Type=submit value="提交"/>
	   </FORM>   
  
  <p>测试post</p>  
       <FORM action="qw" method="post">
	      <Input Type="text" name="name"/><br>
	      <Input Type="text" name="pwd"/><br>
	      <Input Type=submit value="提交"/>
	   </FORM>

</body>
</html>