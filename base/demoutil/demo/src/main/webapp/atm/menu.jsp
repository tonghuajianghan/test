<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
</head>
<body>
<ul>
<li><a href="welcome.action" target="main">查询</a></li>
<li><a href="save_form.action" target="main">存款</a></li>
<li><a href="take_form.action" target="main">取款</a></li>
<li><a href="tran_form.action" target="main">转帐</a></li>
<li><a href="logs.action" target="main">日志</a></li>
<li><a href="#" onclick="top.location='../logoff.jsp';return false;">退出</a></li>
</ul>
</body>
</html>