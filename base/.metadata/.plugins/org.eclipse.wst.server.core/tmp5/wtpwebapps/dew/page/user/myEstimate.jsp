<!-- 个人中心 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人中心我的评价</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/ddsmoothmenu.css" />
<link rel="stylesheet" href="<%=basePath %>css/personalcenter.css"
	type="text/css" />
</head>
<body>
	<div class="templatemo_wrapper">
		<div id="templatemo_header1">
			<div class="container">
				<div class="circle"></div>
			</div>
			<div class="detail">
				<div class="detail_left">
					<div class="info1">上山打老虎</div>
					<div class="info">男·水瓶座·吉林省长春市</div>
				</div>
			</div>
		</div>
		<!-- END of templatemo_header -->
	</div>
	<div class="nav">
		<ul>
		    <!-- <li><a>首页</a></li> -->
			<li><a>个人主页</a></li>
			<li><a>我的管家</a></li>
			<li><a>评价</a></li>
			<li><a>发布商品</a></li>
			<li><a>发布需求</a></li>
		</ul>
	</div>
	
	<div class="footer">©cust 长春理工大学 2014
	
	
	</div>
</body>
</html>