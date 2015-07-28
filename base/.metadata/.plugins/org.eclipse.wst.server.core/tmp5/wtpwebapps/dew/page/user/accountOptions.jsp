<!-- 个人中心 -->
<%@page import="com.cust.dew.dao.impl.CommodityDBDao"%>
<%@page import="com.cust.dew.dao.impl.CommodityteacherDBDao"%>
<%@page import="com.cust.dew.dao.impl.TeacherDBDao"%>
<%@page import="com.cust.dew.vo.*"%>

<%@page import="com.cust.dew.util.Pagination"%>
<%@page import="com.cust.dew.dao.impl.DaoFactory"%>
<%@page import="com.cust.dew.dao.impl.RequirementDBDao"%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
  Pagination p = new Pagination();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath %>css/ddsmoothmenu.css" />
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
			<li><a href="<%=basePath %>page/user/accountOptions.jsp">修改资料</a>
			</li>
			<li><a href="<%=basePath %>page/user/personalCommodity.jsp">发布商品</a>
			</li>
			<li><a href="<%=basePath %>page/user/personalRequirement.jsp">发布需求</a>
			</li>
			<li><a href="<%=basePath %>page/user/login.jsp">退出</a>
			</li>
		</ul>
	</div>
	<div class="PersonRelease" align="center">
		<form method="post" name="login"
			action="<%=basePath%>accountupload.action"
			enctype="multipart/form-data">
			<table>
			    <tr>
					<td>我的id：</td>
					<td><input type="hidden" id="teid" name="teid" value="<%= t.getTeid()%>"/>
					</td>
				</tr>
				<tr>
					<td>我的名字：</td>
					<td><input type="text" id="tename" name="tename" value="<%=t.getTename() %>" />
					</td>
				</tr>
				<tr>
					<td>我的email:</td>
					<td><input type="text" id="teemail"
						name="teemail" />
					</td>
				</tr>
				<tr>
					<td>我的密码:</td>
					<td><input type="password" id="tepassword" name="tepassword" />
					</td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input type="password" id="tepassword2" name="tepassword2" />
					</td>
				</tr>
				<tr>
					<td>我的类型:</td>
					<td><input type="text" id="tetype"
						name="tetype" />
					</td>
				</tr>
				<tr>
					<td>我的电话:</td>
					<td><input type="text" id="tetel"
						name="tetel" />
					</td>
				</tr>
				<tr>
					<td>所属学校:</td>
					<td><input type="text" id="teschool"
						name="teschool" />
					</td>
				</tr>
				
				<tr>
					<td>所属专业:</td>
					<td><input type="text" id="teaddress"
						name="teaddress" />
					</td>
				</tr>
				
				<tr>
					<td>我的记录:</td>
					<td><input type="text" id="terecard" name="terecard" />
					</td>
				</tr>

				<tr>
					<td>购物车:</td>
					<td><input type="text" id="tecar"
						name="tecar" />
					</td>
				</tr>
				
				<tr>
					<td>我的照片:</td>
					<td><input id="mynfile2" type="file" name="myfile" onclick="imgupload()"></td>
				</tr>
				<tr>
					<td><input type="submit" id="commoditysubmit"
						name="commoditysubmit" value="提交" />
					</td>
				</tr>

			</table>
		</form>
		
	</div>	
	<div class="footer">©cust 长春理工大学 2014</div>
</body>
</html>