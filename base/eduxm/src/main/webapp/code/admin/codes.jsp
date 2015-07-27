<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%String filename=request.getParameter("filename"); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>代码库管理详细</title>
<link rel="stylesheet" type="text/css" href="../../easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="../../easyui/themes/icon.css"/>
	
<script type="text/javascript" src="../../js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="../../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../../js/comm.js"></script>
<script type="text/javascript" src="codes.js"></script>		

</head>
<body>

<div style="margin:10px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="add()">添加节点</a>
		<!-- <a href="javascript:void(0)" class="easyui-linkbutton" onclick="addChildren()">添加子节点</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="edit()">编辑</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="removeit()">删除</a> -->
</div>
<table id="tg"  style="height:420%"></table> 
<div id="appendFileDlg" class="easyui-dialog" title="编辑节点" style="width: 400px; height: 200px; padding: 10px">
	<form id="appendFileForm" method="post" action="">
		<input id="hfilename" type="hidden" name="filename" value="<%=filename%>"/>
		<input type="hidden" id="hpId" value="" name="parentId"/>
		<input type="hidden" id="oldId" value="" name="oldId"/>
		<table>
			
			<tr>
				<td>代码：</td>
				<td><input id="nodeId" class="easyui-validatebox" type="text" name="obj.id" data-options="required:true" /></td>
			</tr>
			<tr>
				<td>名称：</td>
				<td><input id="nodeText" class="easyui-validatebox" type="text" name="obj.text" data-options="required:true" /></td>
			</tr>
			<tr>
				<td>拼音：</td>
				<td><input id="nodePinyin" class="easyui-validatebox" type="text" name="obj.pinyin"  /></td>
			</tr>
		</table>
	</form>
	<div style="text-align: center; padding: 5px">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitAppendFileForm()">提交</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick='$("#appendFileDlg").form("clear"); '>重置</a>
	</div>
</div>
	
</body>
</html>