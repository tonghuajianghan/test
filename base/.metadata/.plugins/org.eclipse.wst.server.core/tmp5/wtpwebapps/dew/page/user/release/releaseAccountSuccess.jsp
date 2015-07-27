<!-- 个人中心 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@page import="com.cust.dew.dao.impl.CommodityDBDao"%>
<%@page import="com.cust.dew.dao.impl.CommodityteacherDBDao"%>
<%@page import="com.cust.dew.dao.impl.TeacherDBDao"%>
<%@page import="com.cust.dew.vo.*"%>

<%@page import="com.cust.dew.util.Pagination"%>
<%@page import="com.cust.dew.dao.impl.DaoFactory"%>
<%@page import="com.cust.dew.dao.impl.RequirementDBDao"%>

<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心资料上传</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/ddsmoothmenu.css" />
<link rel="stylesheet" href="<%=basePath %>css/personalcenter.css"
	type="text/css" />
</head>
<body>
	<% 
	  System.out.println("teacher1:");
	  TeacherDBDao td = new TeacherDBDao();
	  String tename = (String)session.getAttribute("loginauthor");
	  List<Teacher> te = td.queryTeacherByNameAll(tename);
	  Teacher t = new Teacher();
	  for(int i =0;i<te.size();i++){
		  t = (Teacher)te.get(i);
		  System.out.println("teacher:" + t.getTename());
	  }
	%>

	<div class="templatemo_wrapper">
		<div id="templatemo_header1">
			<div class="container">
				<div class="circle"></div>
			</div>
			<div class="detail">
				<div class="detail_left">
					<div class="info1"><%=t.getTename() %></div>
					<div class="info"><%=t.getTeschool()%>·<%=t.getTeadress()%>·<%=t.getTetel() %></div>
				</div>
			</div>
		</div>
		<!-- END of templatemo_header -->
	</div>
	<div class="nav">
		<ul>
			<!-- <li><a>首页</a></li> -->
			<li><a href="<%=basePath %>/page/user/personalcenter.jsp">个人主页</a>
			</li>
			<li><a href="<%=basePath%>page/user/accountOptions.jsp">个人资料</a>
			</li>
			<li><a href="<%=basePath%>page/user/personalCommodity.jsp">发布商品</a>
			</li>
			<li><a href="<%=basePath%>page/user/personalRequirement.jsp">发布需求</a>
			</li>
			<li><a href="<%=basePath %>page/user/login.jsp">退出</a>
			</li>
		</ul>
	</div>
	<div>
	   个人资料上传成功
	</div>
	
	<div class="footer">©cust 长春理工大学 2014
	
	
	</div>
</body>
</html>