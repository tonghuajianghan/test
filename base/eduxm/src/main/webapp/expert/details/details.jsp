<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.*, java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% String cp = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-
transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>专家详细信息</title>
	<link rel="stylesheet" type="text/css" href="../../easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="../../easyui/themes/icon.css"/>
	<script type="text/javascript" src="../../js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="../../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../../easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="../../js/comm.js"></script> 
	<script type="text/javascript" src="../../js/search.js"></script> 
	<%-- <script type="text/javascript" src="expert.js"></script> --%>
	
	<script type="text/javascript">
	$(document).ready(function() {
		
		$(document).ready(function() {

			combobox($('#xb'), '../../code/xb.json');
			
			
			combobox($('#zyly'), '../../code/zy.json');
			 combobox($('#zt'),'../../code/zt.json');


		});
	});
		
		
		
	</script>
</head>
<body>
<div class="easyui-panel" >
	
	 	<form id="expert_update" action="" method="post">
	 	<div style="padding: 10px 0 10px 1px;">
	 	
		
		<table id="main_table">
		
			<tr>
				<td><label for="username">身份证号</label></td>
				<td><input id="username" maxlength="20" name="obj.Username" readonly="readonly" value="<s:property value="obj.username"/>"  missingMessage="请输入用户名" class='easyui-validatebox' required="true" type="text"/></td>
				<td><label for="xm">姓名</label></td>
				<td><input id="xm" maxlength="50"  name="obj.xm" readonly="readonly" value="<s:property value="obj.xm"/>" class="easyui-validatebox" required="true"/></td>
				<td rowspan="4"><div id="preview1">
						<img src="../expert/Expert_download.action?usernames=<s:property value="obj.username"/>" width="150" height="150" /></div></td>
					
				
			</tr>
			<tr>
				<td><label for="xb">性别</label></td>
				<!-- <td><select id="college" name="obj.college" onchange="collegeChange()">	</select></td> -->
				<td><input id="xb" maxlength="20" name="obj.xb" readonly="readonly" value="<s:property value="obj.xb"/>" class="easyui-combobox" required="true"/>	</td>
				<td><label for="zc">职称</label></td>
				<!-- <td><select id="major" name="obj.major"><option value="">-----请先选择学院----</option></select></td> -->
				<td><input id="zc" maxlength="20" name="obj.zc" readonly="readonly" value="<s:property value="obj.zc"/>" class="easyui-validatebox" required="true" /></td>
			
			</tr>
			<tr>
				<td><label for="zw">职务</label></td>
				<td><input id="zw" maxlength="50" name="obj.zw" readonly="readonly" value="<s:property value="obj.zw"/>" missingMessage="请输入职务" class="easyui-validatebox" required="true"  type="text"/></td>
				<td><label for="zyly">专业领域</label></td>
				<td><input id="zyly" maxlength="50" name="obj.zyly" readonly="readonly" value="<s:property value="obj.zyly"/>"  class='easyui-combobox' type="text" required="true"/></td>
			</tr>
			<tr>
				<td><label for="yjfx">研究方向</label></td>
				<td><input id="yjfx" maxlength="100" name="obj.yjfx" readonly="readonly" value="<s:property value="obj.yjfx"/>"  class='easyui-validatebox' required="true"  type="text"/></td>
				<td><label for="csny">出生年月</label></td>
				<td><input id="csny" maxlength="50" name="obj.csny" readonly="readonly" value="<s:property value="obj.csny"/>"  class='easyui-datebox' type="text" required="true"/ ></td>
			</tr>
			<tr>
				<td><label for="ssdw">所属单位</label></td>
				<td><input id="ssdw" maxlength="200" name="obj.ssdw" readonly="readonly" value="<s:property value="obj.ssdw"/>"  class='easyui-validatebox' required="true"  type="text"/></td>
				<td><label for="dzyj">电子邮件</label></td>
				<td><input id="dzyj" maxlength="100" name="obj.dzyj" readonly="readonly" value="<s:property value="obj.dzyj"/>"  class='easyui-validatebox' data-options="required:true,validType:'email'" type="text" required="true"/></td>
			</tr>
			<tr>
				<td><label for="lxdh">联系电话</label></td>
				<td><input id="lxdh" maxlength="50" name="obj.lxdh" readonly="readonly" value="<s:property value="obj.lxdh"/>"  class='easyui-validatebox' required="true"  type="text"/></td>
				<td><label for="zt">状态</label></td>
				<td><input id="zt" maxlength="20" name="obj.zt" readonly="readonly" value="<s:property value="obj.zt"/>"  class='easyui-combobox' required="true"  type="text"/></td>
			 </tr>
			
		    
			<tr>
			   <td><label for="zjjj">专家简介</label></td>
				
				<td colspan="3"><textarea id="zjjj" maxlength="1000" readonly="readonly" cols="41.5" rows="2px" name="obj.zjjj"   class='easyui-validatebox'  required="true"><s:property value="obj.zjjj"/></textarea></td>
			</tr>
			<tr>
				<td><label for="bz">备注</label></td>
				
				<td colspan="3"><textarea id="bz" maxlength="200" readonly="readonly" cols="41.5" rows="2px" name="obj.bz"   class='easyui-validatebox' ><s:property value="obj.bz"/></textarea></td>
			</tr>
			
			</tr>
		</table>
		 </div>
		<%-- <div style="padding: 10px 0 10px 1px; float: left; width: 20%">
			<tr><td><label for="preview1">图片信息</label></td>
			<td><div id="preview1">
						<img src="../expert/Expert_download.action?usernames=<s:property value="obj.username"/>" width="150" height="150" /></div></td>
					</tr>
			</div> --%>
	 	</form>
	
</div>
</body>
</html>