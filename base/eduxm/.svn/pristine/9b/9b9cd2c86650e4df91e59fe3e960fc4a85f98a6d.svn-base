<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.*,java.util.*"%>
<%
	String cp = request.getContextPath();
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>专家分组</title>
<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css"/>
<script type="text/javascript" src="../js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/jquery.form.js"></script>
<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/comm.js"></script> 
<script type="text/javascript" src="../js/search.js"></script> 
<script type="text/javascript" src="user.js"></script> 
<script type="text/javascript">
	function reloadTable(){
		//关闭对话框
		$("#dlg").window("close");
		$("#groupInfoTable").datagrid("reload");
	}
	window.onload=function(){
		initTable();
	}
</script>
</head>
<body>
	<input type="hidden" name="rows" id="p_size"/>
	<form id="searchForm" action="../../group/Group_list.action" method="post">
		<table id="tableid">
				<tr>
					<td><input type="hidden" name="search.logicalopts" value="" /> &nbsp;&nbsp;</td>
					<td>
						<select id="searchCol" name="search.columns" onchange="change(0,this)">
							<option value="-">---请选择要检索的单元---</option>
							
							<option value="c_username">用户姓名</option>
							<option value="c_roles">用户角色</option>
							<option value="c_orgcode">用户组织</option>
						</select>
					</td>

					<td>
						<select id="searchOpera" name="search.operators">
							<option value="eq">=</option>
							<option value="ne">&ne;</option>
							<option value="gt">&gt;</option>
							<option value="ge">&ge;</option>
							<option value="lt">&lt;</option>								
							<option value="le">&le;</option>
							<option value="like">like</option>
						</select>
					</td>
					
					<td id="td_0"><input id="searchVal" name="search.values" type="text" /></td>
					
					<td>
						<select name="search.orders">
							<option value="none">不排序</option>
							<option value="asc">升序</option>
							<option value="desc">降序</option>
						</select>
					</td>
					<td>
						 <a class="easyui-linkbutton" iconCls='icon-add' href="javascript:addSelect();">添加检索项</a>
					</td>
				</tr>
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

	<table id="groupInfoTable" style="position: fixed; top:100px;"></table>
	
	<div id="dlg"></div>






</body>
</html>