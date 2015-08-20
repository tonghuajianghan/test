<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<form id="userForm" action="${base}user/list" method="post">
	<dl class="banner">
		<dd class="back"><a href="javascript:" onclick="window.history.go(-1);return false;"></a></dd>
		<dt class="title">用户列表</dt>
		<dd class="search"><a href="javascript:" onclick="$('#userForm').submit();return false;"></a></dd>
		<dd class="cond">
			<select name="user.userType">
				<option value="">全部用户类型</option>
				<c:forEach var="dic" items="${dicUserType}">
					<c:if test='${dic.key ne USER_TYPE_SYS}'>
						<option value="${dic.key}" ${condition.user.userType eq dic.key ? 'selected' : ''}>${dic.value}</option>
					</c:if>
				</c:forEach>
			</select>
		</dd>
		<dt class="cond">用户类型</dt>
		<dd class="cond"><input type="text" name="user.userName" value="${condition.user.userName}" /></dd>
		<dt class="cond">用户名</dt>
	</dl>
	<input type="hidden" id="pageNo" name="pageNo" value="${condition.pageNo}" />
</form>

<div class="op">
	<a href="javascript:" onclick="editUser();return false;" class="add">新增</a>
	<a href="javascript:" onclick="batchDelete();return false;" class="del">删除</a>
	<a href="javascript:" onclick="batchValid('${NO_VALUE}');return false;" class="off">禁用</a>
	<a href="javascript:" onclick="batchValid('${YES_VALUE}');return false;" class="on">激活</a>
	<a href="javascript:" onclick="batchResetPwd();return false;" class="pwd">重置密码</a>
</div>

<table cellspace="0" cellpadding="0" class="list">
	<col width="39px" /><col width="230px" /><col width="230px" /><col width="150px" /><col width="150px" /><col />
	<tr>
		<th class="center"><input id="checkAll" type="checkbox" class="checkbox" /></th>
		<th class="center">用户名</th>
		<th class="center">用户昵称</th>
		<th class="center">用户类型</th>
		<th class="center">用户状态</th>
		<th class="center">操作</th>
	</tr>
	
	<c:if test="${empty page.result}">
		<tr>
			<th class="center" colspan="6">未能找到符合条件的结果！</th>			
		</tr>
	</c:if>
	
	<c:forEach var="item" items="${page.result}">
		<tr>
			<td class="center"><input type="checkbox" name="userId" value="${item.userId}" class="checkbox" /></td>
			<td class="center"><a href="javascript:" onclick="editUser('${item.userId}');return false;">${item.userName}</a></td>
			<td class="center">${item.nickName}</td>
			<td class="center">${dicUserType[item.userType]}</td>
			<td class="center">${YES_VALUE eq item.valid ? "正常" : "禁用"}</td>
			<td class="center">
				<a href="javascript:" onclick="setValid('${item.userId}', '${item.valid eq YES_VALUE ? NO_VALUE : YES_VALUE}');return false;">${YES_VALUE eq item.valid ? "禁用" : "激活"}</a>			
				<a href="javascript:" onclick="delUser('${item.userId}','${item.userType}');return false;">删除</a>
				<a href="javascript:" onclick="resetUser('${item.userId}');return false;">重置密码</a>
			</td>
		</tr>
	</c:forEach>
	
	<tr>
		<td colspan="6" class="page-container" />
	</tr>
</table>
		
<script type="text/javascript">
	$(document).ready(function() {
		//加入分页的绑定 
		paging.form.init({
			container: ".page-container",
			numb: "#pageNo",
			page: "${page.pageCount}",
			total: "${page.count}",
			form: "#userForm"
		});
	});
	
	// 删除用户信息
	function delUser(userId) {
		dialogMessage("确定要删除该用户！", function(content) {
			content.dialog("destroy").remove();
			ajaxCommon({
				url: "user/del",
				data: {
					id: userId
				}
			}, function(message) {
				if(message == "") {
					// 返回信息为空，表示删除成功，弹出提示信息
					dialogMessage("用户删除成功！", function(content) {
						// 刷新用户列表
						$('#userForm').submit();
						// 关闭提示窗口
						content.dialog("destroy").remove();
					});
				} else {
					// 返回信息不为空，则表示保存失败，弹出失败信息
					dialogMessage(message);
				}
			}); 
		}, true);	
	}
	
	// 密码重置功能
	function resetUser(userId) {
		dialogMessage("确定要重置该用户密码吗?", function(content) {
			content.dialog("destroy").remove();
			ajaxCommon({
				url: "user/reset_pwd",
				data: {
					id: userId
				}
			},function(message) {
				if(message == "") {
					// 返回信息为空，表示密码重置成功，弹出提示信息
					dialogMessage("重置密码成功！",function(content) {
						// 刷新用户列表
						$("#userForm").submit();
						// 关闭提示窗口
						content.dialog("destroy").remove();
					});
				} else {
					// 返回信息不为空，则表示保存失败，弹出失败信息
					dialogMessage(message);
				}
			});
		}, true);
	}
	
	// 编辑用户
	function editUser(userId) {
		// 弹出窗口参数
		var opt = {
			url: "user/edit?id="+userId,
			width: 400,
			height: 500,
			title: "编辑用户",
			id: "dialog-iframe-user",
			buttons : null
		};
		// 弹出窗口
		dialogIframe(opt);
	}
	
	// 刷新用户列表
	function list(){
		$('#userForm').submit();
	}
	
	// 设置用户有效性
	function setValid(userId, valid) {
		var label = (valid == "${YES_VALUE}" ? "激活" : "禁用");
		dialogMessage("确定要" + label + "该用户吗?", function(content) {
			content.dialog("destroy").remove();
			ajaxCommon({
				url:"user/valid_ctrl",
				data: {
					id: userId,
					valid: valid
				}
			},function(message) {
				if(message == "") {
					// 刷新用户列表
					$("#userForm").submit();
					// 返回信息为空，表示用户有效性设置成功，弹出提示信息
					dialogMessage("用户" + label + "成功！");
				} else {
					// 返回信息不为空，则表示用户有效性设置失败，弹出失败信息
					dialogMessage(message);
				}
			});
		}, true);
	}
	
	// 批量删除选中用户
	function batchDelete() {
		var ids = new Array();
		// 将选中用户的id放入字符串userIdStr中
		$("input[name='userId']:checked").each(function(i){
			ids.push($(this).val());
		});

		// 没有选中数据的话给出提示
		if(ids.length == 0){
			dialogMessage("请至少选择一条记录！");
		} else {
			dialogMessage("确定要批量删除用户！", function(content) {
				content.dialog("destroy").remove();
				ajaxCommon({
					url: "user/batch/delete",
					contentType: "application/json",
					data: JSON.stringify(ids)
				},function(message) {
					if(message == "") {
						// 返回信息为空，表示批量删除成功，弹出提示信息
						dialogMessage("批量删除用户成功！", function(content) {
							// 刷新用户列表
							$("#userForm").submit();
							// 关闭提示窗口
							content.dialog("destroy").remove();
						});
					} else {
						// 返回信息不为空，则表示批量删除失败，弹出失败信息
						dialogMessage(message);
					}
				});
			}, true);
		}
	}
	
	// 当前页面用户全选、全不选
	$("#checkAll").click(function() {
		 $("[name='userId']").attr("checked", this.checked);
	});
	
	// 批量设置用户有效性
	function batchValid(valid) {
		var label = valid == "${YES_VALUE}" ? "激活" : "禁用";
		
		var ids = new Array();
		// 将选中用户的id放入字符串userIdStr中
		$("input[name='userId']:checked").each(function() {
			ids.push($(this).val());
		});
		
		// 没有选中数据的话给出提示
		if(ids.length == 0){
			dialogMessage("请至少选择一条记录！");
		} else {
			dialogMessage("确定要批量" + label + "选中的用户吗？", function(content) {
				content.dialog("destroy").remove();
				ajaxCommon({
					url: "user/batch/valid?valid=" + valid,
					contentType: "application/json",
					data: JSON.stringify(ids)
				},function(message) {
					if(message == "") {
						// 返回信息为空，表示用户批量禁用成功，弹出提示信息
						dialogMessage("批量" + label + "用户成功！", function(content) {
							// 刷新用户列表
							$("#userForm").submit();
							// 关闭提示窗口
							content.dialog("destroy").remove();
						});
					} else {
						// 返回信息不为空，则表示用户批量禁用失败，弹出失败信息
						dialogMessage(message);
					}
				});
			}, true); 
		} 
	}
	
	// 批量重置密码
	function batchResetPwd() {
		var ids = new Array();
		//将选中用户的id放入数组ids中
		$("input[name='userId']:checked").each(function(){
			ids.push($(this).val());
		});

		//没有选中数据的话给出提示
		if(ids.length == 0){
			dialogMessage("请至少选择一条记录！");
		} else {
			dialogMessage("确定要批量重置密码吗？", function(content) {
				content.dialog("destroy").remove();
				ajaxCommon({
					url:"user/batch/reset_pwd",
					contentType: "application/json",
					data: JSON.stringify(ids)
				},function(message) {
					if(message == "") {
						// 返回信息为空，表示批量重置密码成功，弹出提示信息
						dialogMessage("批量重置密码成功！", function(content) {
							// 刷新当前页面
							$("#userForm").submit();
							// 关闭提示窗口
							content.dialog("destroy").remove();
						});
					} else {
						// 返回信息不为空，则表示用户批量重置密码失败，弹出失败信息
						dialogMessage(message);
					}
				});
			}, true); 
		} 
	}
</script>