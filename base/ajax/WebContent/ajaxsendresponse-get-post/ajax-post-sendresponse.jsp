<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>密码</title>
<script type="text/javascript">
	var xmlHttpRequest = null;
	function ajaxCallback() {		
		if (xmlHttpRequest.readyState == 4) {//readyState的四种状态值 
			alert(xmlHttpRequest.status);
			if (xmlHttpRequest.status == 200 || xmlHttpRequest.status == 304) {
				// 获取服务器的值,500内部错误，200连接成功
				document.getElementById("divcheck").innerHTML = xmlHttpRequest.responseText;
			}
		}
	}
	
	function ajaxSubmit() {
		var name = document.getElementById("name").value;
		var ps = document.getElementById("ps").value;
		var cps = document.getElementById("cps").value;
		
		if (window.ActiveXObject) {
			xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) {
			xmlHttpRequest = new XMLHttpRequest();
		}
		if (null != xmlHttpRequest) {
			xmlHttpRequest.onreadystatechange = ajaxCallback;
			xmlHttpRequest.open("POST", "/ajaxresponse", true);
			xmlHttpRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
			xmlHttpRequest.send("name=" + name + "&ps=" + ps + "&cps=" + cps);						
		}
	}
	
</script>
</head>
<body>
	<center>
		<form action="" method="post">
			<table border="2">
				<tr>
					<td>用户名</td>
					<td><input type="text" name="name" value="" id="name" />
					</td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" name="ps" id="ps" value="">
					</td>
				</tr>
				<tr>
					<td>确认密码:</td>
					<td><input type="password" name="cps" id="cps" value="">
					</td>
				</tr>
				<tr>
					<td><input type="button" value="提交" onclick="ajaxSubmit()" />
					</td>
				</tr>
			</table>
			<div id="divcheck"></div>
		</form>
	</center>
</body>
</html>