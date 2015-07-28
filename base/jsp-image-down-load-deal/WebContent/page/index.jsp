<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

</head>
<body>
  <a href="<%=basePath %>image.action">image</a>
  <form name="form" action="<%=basePath %>image.action" method="post" enctype="multipart/form-data">
    
        username:<input type="text" name="username" /><br>
        
        password:<input type="password" name="password" /><br>
        
        file1:<input type="file" name="file1" /><br>
        
        file2:<input type="file" name="file2" /><br>
        
        <input type="submit" name="submit" value=" submit " />
        
</form>
</body>
</html>