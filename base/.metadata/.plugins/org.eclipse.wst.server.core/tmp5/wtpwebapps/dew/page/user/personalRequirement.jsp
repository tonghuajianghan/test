<!-- 个人中心 -->
<%@page import="com.cust.dew.dao.impl.TeacherDBDao"%>
<%@page import="com.cust.dew.vo.*"%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心发布需求</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/ddsmoothmenu.css" />
<link rel="stylesheet" href="<%=basePath%>css/personalcenter.css"
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
			<li><a href="<%=basePath%>page/user/personalrequirement.jsp">发布商品</a>
			</li>
			<li><a href="<%=basePath%>page/user/personalRequirement.jsp">发布需求</a>
			</li>
			<li><a href="<%=basePath %>page/user/login.jsp">退出</a>
			</li>
		</ul>
	</div>
	<div class="requirementRelease" align="center">
		<form method="post" name="login"
			action="<%=basePath%>requirementupload.action"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td>需求名称：</td>
					<td><input type="text" id="requirementname" name="requirementname" />
					</td>
				</tr>
				
				<tr>
					<td>需求类型:</td>
					<td><input type="" id="requirementtype" name="requirementtype" />
					</td>
				</tr>
				<tr>
					<td>需求类型2:</td>
					<td><input type="" id="requirementtype2" name="requirementtype2" />
					</td>
				</tr>
				<tr>
					<td>需求新旧程度:</td>
					<td><input type="text" id="requirementnewold"
						name="requirementnewold" />
					</td>
				</tr>
				<tr>
					<td>需求数量:</td>
					<td><input type="text" id="requirementnumber"
						name="requirementnumber" />
					</td>
				</tr>				
				<tr>
					<td>需求描述:</td>
					<td><input type="text" id="requirementdetail"
						name="requirementdetail" />
					</td>
				</tr>	
				<tr>
					<td>本人id:</td>
					<td><input type="hidden" id="teid"
						name="teid" value="<%=t.getTeid() %>" />
					</td>
				</tr>							
				<tr>
					<td>需求片子:</td>
					<td><input id="mynfile2" type="file" name="myfile" onclick="imgupload()"></td>
				</tr>
				<tr>
					<td><input type="submit" id="requirementsubmit"
						name="requirementsubmit" value="提交" />
					</td>
				</tr>

			</table>
		</form>
		
	</div>

	<div class="footer">©cust 长春理工大学 2014</div>
</body>
</html>