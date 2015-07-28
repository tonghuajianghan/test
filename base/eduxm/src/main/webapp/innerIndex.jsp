<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.*,java.util.*"%>
<%
	String cp = request.getContextPath();
	String projectId = request.getParameter("projectId");
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>innerIndex</title>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"/>
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/index.js"></script> 
<script type="text/javascript">

</script>
</head>
<body class="easyui-layout" style="overflow: auto">
	<div data-options="region:'center',split:false,overflow:true">
		<div id="main-center" class="easyui-tabs" fit="true" border="false">
			<div title="项目信息" style="padding: 20px;" closable="false" href="check/Project_details.action?obj.xm_id=<%=projectId%>">
				
			</div>
			<div title="项目负责人信息" style="padding: 20px;" closable="false" href="check/Principal_load.action?projectid=<%=projectId%>"></div>
			<div title="项目成员信息" style="padding: 20px;" closable="false"  href="pingshen/check/member.jsp"></div>
			<div title="负责人承担项目信息" style="padding: 20px;" closable="false"  href="pingshen/check/principalProj.jsp"></div>
			<div title="负责人和成员近期的研究成果信息" style="padding: 20px;" closable="false"  href="project/details/achievementBefore_list.jsp"></div>
		</div>
	</div>
</body>
</html>
