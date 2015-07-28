<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>testArtDialog30</title>

<!-- artdialog不基于js,也可以单独运行 -->
<link id="artDialogSkin" href="../js/artDialog/skin/default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/artDialog/artDialog.js"></script>

</head>
<body>
	<script type="text/javascript">
    function i(){  
        art.dialog(
	         {
	         	content:'请输入：<input style="width:200px;" id="M_dfd" type="text" value="hello world!" />',
	             lock:true,
	             style:'succeed noClose'
	         },
	         function(){
	             alert('你点了确定'); //不管点了确定还是取消默认都会关闭artdialog，除非在这里面返回false
	             var a=document.getElementById('M_dfd').value;
	             document.writeln(a);
	         },
	         function(){
	             alert('你点了取消');
	         }
        );
    }
	</script>	
	<button id="btn7" onClick="i()">弹出菜单</button><br/>	
</body>
</html>