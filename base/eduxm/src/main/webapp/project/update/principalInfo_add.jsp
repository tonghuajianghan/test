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
		<title>添加负责人</title>
		<link rel="stylesheet" type="text/css" href="../../easyui/themes/default/easyui.css"/>
		<link rel="stylesheet" type="text/css" href="../../easyui/themes/icon.css"/>
		<script type="text/javascript" src="../../js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="../../easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="../../easyui/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="../../js/comm.js"></script> 
		<script type="text/javascript" src="../../js/search.js"></script> 
		<script type="text/javascript" src="principalInfo.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){  //对应下拉菜单
				combobox('mz', '../../code/mz.json')
			});
			function submitAddPrincipal() {     
				//使用easyui的表单验证方式
				$("#PrincipalInfo_add").form('submit',{
					 url:'../../project/Principal_add.action',    
					 onSubmit:function () {
						 var numreg = new RegExp('^[0-9]*$');
						 $('#fzrmc').append('<span style>负责人名称不能有特殊符号 \/:*%()~!:;\'#$?\\\"<>|</span>');
							/* if(numreg.test($('#year').val())&&($('#year').val().length==4)){
								return $(this).form("validate");
							}
							$.messager.alert("提示信息","年度为数字","info"); */
							return false;
							
				},
			 	success:function(data){
			 		if($.trim($(data).find('span').text())!="添加成功"){
			 			$.messager.alert("提示信息","添加失败！","info");
			 		}else{
			 			$.messager.alert("提示信息",$(data).find('span').text(),"info");
			 		}
				 	parent.reloadTableAfterUpdateOrAdd();
				 }
				}); 
			}
			
			//重置
			function clearForm() {
				$("#PrincipalInfo_add").form('clear');  
			}
		</script>
	</head>
	<body>
	<div class="easyui-panel"  >
		 <div style="padding:10px 0 10px 1px">
		 	<form id="principalInfo_add" method="post" >  
			<table id="main_table">
				<tr>
					<td><label for="fzrxm">负责人姓名</label></td>
					<td><input id="fzrxm" maxlength="50" name="obj.fzrxm"  class='easyui-validatebox' type="text"/></td>
					<td><label for="xb">专业领域</label></td>
					<td><input id="xb" name="obj.xb" class="easyui-combobox" /></td>
				</tr>
				<tr>
					<td><label for="csny">出生年月</label></td>
					<td><input id="csny" maxlength="4" name="obj.csny" class="easyui-datebox" type="text" />	</td>
					<td><label for="xzzw">行政职务</label></td>
					<td><input id="xzzw" maxlength="50" name="obj.xzzw" class="easyui-validatebox" /></td>
				</tr>
				<tr>
					<td><label for="ywzw">业务职务</label></td>
					<td><input id="ywzw" maxlength="200" name="obj.ywzw" class='easyui-validatebox'   type="text"/></td>
					<td><label for="yjzc">研究专长</label></td>
					<td><input id="yjzc" maxlength="200" name="obj.yjzc" class='easyui-validatebox' type="text"/></td>
				</tr>
				<tr>
					<td><label for="zhxl">最后学历</label></td>
					<td><input id="zhxl" maxlength="200" name="obj.zhxl" class='easyui-validatebox'  type="text"/></td>
					<td><label for="zhxw">最后学位</label></td>
					<td><input id="zhxw" maxlength="200" name="obj.zhxw"  class='easyui-validatebox' type="text"/></td>
				</tr>
				<tr>
					<td><label for="drds">担任导师</label></td>
					<td><input id="drds" maxlength="200" name="obj.drds"  class='easyui-validatebox'  type="text"/></td>
					<td><label for="gzdw">工作单位</label></td>
					<td><input id="gzdw" maxlength="200" name="obj.gzdw"  class='easyui-validatebox' type="text"/></td>
				</tr>
				<tr>
					<td><label for="lxdh">联系电话</label></td>
					<td><input id="lxdh" maxlength="200" name="obj.lxdh"  class='easyui-validatebox'   type="text"/></td>
					<td><label for="dxdz">通讯地址</label></td>
					<td><input id="dxdz" maxlength="200" name="obj.dxdz"  class='easyui-validatebox' type="text"/></td>
				</tr>
				<tr>
					<td><label for="yb">邮编</label></td>
					<td><input id="yb" maxlength="200" name="obj.yb"  class='easyui-validatebox'  type="text"/></td>
					<td><label for="sfdrqtxm">是否担任其他项目</label></td>
					<td><input id="sfdrqtxm" maxlength="200" name="obj.sfdrqtxm" class='easyui-validatebox' type="text"/></td>
				</tr>
				<tr>
					<td colspan="4" style="text-align: center; padding: 5px">  
						<a class="easyui-linkbutton" href="javascript:void(0);" onclick="return submitAddPrincipal();">保&nbsp;&nbsp;存</a>
						<a class="easyui-linkbutton" href="javascript:void(0);" onclick="return clearForm();">重&nbsp;&nbsp;置</a>
					</td> 
				</tr>
			</table>
			</form>
		 </div>
	</div>
</body>
</html>