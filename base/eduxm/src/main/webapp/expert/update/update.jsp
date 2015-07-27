<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.*,java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-
transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>修改专家信息</title>
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css" />
<link href="../css/bootstrap.css" type="text/css"
	rel="stylesheet" />
<link href="../css/jquery.fileupload.css" type="text/css"
	rel="stylesheet" />

<script type="text/javascript" src="../js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/comm.js"></script>
<script type="text/javascript" src="../js/search.js"></script>
<script type="text/javascript" src="../js/imagePreview.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		combobox($('#xb'), '../code/xb.json');
		
		
		combobox($('#zyly'), '../code/zy.json');


	});
	//图片预览
	
	function submitUpdateExpert() {

		$("#expert_update").form(
				'submit',
				{
					url : '../expert/Expert_update.action',
					onSubmit : function() {

					},
					success : function(data) {

						if ($.trim($(data).find('span').text()) != "修改成功") {
							$.messager.alert("提示信息", "修改失败！", "info");
						} else {
							$.messager.alert("提示信息", $(data).find('span')
									.text(), "info");
						}
						parent.reloadTableAfterUpdateOrAdd();
					}
				});
	}
	//重置
	function clearForm() {
		$("#expert_update").form('clear');
	}
</script>
</head>
<body>
	<div class="easyui-panel">
		
			<form id="expert_update" action="" method="post"
				enctype="multipart/form-data">
				<div style="padding: 10px 0 10px 1px;">
				<!-- 更改图片 -->

				<table id="main_table">
					<tr>
						<td><label for="username">身份证号</label></td>
						<td><input id="username" maxlength="20" name="obj.Username"
							readonly="readonly" value="<s:property value="obj.username"/>"
							missingMessage="请输入用户名" class='easyui-validatebox'
							required="true" type="text" /></td>
						<td><label for="xm">姓名</label></td>
						<td><input id="xm" maxlength="50" name="obj.xm"
							value="<s:property value="obj.xm"/>" class="easyui-validatebox"
							required="true" /></td>
							 <td rowspan="4" >
								<img id="img_prev"
									src="../expert/Expert_download.action?usernames=<s:property value="obj.username"/>"
									width="150" height="150" />
							</td>
							
					</tr>
					<tr>
						<td><label for="xb">性别</label></td>
						<!-- <td><select id="college" name="obj.college" onchange="collegeChange()">	</select></td> -->
						<td><input id="xb" maxlength="20" name="obj.xb"
							value="<s:property value="obj.xb"/>" class="easyui-combobox"
							required="true" />
						</td>
						<td><label for="zc">职称</label></td>
						<!-- <td><select id="major" name="obj.major"><option value="">-----请先选择学院----</option></select></td> -->
						<td><input id="zc" maxlength="20" name="obj.zc"
							value="<s:property value="obj.zc"/>" class="easyui-validatebox"
							required="true" /></td>
							
					</tr>
					<tr>
						<td><label for="zw">职务</label></td>
						<td><input id="zw" maxlength="50" name="obj.zw"
							value="<s:property value="obj.zw"/>" missingMessage="请输入职务"
							class="easyui-validatebox" required="true" type="text" /></td>
						<td><label for="zyly">专业领域</label></td>
						<td><input id="zyly" maxlength="50" name="obj.zyly"
							value="<s:property value="obj.zyly"/>" class='easyui-combobox'
							type="text" required="true" /></td>
					</tr>
					<tr>
						<td><label for="yjfx">研究方向</label></td>
						<td><input id="yjfx" maxlength="100" name="obj.yjfx"
							value="<s:property value="obj.yjfx"/>" class='easyui-validatebox'
							required="true" type="text" /></td>
						<td><label for="csny">出生年月</label></td>
						<td><input id="csny" maxlength="50" name="obj.csny"
							value="<s:property value="obj.csny"/>" class='easyui-datebox'
							type="text" required="true" /></td>
					</tr>
					<tr>
						<td><label for="ssdw">所属单位</label></td>
						<td><input id="ssdw" maxlength="200" name="obj.ssdw"
							value="<s:property value="obj.ssdw"/>" class='easyui-validatebox'
							required="true" type="text" /></td>
						<td><label for="dzyj">电子邮件</label></td>
						<td class="left"><input type="text" id="dzyj" maxlength="100" name="obj.dzyj"
							value="<s:property value="obj.dzyj"/>" class='easyui-validatebox'
							data-options="required:true,validType:'email'" 
							required="true" />
						</td>
							 <td class="left">
                        	<span class="btn btn-success fileinput-button">
								<span>上传照片</span>
								<input id="file" type="file" name="file" onchange="imagePreview(this, 'img_prev');"/>
							</span>
							</td> 
					</tr>
					<tr>
						<td><label for="lxdh">联系电话</label></td>
						<td><input id="lxdh" maxlength="50" name="obj.lxdh"
							value="<s:property value="obj.lxdh"/>" class='easyui-validatebox'
							required="true" type="text" /></td>
						<%-- <td><label for="zt">状态</label></td>
						<td><input id="zt" maxlength="20" name="obj.zt"
							value="<s:property value="obj.zt"/>" class='easyui-combobox'
							required="true" type="text" /></td>
							<td></td> --%>
					</tr>


					<tr>
						<td><label for="zjjj">专家简介</label></td>

						<td colspan="3">
						<textarea id="zjjj" style="width:99%;height:60px;" name="obj.zjjj"
								class='easyui-validatebox' required="true"><s:property value="obj.zjjj" /></textarea></td>
						<td></td>
					</tr>
					<tr>
						<td><label for="bz">备注</label></td>

						<td colspan="3">
						<textarea id="bz" style="width:99%;height:60px;" name="obj.bz" class='easyui-validatebox'
								><s:property value="obj.bz" /></textarea></td>
						<td></td>
					</tr>
					<tr>
						<td colspan="5" style="text-align: center; padding: 5px"><a
							class="easyui-linkbutton" href="javascript:void(0);"
							onclick="return submitUpdateExpert();">保 存</a> 
						</td>
					</tr>
				</table>
				<%--  <div style="padding: 10px 0 10px 1px; float: left; width: 20%">
			<table id="table">
			     

					<tr>
						<td><div id="preview1">
								<img
									src="../expert/Expert_download.action?usernames=<s:property value="obj.username"/>"
									width="150" height="150" />
							</div></td>
						<td><div id="preview">
								<img id="imghead" width="150" height="150" border="0" />
							</div></td>
					</tr>
					 <tr>
						
						<td>
						<span class="fileinput-button">
						<button type="button">上传照片</button>
						<input type="file" name="file" id="file" 
						 onchange="preview(this,'imghead');" />
						</span></td>
					</tr>
			</table>
			</div>  --%>
				</div>
				
			</form>
		
	</div>
</body>
</html>