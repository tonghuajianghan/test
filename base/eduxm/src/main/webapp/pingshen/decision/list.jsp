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
<title>评审决策</title>
<link rel="stylesheet" type="text/css" href="../../easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="../../easyui/themes/icon.css"/>
<script type="text/javascript" src="../../js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="../../js/jquery.form.js"></script>
<script type="text/javascript" src="../../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../../js/comm.js"></script> 
<script type="text/javascript" src="../../js/search.js"></script> 
<script type="text/javascript" src="../../code/code.js"></script> 
<script type="text/javascript" src="decision.js"></script>
<script type="text/javascript">
	function reloadTable(){
		//关闭对话框
		$("#dlg").window("close");
		$("#decisionInfoTable").datagrid("reload");
	}
	
 	var user='<%=request.getRemoteUser()%>'; 
	
	
	window.onload=function(){
		initTable(user);

	}
	
</script>
</head>
<body>
	<input type="hidden" name="rows" id="p_size"/>
	<form id="searchForm" method="post">
		<table id="tableid">
				<tr>
					<td><input type="hidden" id="logi1" name="search.logicalopts" value="and" /> &nbsp;&nbsp;</td>
					<td>
						<input type="hidden" id="col1" name="search.columns" value="c_xmlb"/> 
						<input type="hidden" id="oper1" name="search.operators" value="eq"/>
						<input type="hidden" id="order1" name="search.orders" value="none"/>
						<select id="searchCol" name="search.values">
							<option value="信息化专项">信息化专项</option>
						</select>
					</td>
					<td>
  						<input type="hidden" id="logi2" name="search.logicalopts" value="and" />  
 						<input type="hidden" id="col2" name="search.columns" value="c_yjlx"/>   
 						<input type="hidden" id="oper3" name="search.operators" value="eq"/>  
 						<input type="hidden" id="order4" name="search.orders" value="none"/>  
						<select id="searchOpera" name="search.values">
<!-- 							<option value="-">---请选择技术领域---</option> -->
							<option value="WU">WU</option>
							<option value="you">you</option>
						</select>
					</td>
					
					<td id="td_0"><input id="searchVal" name="obj" type="text" /></td>
					
					<td>
						<input id="passRate" name="passRate" class="easyui-validatebox">
					</td>
					<td>
						
					</td>
				</tr>
		</table>
		
		<div id="emailWin" class="easyui-dialog"  closed=true>
			<div style="width:100%;margin:10px 0;"><textarea id="content" name="content" class="easyui-validatebox" rows="10" cols="70" style="width:85%" ></textarea></div>
		</div>
	</form>

	<div style="height:40px; width:100%;">
		<div style="width:100%;  top:68px; right:20px; font-size:12px; text-align:right; color:#020e30;">
			<a class='easyui-linkbutton' href="javascript:void(0);" iconCls='icon-search' onclick="submitSerach(1);">计算</a>
		</div>
	</div>
	
	<table id="decisionInfoTable" style="position: fixed; top:100px;"></table>
	
	<div id="dlg"></div>

</body>
</html>