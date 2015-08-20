<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_rt" prefix="c"%>

<dl class="banner">
	<dd class="back">
		<a href="javascript:" onclick="window.history.go(-1);return false;"></a>
	</dd>
	<dt class="title">账户信息管理</dt>
</dl>

<div class="ct-l">
	<form id="passportForm" method="post">
		<input type="hidden" name="user.userId" value="${pssUser.userId}" />
		<table cellspacing="0" cellpadding="0" class="info">
			<col width="100px" /><col />
			<tr rel="info">
				<td>昵称：</td>
				<td>
					<label>${pssUser.nickName}</label> 
					<input class="input" name="user.nickName" value="${pssUser.nickName}" />
				</td>
			</tr>
			<tr rel="info">
				<td>电子邮箱：</td>
				<td>
					<label>${pssUser.email}</label> 
					<input class="input" name="user.email" value="${pssUser.email}" />
				</td>
			</tr>
			<tr rel="info">
				<td>联系电话：</td>
				<td>
					<label>${pssUser.tel}</label> 
					<input class="input" name="user.tel" value="${pssUser.tel}" />
				</td>
			</tr>
			<tr rel="pwd">
				<td>旧密码：</td>
				<td>
					<input type="password" name="user.prevPwd" class="input" />
				</td>
			</tr>
			<tr rel="pwd">
				<td>新密码：</td>
				<td>
					<input type="password" name="user.userPwd" class="input" />
				</td>
			</tr>
			<tr rel="pwd">
				<td>新密码确认：</td>
				<td>
					<input type="password" name="confirmPwd" class="input" />
				</td>
			</tr>
		</table>
	</form>
	
	<div class="btn-bar">
		<input type="button" class="btn-01" name="btn-edit" value="修改信息" onclick="toggleDisp('info');" />
		<input type="button" class="btn-01" name="btn-edit" value="修改密码" onclick="toggleDisp('pwd');" />
		<input type="button" class="btn-01" id="btn-save" value="保存" onclick="save()" />
		<input type="button" class="btn-01" id="btn-cancel" value="取消" onclick="toggleDisp('cancel');" />
	</div>
</div>

<div class="ct-r">
	<dl class="clearfix">
		<dt>用户类型：</dt>
		<dd>${dicUserType[user.userType]}</dd>
	</dl>
	<dl class="clearfix">
		<dt>管理的产品：</dt>
		<c:forEach var="prodId" items="${user.prodIdList}">
			<dd>${dicProd[prodId]}</dd>
		</c:forEach>
	</dl>
	<dl class="clearfix">
		<dt>状态：</dt>
		<dd>${pssUser.valid eq YES_VALUE ? "正常" : "禁用"}</dd>
	</dl>
</div>

<script type="text/javascript">
	// 切换密码修改相关信息显示
	function togglePwd(opt) {
		toggleTR("tr[rel=pwd]", opt);
		
		// 隐藏密码修改相关信息时，清空密码修改相关输入框
		if(opt == "hide") {
			$("tr[rel=pwd]").find(":input").val("");
		}
	}

	// 切换页面相关信息显示
	function toggleDisp(opt) {
		// 清空校验标签
		$("#passportForm").validate().resetForm();

		// 根据选项切换页面相关信息显示
		switch(opt) {
			case "info":
				// 隐藏密码修改相关信息
				togglePwd("hide");
				// 设置个人信息可编辑
				var infoTR = $("tr[rel=info]");
				infoTR.find("label").hide();
				infoTR.find("input").show();
				// 隐藏信息修改按钮，显示保存或取消按钮
				$("[name='btn-edit']").hide();
				$("#btn-save, #btn-cancel").show();
				break;
			case "pwd":
				// 显示密码修改相关信息
				togglePwd("show");
				// 设置个人信息不可编辑
				var infoTR = $("tr[rel=info]");
				infoTR.find("label").show();
				infoTR.find("input").hide();
				// 隐藏信息修改按钮，显示保存或取消按钮
				$("[name='btn-edit']").hide();
				$("#btn-save, #btn-cancel").show();
				break;
			case "cancel":
				// 隐藏密码修改相关信息
				togglePwd("hide");
				// 设置个人信息不可编辑，并重置个人信息
				var infoTR = $("tr[rel=info]");
				infoTR.find("label").show();
				infoTR.find("input").hide().each(function() {
					$(this).val($.trim($(this).prev("label").text()));
				});
				// 显示信息修改按钮，隐藏保存或取消按钮
				$("[name='btn-edit']").show();
				$("#btn-save, #btn-cancel").hide();
				break;
			default:
				// 隐藏密码修改相关信息
				togglePwd("hide");
				// 设置个人信息不可编辑
				var infoTR = $("tr[rel=info]");
				infoTR.find("label").show();
				infoTR.find("input").hide();
				// 显示信息修改按钮，隐藏保存或取消按钮
				$("[name='btn-edit']").show();
				$("#btn-save, #btn-cancel").hide();
				break;
		}
	}
	
	// 保存用户信息
	function save() {
		// 校验表单
		if(!$("#passportForm").validate().form()) {
			return false;
		}
		
		// 定义用户对象
		var user = new Object();
		
		// 循环表单用户信息相关内容，组装用户对象
		$("#passportForm").find(":input[name^='user.']").each(function() {
			eval(this.name + "='" + this.value + "'");
		});
		
		// 如果当前为修改密码操作，则加密新旧密码
		// 否则不需要更新密码
		if($("tr[rel=pwd]").is(":visible")) {
			user.prevPwd = hex_md5(user.prevPwd);
			user.userPwd = hex_md5(user.userPwd);
		} else {
			user.userPwd = undefined;
		}
		
		// 保存用户信息
		ajaxCommon({
			url: "passport/profile_update",
			contentType: "application/json",
			data: JSON.stringify(user)
		}, function(msg) {
			if (msg != "") {
				alert(msg);
			} else {
				window.location = "${base}passport/center";
			}
		});
	}
	
	$(function() {
		// 密码校验规则
		jQuery.validator.addMethod("checkPwd", function(value, element) {
			var letter =  /^.*[a-zA-Z]+.*$/;
			var notLetter = /^.*[^a-z^A-Z]+.*$/;
			return this.optional(element) || (letter.test(value) && notLetter.test(value));
		}, "密码不符合规则，至少包含一个字母和一个非字母！");
		// 邮箱校验规则
		jQuery.validator.addMethod("checkEmail", function(value, element) {
			var isEmail = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+.[a-zA-Z0-9_-]+$/;
			return this.optional(element) || isEmail.test(value);
		}, "邮箱格式不正确！");
		// 电话校验规则
		jQuery.validator.addMethod("checkTel", function(value, element) {
			var isTel = /^(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;
			return this.optional(element) || isTel.test(value);
		}, "电话格式不正确！");
		
		// 定义表单校验
		$("#passportForm").validate({
			// 提交时不自动校验
			onsubmit: false,
			// 忽略隐藏元素
			ignore: ":hidden",
			// 设置校检规则
			rules:{
				"user.nickName": "required",
				"user.email": {
					required: true,
					checkEmail: true
				},
				"user.tel": {
					required: true,
					checkTel: true
				},
				"user.prevPwd": "required",
				"user.userPwd": {
					required: true,
					minlength: 8,
					checkPwd: true
				},
				"confirmPwd": {
					required: true,
					minlength: 8,
					checkPwd: true
				}
			},
			// 设置校检信息
			messages:{
				"user.nickName": validateMessage("用户昵称", "input"),
				"user.email": {
					required:validateMessage("用户邮箱", "input")
				},
				"user.tel": validateMessage("联系电话", "input"),
				"user.prevPwd": {
					required: validateMessage("旧密码", "input")
				},
				"user.userPwd": {
					required: validateMessage("新密码", "input"),
					minlength: validateMessage(["新密码", "8"], "minlength")
				},
				"confirmPwd": {
					required: validateMessage("确认新密码", "input"),
					minlength: validateMessage(["确认新密码", "8"], "minlength")
				}
			},
			// 设置校验信息显示形式
			showErrors : function(errorMap, errorList) {
				// 执行默认操作
				this.defaultShowErrors();
	
				// 自定义校验信息显示形式
				_showErrors(errorMap, errorList,{
					type: "label",
					form: this.currentForm,
					settings: this.settings
				});
			},
			// 设置有出错信息时的操作
			invalidHandler : function(e, validator) {
				// 自定义出错反馈
				_invalidHandler(e, validator);
			}
		});
		
		// 初始化页面相关信息显示
		toggleDisp();
	});
</script>
