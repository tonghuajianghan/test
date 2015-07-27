<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.*, java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% String cp = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-
transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>负责人信息</title>
	<link rel="stylesheet" type="text/css" href="../../easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="../../easyui/themes/icon.css"/>
		
	<script type="text/javascript" src="../../js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="../../js/jquery.form.js"></script>
	<script type="text/javascript" src="../../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../../easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="../../js/comm.js"></script>
	<script type="text/javascript" src="../../js/search.js"></script>
</head>
<body>
<div class="easyui-panel" >
	 <div style="padding:10px 0 10px 1px">
		<table id="main_table" border="1px;" style="border:solid #add9c0;width:850px;font-size:16px;border:solid #add9c0; border-width:1px 0px 0px 1px;">
			<tr>	
			<td><label>负责人姓名</label></td>
				<td><s:property value="obj.fzrxm"/></td>
				<td><label>性别</label></td>
				<td><s:property value="obj.xb"/></td>
				<td><label>民族</label></td>
				<td><s:property value="obj.mz"/></td>
			</tr>
			<tr>
				<td><label>出生年月</label></td>
				<td><s:property value="obj.csny"/></td>
				<td><label>行政职务</label></td>
				<td><s:property value="obj.xzzw"/></td>
				<td><label>研究专长</label></td>
				<td><s:property value="obj.yjzc"/></td>
			</tr>
			<tr>	
				<td><label>联系电话</label></td>
				<td><s:property value="obj.lxdh"/></td>
				<td><label>担任导师</label></td>
				<td><s:property value="obj.drds"/></td>
				<td><label>工作单位</label></td>
				<td><s:property value="obj.gzdw"/></td>
			</tr>
			
			<tr>	
			<tr>	
				<td><label>最后学位</label></td>
				<td><s:property value="obj.zhxw"/></td>
				<td><label>邮编</label></td>
				<td><s:property value="obj.yb"/></td>
				<td><label>是否担任其他项目</label></td>
				<td><s:property value="obj.sfdrqtxm"/></td>
				
			</tr>
				<td><label>最后学历</label></td>
				<td><s:property value="obj.zhxl"/></td>
				<td><label>通讯地址</label></td>
				<td colspan="3"><s:property value="obj.txdz"/></td>
			</tr>
		</table>
	 </div>
</div>
</body>
