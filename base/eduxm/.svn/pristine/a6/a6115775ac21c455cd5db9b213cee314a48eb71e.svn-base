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
<title>添加专家</title>
<link rel="stylesheet" type="text/css"
	href="../../easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="../../easyui/themes/icon.css" />
<link href="../../css/bootstrap.css" type="text/css" rel="stylesheet" />
<link href="../../css/jquery.fileupload.css" type="text/css"
	rel="stylesheet" />

<script type="text/javascript" src="../../js/jquery-1.7.1.js"></script>
<script type="text/javascript" src="../../easyui/jquery.eas	yui.min.js"></script>
<script type="text/javascript"
	src="../../easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../../js/comm.js"></script>
<script type="text/javascript" src="../../js/search.js"></script>
<script type="text/javascript" src="../list/expert.js"></script>
<script type="text/javascript" src="../../js/imagePreview.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		/* combobox('zyly', '../code/zy.json'); */

		//$("#xb").combobox('reload', '../../code/xb.json');
		//$("#zt").combobox('reload', '../../code/zt.json');
		//$("#zyly").combobox('reload', '../../code/zy.json');
		//combobox('zt', '../../code/zt.json');
		//combobox('zyly', '../../code/zy.json');
		$('#xb').combobox({    
		    url:'../../code/xb.json',    
		    valueField:'id',    
		    textField:'text'   
		});  
/* 		$('#zt').combobox({    
		    url:'../../code/zt.json',    
		    valueField:'id',    
		    textField:'text'   
		});   */
		$('#zyly').combobox({    
		    url:'../../code/zy.json',    
		    valueField:'id',    
		    textField:'text'   
		});  
		
	});

	

	function submitAddExpert() {
		
		$("#Expert_add").form('submit',{
			url : '../expert/Expert_add.action',
			onSubmit : function() {
				return $(this).form("validate");
			},
			success : function(data) {
				
				if($.trim($(data).find('span').text())!="添加成功"&&$.trim($(data).find('span').text())!="用户名已存在"){
		 			$.messager.alert("提示信息","添加失败！","info");
		 		}else{$.messager.alert("提示信息",$(data).find('span').text(),"info");
		 		}
			 	parent.reloadTableAfterUpdateOrAdd();
			}
		});
	};

	function clearForm() {
		$("#Expert_add").form('clear');
	};
</script>
</head>
<body>
	<div class="easyui-panel">

		<form id="Expert_add" action="" method="post"
			enctype="multipart/form-data">
			<div style="padding: 10px 0 10px 1px;">

				<table id="main_table">
					<tr>
						<td><label for="username">身份证号</label>
						</td>
						<td><input id="username" maxlength="20" name="obj.Username"
							missingMessage="请输入有效身份证号" invalidMessage="身份证号应为18位"
							class='easyui-validatebox' required="true"
							validtype="length[18,18]" type="text" />
						</td>
						<td><label for="xm">姓名</label>
						</td>
						<td><input id="xm" maxlength="50" name="obj.xm"
							missingMessage="请输入姓名" class='easyui-validatebox' required="true" />
						</td>
						

						<td  rowspan="4"><img id="img_prev" width="150" height="150" src="../../images/stuphoto.png"/>
						</td> 

					</tr>
					<tr>
						<td><label for="xb">性别</label>
						</td>
						<!-- <td><select id="college" name="obj.college" onchange="collegeChange()">	</select></td> -->
						<td><input id="xb" maxlength="20" name="obj.xb"
							class="easyui-combobox" required="true" />
						</td>
						<td><label for="zc">职称</label>
						</td>
						<!-- <td><select id="major" name="obj.major"><option value="">-----请先选择学院----</option></select></td> -->
						<td><input id="zc" maxlength="20" name="obj.zc"
							class="easyui-validatebox" required="true" />
						</td>
						
						<!-- <td><input type="file" file" id="file" value="添加图片"
							onchange="preview(this,'preview','imghead');"
							class="fileinput-button" />
						</td> -->

					</tr>
					<tr>
						<td><label for="zw">职务</label>
						</td>
						<td><input id="zw" maxlength="50" name="obj.zw"
							missingMessage="请输入职务" class='easyui-validatebox' required="true"
							type="text" />
						</td>
						<td><label for="zyly">专业领域</label>
						</td>
						<td><input id="zyly" maxlength="50" name="obj.zyly"
							class="easyui-combobox" type="text" required="true" />
						</td>
					</tr>
					<tr>
						<td><label for="yjfx">研究方向</label>
						</td>
						<td><input id="yjfx" maxlength="100" name="obj.yjfx"
							class='easyui-validatebox' required="true" type="text" />
						</td>
						<td><label for="csny">出生年月</label>
						</td>
						<td><input id="csny" maxlength="50" name="obj.csny"
							class='easyui-datebox' type="text" required="true"/ >
						</td>
					</tr>
					<tr>
						<td><label for="ssdw">所属单位</label>
						</td>
						<td><input id="ssdw" maxlength="200" name="obj.ssdw"
							class='easyui-validatebox' required="true" type="text" />
						</td>
						<td><label for="dzyj">电子邮件</label>
						</td>
						<td><input id="dzyj" maxlength="100" name="obj.dzyj"
							validtype="email" class='easyui-validatebox' type="text"
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
						<td><label for="lxdh">联系电话</label>
						</td>
						<td><input id="lxdh" maxlength="50" name="obj.lxdh"
							class='easyui-validatebox' required="true" type="text" />
						</td>


					</tr>

					<tr>


						<td><label for="zjjj">专家简介</label>
						</td>

						<td colspan="3"><textarea id="zjjj" style="width:99%;height:60px;" name="obj.zjjj"
								class='easyui-validatebox' required="true"></textarea>
						</td>
					</tr>
					<tr>
						<td><label for="bz">备注</label>
						</td>

						<td colspan="3"><textarea id="bz" style="width:99%;height:60px;" name="obj.bz" class='easyui-validatebox'
								></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="5" style="text-align: center; padding: 5px"><a
							class="easyui-linkbutton" href="javascript:void(0);"
							onclick="return submitAddExpert();">保&nbsp;&nbsp;存</a> <a
							class="easyui-linkbutton" href="javascript:void(0);"
							onclick="return clearForm();">重&nbsp;&nbsp;置</a>
						</td>
					</tr>
				</table>
			</div>
			<!-- <div style="padding: 10px 0 10px 1px; float: left: 20%">
			<table id="table">
			      <tr> <td><img id="imghead" width="150" height="150" src="../../images/stuphoto.png"/>
						</td> </tr>
						<tr>
						
						<td>
						<span class="fileinput-button">
						<button type="button">上传照片</button>
						<input type="file" name="file" id="file"
						 onchange="preview(this,'imghead');" />
						 </span>
						 </td>
					</tr>
			</table>
			</div> -->
			
		</form>



	</div>
	

</body>
</html>