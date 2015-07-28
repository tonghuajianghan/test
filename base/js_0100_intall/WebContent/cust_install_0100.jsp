<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<!-- 这是引用jquery -->
<script  src="jquery-1.8.2.js" type="text/javascript"></script>

</head>
<body >
  <p>这是一个简单的小程序，测试js能否运行</p>
  <input id="ibutton" type="button" value="提交" onclick="cc()" />
</body>
<script type="text/javascript">
  $('#ibutton').click(function(){
	  alert('成功');
  })
  
  function cc(){
	  alert('也成功');
  }
	
  
</script>

</html>