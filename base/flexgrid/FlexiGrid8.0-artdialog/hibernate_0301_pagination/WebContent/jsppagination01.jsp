<%@page import="java.util.*"%>
<%@page import="com.hibernate.vo.Student"%>
<%@page import="com.hibernate.dao.StudentDao"%>
<%@page import="com.hibernate.dao.impl.StudentDBDao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>分页</title>
</head>
<body>
  <p>分页测试</p>
  <table>
    <%
	    StudentDao sd = new StudentDBDao();
		List<Student> list =  sd.getStudentById();
		
	    System.out.println("mark:"+list.size());
	  	
	    for(int i = 0; i < list.size();i++){
	    	Student stu = new Student();
	    	stu =(Student)list.get(i);
    %>	
        <tr><td><%=stu.getName()%></td></tr>
    <%
		 }
	%>

  </table>
</body>
</html>