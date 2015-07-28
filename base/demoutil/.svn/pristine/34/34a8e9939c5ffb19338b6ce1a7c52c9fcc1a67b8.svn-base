<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	
	<title>转  账</title>
	
	<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.3.4/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="../jquery-easyui-1.3.4/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="../jquery-easyui-1.3.4/demo/demo.css"/>
    
    <script type="text/javascript" src="../js/jquery-1.7.1.js"></script>
    <script type="text/javascript" src="../js/jquery.form.js"></script>
    <script type="text/javascript" src="../jquery-easyui-1.3.4/jquery.easyui.min.js"></script>	
    <script type="text/javascript" src="../jquery-easyui-1.3.4/locale/easyui-lang-zh_CN.js"></script>
	
	<script type="text/javascript" src="../atm/js/tran_form.js"></script>
	<script type="text/javascript" src="../js/comm.js"></script>
</head>
<body>
	<div class="demo-info">
        <div class="demo-tip icon-tip"></div>
        <div>欢迎使用ATM<font size="+1" color="red"><b>转账</b></font>业务！请在下方正确输入目标账户以及转账金额。注意：你只能输入数字。</div>
    </div>
    
	<div style="margin:10px 0;"></div>

	<form id="tranform" action="tran.action" method="post">
		<table>
			<tr>
		       <td>对方账户&nbsp;：&nbsp;</td>
		       <td><input id="desID" name="desAcc" class="easyui-numberbox" data-options="required:true"/></td>
			</tr>
			<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
			<tr>
	          <td>转账金额&nbsp;：&nbsp;</td>
	          <td><input id="inputMoney" name="money" class="easyui-numberbox" data-options="required:true,min:0,precision:2"/></td>
			</tr>
	       	<tr><td>&nbsp;</td><td>&nbsp;</td></tr>
			<tr>
	       		<td colspan="2" align="right"><a href="javascript:void(0)" iconCls="icon-ok" class="easyui-linkbutton" onclick="doTran();">确&nbsp;&nbsp;定</a></td>
			</tr>
		</table>	
	</form>
</body>
</html>