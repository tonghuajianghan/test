<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>科研项目管理平台</title>
<link rel="stylesheet" type="text/css" href="<%=cp %>/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="<%=cp %>/easyui/themes/icon.css"/>
<script type="text/javascript" src="<%=cp %>/js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="<%=cp %>/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=cp %>/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
function check(){
	if(window != top)
		top.location = "<%=cp%>/index.jsp";
}
function submitForm() {
	
	if(!$("#loginForm").form("validate")) {
		return;
	}
	
	$('#loginForm').submit();
}
</script>

</head>
<body class="easyui-layout" id="tbody" onload="check();">
	<div region="center" style="background: #DEDEE0 url(images/bodybg.jpg);" >
		<center><br/><br/><br/><h1>科研项目管理平台</h1></center>
		<div class="easyui-dialog" title="用 户 登 陆" style="width:400px;height:300px;padding-top:18%;text-align: center;"
			 buttons="#dlg-buttons" resizable="false" draggable="false" closable="false">
			<form id="loginForm" action='' method="post">
				<div style="padding:10px;">
					用户名&nbsp;:&nbsp;<input class="easyui-validatebox" type="text" name="username"
					data-options="required:true"  />
				</div>
				<div style="padding:10px;">
					密　码&nbsp;:&nbsp;<input class="easyui-validatebox" id="pwd" type="password" name="password"
										data-options="required:true" />
				</div>
			</form>
		</div>
		
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm();">登录</a>
		</div>
	</div>
</body>
</html>