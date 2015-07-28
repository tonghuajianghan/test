<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <tr><td>在线人数：<span id="sp"></span></td></tr>
   以下 是我的 js代码
<script language=JavaScript>
function ab(){
 document.getElementById("sp").innerHTML="<%=OnLineUser.getUsers().size() %>";
}

setInterval("ab()",1000);
</script>
   
</body>
</html>