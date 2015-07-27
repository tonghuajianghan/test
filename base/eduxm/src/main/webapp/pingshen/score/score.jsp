<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.*,java.util.*"%>
<%
	String cp = request.getContextPath();
%>
<%
	String projectId = request.getParameter("projectId");
%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评审打分</title>
<link rel="stylesheet" type="text/css"
	href="../../easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="../../easyui/themes/icon.css" />
<script type="text/javascript" src="../../js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="../../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../js/jquery.form.js"></script>
<script type="text/javascript"
	src="../../easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../../js/comm.js"></script>
<script type="text/javascript" src="../../js/search.js"></script>
<script type="text/javascript" src="../../code/code.js"></script>
<script type="text/javascript" src="score.js"></script>
<script type="text/javascript">
	$.extend($.fn.validatebox.defaults.rules, {  
	    selectValueRequired: {  
	        validator: function (value, param) {  
	            if (value == "" || value=="---请选择分数---") { return false; }  
	            else { return true; }  
	        },  
	        message: '请选择分数'  
	    }  
	});  

	function reloadTable() {
		$("#dlg").window("close");
		$("#groupInfoTable").datagrid("reload");
	}
	window.onload = function() {
		initTable();
	}
	
	function submitAddScor() {
		//使用easyui的表单验证方式
		$("#score_add").form('submit',{
			 url:'Score_add.action',
			 onSubmit:function () {
				 		return $(this).form("validate");
		},
	 	success:function(data){
	 		if(!$.trim($(data).find('span').text())=="添加成功"){
	 			parent.msgshow("提示信息","打分失败！","info");
	 			/*  $.messager.alert("提示信息","添加失败！","info");   */
	 		}else{
	 			parent.msgshow("提示信息",$(data).find('span').text(),"info");
	 			/* $.messager.alert("提示信息",$(data).find('span').text(),"info");   */
	 		}
	 		parent.reload(); 
		 }
		}); 
	}
</script>
</head>
<body>
	<div class="easyui-panel">
		<div style="padding: 10px 0 10px 1px">
			<form id="score_add" method="post">
			<input type="hidden" id="xm_id" name="obj.xm_id" value="<%=request.getParameter("projectId") %>" />
			<input type="hidden" id="zjid" name="obj.zjid" value="<%=request.getRemoteUser()%>" />
				<table id="main_table">
					<tr>
						<td><label for="fs1">创新性</label></td>
						<td><select id="fs1" name="obj.fs1" class="easyui-combobox" required="true" validtype="selectValueRequired">
								<option>---请选择分数---</option>
								<option>100</option>
								<option>90</option>
								<option>70</option>
								<option>65</option>
						</select></td></tr>
						<tr>
						<td><label for="fs2">可行性</label></td>
						<td><select id="fs2" name="obj.fs2" class="easyui-combobox" required="true" validtype="selectValueRequired">
								<option>---请选择分数---</option>
								<option>100</option>
								<option>90</option>
								<option>70</option>
								<option>65</option>
						</select></td></tr><tr>
						<td><label for="fs3">特点1</label></td>
						<td><select id="fs3" name="obj.fs3" class="easyui-combobox" required="true" validtype="selectValueRequired">
								<option>---请选择分数---</option>
								<option>100</option>
								<option>90</option>
								<option>70</option>
								<option>65</option>
						</select></td></tr><tr>
						<td><label for="fs4">特点2</label></td>
						<td><select id="fs4" name="obj.fs4" class="easyui-combobox" required="true" validtype="selectValueRequired">
								<option>---请选择分数---</option>
								<option>100</option>
								<option>90</option>
								<option>70</option>
								<option>65</option>
						</select></td></tr>
							<tr>
				<td colspan="2" style="text-align: center; padding: 5px">  
					<a class="easyui-linkbutton" href="javascript:void(0);" onclick="return submitAddScor();">提&nbsp;&nbsp;交</a>
				</td> 
			</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>