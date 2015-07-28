<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.text.*, java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<% String cp = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-
transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>修改专家分组</title>
	<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css"/>
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css"/>
	<script type="text/javascript" src="../js/jquery-1.7.1.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="../js/comm.js"></script> 
	<script type="text/javascript" src="../js/search.js"></script> 
	<script type="text/javascript" src="projectInfo.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			//combobox('groupField', '../code/zy.json');   //下拉列表
		});
		function submitUpdate() {
			$("#projectInfo_update").form('submit',{
				url : '../project/Project_update.action',
				onSubmit : function() {
					var numreg = new RegExp('^[0-9]*$');
						return false;
				},
				success : function(data) {
					if($.trim($(data).find('span').text())!="修改成功"){
			 			$.messager.alert("提示信息","修改失败！","info");
			 		}else{
			 			$.messager.alert("提示信息",$(data).find('span').text(),"info");
			 		}
				 	parent.reloadTableAfterUpdateOrAdd();
				}
			});
		}
		//重置
		function clearForm() {;
			$("#projectInfo_update")[0].reset();
		} 
		
	</script>
</head>
<body>
<div class="easyui-panel" >
	 <div style="padding:10px 0 10px 1px">
	 	<form id="projectInfo_update" action="" method="post">
	 	<input type="hidden" name="obj.id" value="<s:property value="obj.id"/>"/>
		<table id="main_table" >
			<tr>
				<td><label for="zt">状态</label></td>
				<td><input id="zt" maxlength="50" name="obj.zt" class='easyui-validatebox' required="true" type="text"/></td>
				<td><label for="xmmc">项目名称</label></td>
				<td><input id="xmmc" name="obj.xmmc" class="easyui-combobox" required="true"/></td>
			</tr>
			<tr>
				<td><label for="sqnd">申请年度</label></td>
				<td><input id="sqnd" maxlength="4" name="obj.sqnd" />	</td>
				<td><label for="cgxs">成果形式</label></td>
				<td><input id="cgxs" maxlength="50" name="obj.cgxs" class="easyui-validatebox" /></td>
			</tr>
			<tr>
				<td><label for="kssj">开始时间</label></td>
				<td><input id="kssj" maxlength="200" name="obj.kssj" class='easyui-validatebox' required="true"  type="text"/></td>
				<td><label for="jssj">结束时间</label></td>
				<td><input id="jssj" maxlength="200" name="obj.jssj" class='easyui-validatebox' type="text"/></td>
			</tr>
			<tr>
				<td><label for="jhwcsj">计划完成时间</label></td>
				<td><input id="jhwcsj" maxlength="50" name="obj.jhwcsj" class='easyui-validatebox' required="true" type="text"/></td>
				<td><label for="xmlb">项目类别</label></td>
				<td><input id="xmlb" name="obj.xmlb" class="easyui-combobox" required="true"/></td>
			</tr>
			<tr>
				<td><label for="yjlx">研究类型</label></td>
				<td><input id="yjlx" maxlength="50" name="obj.yjlx" class='easyui-validatebox' required="true" type="text"/></td>
				<td><label for="xkmc">学科名称</label></td>
				<td><input id="xkmc" name="obj.xkmc" class="easyui-combobox" required="true"/></td>
			</tr>
			<tr>
				<td><label for="xkdm">学科代码</label></td>
				<td><input id="xkdm" maxlength="50" name="obj.xkdm" class='easyui-validatebox' required="true" type="text"/></td>
				<td><label for="tbsj">填报时间</label></td>
				<td><input id="tbsj" name="obj.tbsj" class="easyui-combobox" required="true"/></td>
			</tr>
			<tr>
				<td><label for="ysze">预算总额</label></td>
				<td><input id="ysze" maxlength="50" name="obj.ysze" class='easyui-validatebox' required="true" type="text"/></td>
				<td><label for="sqze">申请总额</label></td>
				<td><input id="sqze" name="obj.sqze" class="easyui-combobox" required="true"/></td>
			</tr>
			<tr>
				<td><label for="sqmx">申请明细</label></td>
				<td><input id="sqmx" maxlength="50" name="obj.sqmx" class='easyui-validatebox' required="true" type="text"/></td>
				<td><label for="zcze">自筹总额</label></td>
				<td><input id="zcze" name="obj.zcze" class="easyui-combobox" required="true"/></td>
			</tr>
			<tr>
				<td><label for="zcmx">自筹明细</label></td>
				<td><input id="zcmx" maxlength="50" name="obj.zcmx" class='easyui-validatebox' required="true" type="text"/></td>
				<td><label for="sqcn">申请承诺</label></td>
				<td><input id="sqcn" name="obj.sqcn" class="easyui-combobox" required="true"/></td>
			</tr>
			<tr>
				<td><label for="xswyhyj">学术委员会意见</label></td>
				<td><input id="xswyhyj" maxlength="50" name="obj.xswyhyj" class='easyui-validatebox' required="true" type="text"/></td>
				<td><label for="fzrdwyj">负责人单位意见</label></td>
				<td><input id="fzrdwyj" name="obj.fzrdwyj" class="easyui-combobox" required="true"/></td>
			</tr>
			<tr>
				<td><label for="sjzt1">数据状态1</label></td>
				<td><input id="sjzt1" maxlength="50" name="obj.sjzt1" class='easyui-validatebox' required="true" type="text"/></td>
				<td><label for="psfs">评审分数</label></td>
				<td><input id="psfs" name="obj.psfs" class="easyui-combobox" required="true"/></td>
			</tr>
			<tr>
				<td><label for="psjg">评审结果</label></td>
				<td><input id="psjg" maxlength="50" name="obj.psjg" class='easyui-validatebox' required="true" type="text"/></td>
				<td><label for="jgsm">结果说明</label></td>
				<td><input id="jgsm" name="obj.jgsm" class="easyui-combobox" required="true"/></td>
			</tr>
			<tr>
				<td><label for="sjzt2">数据状态2</label></td>
				<td><input id="sjzt2" maxlength="50" name="obj.sjzt2" class='easyui-validatebox' required="true" type="text"/></td>
				<td><label for="tbr">填报人</label></td>
				<td><input id="tbr" name="obj.tbr" class="easyui-combobox" required="true"/></td>
			</tr>
			<tr>
				<td><label for="bz1">备注1</label></td>
				<td><input id="bz1" maxlength="50" name="obj.bz1" class='easyui-validatebox' required="true" type="text"/></td>
				<td><label for="bz2">备注2</label></td>
				<td><input id="bz2" name="obj.bz2" class="easyui-combobox" required="true"/></td>
			</tr>
			<tr>
				<td><label for="bz3">备注3</label></td>
				<td><input id="bz3" maxlength="50" name="obj.bz3" class='easyui-validatebox' required="true" type="text"/></td>
				<td><label for="bz4">备注4</label></td>
				<td><input id="bz4" name="obj.bz4" class="easyui-combobox" required="true"/></td>
			</tr>
			<tr>
				<td colspan="4" style="text-align: center; padding: 5px">  
					<a class="easyui-linkbutton" href="javascript:void(0);" onclick="return submitUpdate();">保&nbsp;&nbsp;存</a>
					<a class="easyui-linkbutton" href="javascript:void(0);" onclick="return clearForm();">重&nbsp;&nbsp;置</a>
				</td> 
			</tr>
		</table>
	 	</form>
	 </div>
</div>
</body>
</html>