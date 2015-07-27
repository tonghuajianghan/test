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
<link rel="stylesheet" type="text/css" href="../../easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="../../easyui/themes/icon.css"/>
		
	<script type="text/javascript" src="../../js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="../../js/jquery.form.js"></script>
	<script type="text/javascript" src="../../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../../easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="../../js/comm.js"></script>
	<script type="text/javascript" src="../../js/search.js"></script>
	<script type="text/javascript" src="project.js"></script>
	<script type="text/javascript" src="../../js/index.js"></script> 
	<script type="text/javascript" src="../../code/code.js"></script> 
	<script type="text/javascript">
	window.onload=function(){
		$('#main-center').tabs({
		    border:false,
		    onSelect:function(title){
		        if(title == "项目成员信息"){
		        	initMember('<%=projectId%>');
		        }
		        if(title == "负责人承担项目信息"){
		        	initPrincipalProj('<%=projectId%>');
		        }
		        if(title == "负责人和成员近期的研究成果信息"){
		        	initAchievementBefore('<%=projectId%>');
		        }
		    }
		});
	}
	</script>
</head>
<body class="easyui-layout" style="overflow: auto">
	<div data-options="region:'center',split:false,overflow:true">
		<div id="main-center" class="easyui-tabs" fit="true" border="false">
			<div title="项目信息" style="padding: 20px;" closable="false" href="Project_details.action?obj.xm_id=<%=projectId%>">
			</div>
			<div title="项目负责人信息" style="padding: 20px;" closable="false" href="Principal_load.action?projectid=<%=projectId%>"></div>
			<div title="项目成员信息" style="padding: 20px;" closable="false">
				<table id="memberTable" style="position: fixed; top:100px;"></table>
			</div>
			<div title="负责人承担项目信息" style="padding: 20px;" closable="false" >
				<table id="principalProjTable" style="position: fixed; top:100px;"></table>
			</div>
			<div title="负责人和成员近期的研究成果信息" style="padding: 20px;" closable="false">
				<table id="achievementBeforeTable" style="position: fixed; top:100px;"></table>
			</div>
		</div>
	</div>
</body>
</html>
