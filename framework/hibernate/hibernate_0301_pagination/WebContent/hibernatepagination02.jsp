<%@page import="java.util.*"%>
<%@page import="com.hibernate.vo.Student"%>
<%@page import="com.hibernate.dao.StudentDao"%>
<%@page import="com.hibernate.dao.impl.StudentDBDao"%>
<%@page import="com.hibernate.util.Pagination"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
  function kk(){
	 
  }
</script>
</head>
<body>
  <p>分页测试</p>
  <table border="1">
        <tr>
          <th>ID</th>
          <th>名字</th>
          <th>年龄</th>
        </tr>      
    <%
        
	    StudentDao sd = new StudentDBDao();
		List<Student> list =  sd.getStudentById();
		Pagination pa = new Pagination();
		pa.setSize(5);
		pa.setPage(1);
		pa.setResultCount(list.size());
		pa.setPageCount(pa.getResultCount()/pa.getSize() + pa.getResultCount() % pa.getSize() >= 1?1:0);
	   	
	    System.out.println("mark:"+list.size());
	  	
	    for(int i = 0;i < pa.getPage() * pa.getSize();i++){
	    	Student stu = new Student();
	    	stu =(Student)list.get(i);
	    	if((pa.getPage() - 1) * pa.getSize()  < i){
    %>	
		        <tr>
		           <td><%=stu.getId()%></td>
		           <td><%=stu.getName()%></td>
		           <td><%=stu.getAge()%></td>
		        </tr>
    <%
	       }
	    }
	%>
  </table>
  
   <%
    Pagination p = new Pagination();
    %>
  <div>
    <a>上一页</a>
    <a>第<%=p.getPage() %>页</a>
    <a href="hibernatepagination02.jsp" onclick="kk()">下一页</a>
  </div>  
</body>
</html>