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
  
     
    
     String ids=request.getParameter("ids");
     //int age=Integer.parseInt(request.getParameter("age")); 
     ids.replaceAll(" ", "");
     int sid = 0;	
     String aids[];
     aids=ids.split(",");
     for(int i=0;i<aids.length;i++){
    	    //aids[i] = aids[i].substring(0,aids[i].length()-1);
            String rids = aids[i];
           // rids.replaceAll(" ", "");
           // rids.replaceAll("  ", "");
           //rids.substring(0,2);
            if(rids.length()!=0){                           
                 rids = rids.trim();
                 System.out.println("yyy"+rids+"www");
                 sid = Integer.parseInt(rids);
                 //System.out.println("sid="+sid+"hhh");
        	   
            }else{
            	System.out.println("iii"+rids+"hhh");
            }
     }
         
     System.out.println("chenggong");
     System.out.println("sid="+sid+"hhh");
     
     //int idsi=Integer.parseInt(ids); 
     //System.out.println(idsi);
     
     Configuration cfg = new Configuration();     
     SessionFactory sf = cfg.configure().buildSessionFactory();      
     Session session2 = sf.openSession();     
     session2.beginTransaction();
     //删除
     Student stu = new Student();
     stu = (Student)session2.get(Student.class, sid);
     session2.delete(stu);
     session2.getTransaction().commit();
     session2.close();
     sf.close();  
  %> 
</body>
</html>