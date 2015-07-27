<%-- <%@ page language="java" contentType="text/html; charset=utf-8"
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
  
     
    
     String uids=request.getParameter("uids");          
     int sid = 0;	
     String aids[];
     aids=uids.split(",");
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
       Session session = sf.openSession();     
       session.beginTransaction();
       //更新
       Student stu = new Student();
       stu = (Student)session.get(Student.class, 1);
       stu.setName("jianghan");
       session.update(stu);
       //批量更新
       //将jdbc与hibernate手动整合
       Student stu = new Student();
       System.out.print(stu.getName());
       try{
		   Connection conn = session.connection();
	     PreparedStatement stmt = conn.prepareStatement("update student  set age=age+100 where age>1 ");
		   //字符串连接
	      // PreparedStatement stmt = conn.prepareStatement("update student s  set s.name=concat(s.name,'beijing')");
	       
	       stmt.executeUpdate();
       }catch(SQLException e){
			e.printStackTrace();
		}
       session.getTransaction().commit();
       session.close();
       sf.close();
  %> 
</body>
</html> --%>