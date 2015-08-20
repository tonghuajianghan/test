<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div>
	<form name="userForm" id="userForm" method="post">
		<input type="hidden" id="valid" name="valid" value="${empty pssUser.valid ? YES_VALUE : pssUser.valid}" />
		<div class="col-1">用户名：</div>
		<div class="col-2">
			<c:choose>
				<c:when test="${empty pssUser.userId}">
					<input type="text" name="userName" id="userName" />
				</c:when>
				<c:otherwise>
					${fn:trim(pssUser.userName)}
				</c:otherwise>
			</c:choose>
		</div>
		<div class="col-1">用户类型：</div>
		<div class="col-2">
			<select name="userType" id="userType">
				<option value="">请选择用户类型</option>
				<c:forEach var="dic" items="${dicUserType}">
					<c:if test="${dic.key ne USER_TYPE_SYS}">
						<option value="${dic.key}" ${pssUser.userType eq dic.key ? 'selected' : ''}>${dic.value}</option>
					</c:if>
				</c:forEach>
			</select>
		</div>
		<div class="col-1">初始密码：</div>
		<div class="col-2">
			<input type="text" name="initPwd" id="initPwd" value="${empty pssUser.initPwd ? '111111' : fn:trim(pssUser.initPwd)}" />
		</div>
		<div class="col-1">昵称：</div>
		<div class="col-2">
			<input type="text" name="nickName" id="nickName" value="${empty pssUser.nickName ?'': fn:trim(pssUser.nickName)}"/>
		</div>
		<div class="col-1">邮箱：</div>
		<div class="col-2">
			<input type="text" name="email" id="email" value="${empty pssUser.email ? '':fn:trim(pssUser.email)}"/>
		</div>
		<div class="col-1">联系电话：</div>
		<div class="col-2">
			<input type="text" name="tel" id="tel" value="${empty pssUser.tel ? '':fn:trim(pssUser.tel)}"/>
		</div>
		<div class="col-1">关联产品：</div>
		<div class="col-2">
			<c:forEach var="proDic" items="${dicProd}">
				<input type="checkbox" name="prodId" value="${proDic.key}"/>${proDic.value}
			</c:forEach>
		</div>
	</form>
</div>

<div>
	<input type="button" value="确定" onclick="saveUser()" />
	<input type="button" value="取消" onclick="parent.dialogIframeClose('dialog-iframe-user', true);" />
</div>

<script type="text/javascript">
	$(function() {
		// 初始化关联产品勾选
		<c:forEach var="mp" items="${pssUser.mpUserProdSet}">
			$("[name=prodId][value=${mp.prodId}]").attr("checked", "checked");
		</c:forEach>
		
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

		// 页面校验
		$("#userForm").validate({
			// 提交时不自动校验
			onsubmit: false,
			// 设置校验规则
			rules: {
				"userName": {
					required: true,
					remote: {
						url: "user/verify_dup",
						type: "post",
						dataType: "json",
						data: {
							userName: function(){
								return encodeURIComponent($("#userName").val());
							}
						}
					}
				},
				"userType": "required",
				"nickName":"required",
				"email":{
					required: true,
					checkEmail:true
				},
				"tel":{
					required: true,
					checkTel:true				
				}
			},
	   		// 设置校验信息
	   		messages: {
	   			"userName": {
	   				required: validateMessage("用户名", "input"),
	   				remote: "当前用户名已存在，请重新输入！"
	   			},
	   			"userType": {
	   				required: validateMessage("用户类型", "select")
	   			},
	   			"nickName":{
	   				required: validateMessage("用户昵称", "input")
	   			},
	   			"email":{
	   				required: validateMessage("用户邮箱", "input")
	   			},
	   			"tel":{
	   				required: validateMessage("联系电话", "input"),
	   				number: "联系电话必须为数字！"
	   			}
	   		},
			// 设置校验信息显示形式
			showErrors: function(errorMap, errorList) {
				// 执行默认操作
				this.defaultShowErrors();

				// 自定义校验信息显示形式
				_showErrors(errorMap, errorList, {
					type: "label",
					form: this.currentForm,
					settings: this.settings
				});
			},
			// 设置有出错信息时的操作
			invalidHandler: function(e, validator) {
				// 自定义出错反馈
				_invalidHandler(e, validator);
	   		}
		});
	});
	
	// 保存用户信息
	function saveUser() {
		// 校验页面录入内容
		if($("#userForm").validate().form()) {		
			// 拼接用户对象
			var user = new Object();
			user.userType = $("#userType").val();
			user.initPwd = $("#initPwd").val();
			user.userPwd = hex_md5($("#initPwd").val());
			user.nickName = $("#nickName").val();
			user.email = $("#email").val();
			user.tel = $("#tel").val();
			user.valid = $("#valid").val();
			
			var arr = new Array();
			$("input[name='prodId']:checked").each(function(i) {
				var obj = new Object();
				obj.prodId = $(this).val();
				arr.push(obj);
			});
			
			user.mpUserProdSet = arr;
			
			// 新增用户不设置用户ID
			if(${not empty pssUser.userId}) {
				user.userId = "${pssUser.userId}";
			}
			
			// 编辑用户信息时不能修改用户名
			if($("#userName").size() != 0) {
				user.userName = $("#userName").val();
			}

			dialogMessage("${empty pssUser.userId ?'确定要保存新用户！':'确定要更新用户信息！'}",function(content) {			
				content.dialog("destroy").remove();
				ajaxCommon({
					url: "user/save",
					contentType: "application/json",
					data: JSON.stringify(user)
				}, function(message) {
					if(message == "") {
						// 返回信息为空，表示保存成功，弹出提示信息
						dialogMessage("用户保存成功！",function(content) {
							// 关闭提示窗口
							content.dialog("destroy").remove();
							//刷新父列表
							parent.list();
							parent.dialogIframeClose('dialog-iframe-user', false);
						});
					} else {
						// 返回信息不为空，则表示保存失败，弹出失败信息
						dialogMessage(message);
					}
				});
				
			},true);
		}
	}
</script>