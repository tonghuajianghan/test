<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>登录</title>
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.4/themes/icon.css"/>
    <script type="text/javascript" src="js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="jquery-easyui-1.3.4/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
	<style>
		body {
			color: black;
			font: 12px/1.5 "sans serif",tahoma,verdana,helvetica;
		}
	</style>
</head>
<body class="easyui-layout" id="tbody">
	<div region="center" style="background: #DEDEE0 url(images/bodybg.jpg);" >
		<div class="easyui-dialog" title="银行取款机" style="width:400px;height:300px;padding-top:18%;text-align: center;"
			 buttons="#dlg-buttons" resizable="false" draggable="false" closable="false">
			<form id="loginForm" method="post">
				<div style="padding:10px;">
					用户名&nbsp;:&nbsp;<input id="uname" class="easyui-validatebox" type="text" name="j_username" 
										data-options="required:true"  />
				</div>
				<div style="padding:10px;">
					密　码&nbsp;:&nbsp;<input type="password" class="easyui-validatebox" type="text" name="j_password" 
										data-options="required:true" /><!-- onkeydown="enterLogin(event);return false" -->
				</div>
			</form>
		</div>
		
		<div id="dlg-buttons">
			<a href="#" class="easyui-linkbutton" onclick="submitForm();" >登录</a>
			<a href="#" class="easyui-linkbutton" onclick="clearForm();">重置</a>
		</div>
	</div>
</body>
</html>
