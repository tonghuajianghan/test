<%@page import="com.cust.dew.dao.impl.CommodityDBDao"%>
<%@page import="com.cust.dew.dao.impl.DaoFactory"%>
<%@page import="com.cust.dew.vo.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
  <th>coid</th>
  <th>coname</th>
</tr>
<%
  CommodityDBDao cd = DaoFactory.getCommodityDBDao();
  List<Commodity>  peList = cd.queryCommodity();
  System.out.println("mark:"+peList.size());

  for(int i = 0; i < peList.size();i++){
		 System.out.println("mark "+i);
		 //Student stu =(Student)peList.get(i);
		 Commodity com =(Commodity)peList.get(i);
%>
         <tr>
           <td>
<%
             out.print(com.getCoid());
%>
           </td>
           <td>
<%
             out.print(com.getConame());
%>
           </td>
         </tr>
<%
	}
%>
<table>


</body>
</html>