<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>用户信息</title>
</head>
<body>
	<form action="password_change" class="cssform" method="post">
		<p>用户信息</p>
		<s:if test="errormsg != null">
			<p style="color: #FF0000">
				错误：
				<s:property value="errormsg" />
			</p>
		</s:if>
			<p>
				<label for="username">用户名：</label> <input id="username" type="text"
					name="username" value="<%=request.getRemoteUser()%>" />
			</p>
			<p>
				<label for="opassword">原密码：</label> <input id="opassword"
					type="password" name="opassword" />
			</p>
			<p>
				<label for="npassword">新密码：</label> <input id="npassword"
					type="password" name="npassword" />
			</p>
			<p>
				<label for="cpassword">确认新密码：</label> <input id="cpassword"
					type="password" name="cpassword" />
			</p>
			<div style="margin-left: 150px;">
				<input type="submit" value="更新" class="button" />
			</div>
		</form>
</body>
</html>