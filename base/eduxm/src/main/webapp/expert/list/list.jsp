<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.*,java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String cp = request.getContextPath();
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评审推荐</title>
<link rel="stylesheet" type="text/css" href="../../easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="../../easyui/themes/icon.css"/>
<script type="text/javascript" src="../../js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="../../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../js/jquery.form.js"></script>
<script type="text/javascript" src="../../easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../../js/comm.js"></script> 
<script type="text/javascript" src="../../js/search.js"></script> 
<script type="text/javascript" src="../../code/code.js"></script>
<script type="text/javascript" src="expert.js"></script>
<script type="text/javascript">
	
	function reloadTable(){
		//关闭对话框
		$("#dlg").window("close");
		$("#expertInfoTable").datagrid("reload");
	}
	window.onload=function(){
		initTable();
	}
//<span id="searchcombo" type="hidden"></span>
</script>
</head>
<body>
<input type="hidden" name="rows" id="p_size"/>
	<form id="searchForm" action="../user/list_user.action" method="post">
		<table id="tableid">
		</table>
		
		<div id="emailWin" class="easyui-dialog"  closed=true>
			<div style="width:100%;margin:20px 0;">发 送给：<div id="stus" style="width:85%"></div></div>
			<div style="width:100%;margin:20px 0;" >主题：<input style="width:85%" name="title"  class="easyui-validatebox" required=true/></div>
			<div style="width:100%;margin:10px 0;">内容：<textarea id="content" name="content" class="easyui-validatebox" rows="10" cols="70" style="width:85%" ></textarea></div>
		</div>
	</form>

	<div style="height:40px; width:100%;">
		<div style="width:100%;  top:68px; right:20px; font-size:12px; text-align:right; color:#020e30;">
			<a class='easyui-linkbutton' href="javascript:void(0);" iconCls='icon-search' onclick="submitSerach(1);">开始检索</a>
		</div>
	</div>

	<table id="expertInfoTable" style="position: fixed; top:100px;"></table>
	
	<div id="dlg"></div>
</body>
</html>