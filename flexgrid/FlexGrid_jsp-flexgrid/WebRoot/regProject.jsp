<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>注册页面</title>
		<meta http-equiv="content-Type" content="text/html; charset=utf-8" />
	</head>

	<body>
	<form  method="post" >
		<table>
			<tr>
				<td>
					<label for="projects">
						姓名：
					</label>
					<input name="username"id="username" type="text" value="" size=24/>
				</td>
			</tr>
	  	<tr>
				<td>
					<label for="projects">
						密码：
					</label>
					<input name="password" id="password" type="text" value="" size=24/>
				</td>
			</tr>
				<tr>
				<td>
					<label for="projects">
						年龄：
					</label>
					<input name="age" id="age" type="text" value="" size=14/><span style="color:red">只能填数字</span>
				</td>
			</tr>
			  <tr>
				<td>
					<label for="projects">
						住址：
					</label>
					<input name="address" id="address" type="text" value="" size=24/>
				</td>
			</tr>
			
			<tr>
				<td align="center">
		<input type="button" value="保存" onclick="savePageName()" />&nbsp;&nbsp;
				</td>
			</tr>
			
			
		</table>
</form>
<script>
// 验证,然后 保存界面
function savePageName()
{
var username=$("#username").val();
var password=$("#password").val();

if(username==""||username==null ) 
{
alert("姓名不能为空!")
$("#username").focus();
  return;
}
if(password==""||password==null ) 
{
alert("密码不能为空!")
$("#password").focus();
  return;
} 

var age =$('#age').val();
var address=$('#address').val();
var sendData="username="+ encodeURIComponent(username)+"&password="+encodeURIComponent(password)+"&age="+encodeURIComponent(age)+"&address="+encodeURIComponent(address)+"&date="+new Date(); 

    		 $.ajax({ 
			url: "add.jsp" ,
			type:'post', //数据发送方式 
			dataType:'html', //接受数据格式 
			data: sendData , 
			// beforeSend: function() {$("<img src='../images/wait18.gif' />").appendTo("#DivTblContact")},  
			success:update_page //回传函数(这里是函数名)   error转向错误页面
            }); 
            
}
    function update_page(obj) { //ajax保存成功后,触发 id为rain 的onclick事件
          window.location.reload();
     } 		 



</script>
	</body>
</html>
