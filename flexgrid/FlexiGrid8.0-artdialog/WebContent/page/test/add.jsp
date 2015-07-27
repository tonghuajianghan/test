<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="org.hibernate.cfg.Configuration,org.hibernate.Query,org.hibernate.SessionFactory,org.hibernate.Session"%>
<%@ page import="com.hibernate.vo.*,java.util.List"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>    
  <%
  
     String name=request.getParameter("name"); //得到ajax传递过来的paramater 
     int id=Integer.parseInt(request.getParameter("id"));
     int age=Integer.parseInt(request.getParameter("age"));
     
     System.out.println(name);
     System.out.println("chenggong");
     
  	  Student s = new Student();
	 s.setId(id);
	 s.setName(name);
	 s.setAge(age);
	 Configuration cfg = new Configuration();
	 SessionFactory sf = cfg.configure().buildSessionFactory();
	 Session session1 = sf.openSession();
	 session1.beginTransaction();
	 session1.save(s);
	 session1.getTransaction().commit();
	 session1.close();
	 sf.close();
  %> 
</body>
</html>