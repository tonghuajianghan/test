<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>demo4</title>
</head>
<body>
    <h3>实现上传图片于上传数据的结合</h3>
    <form id="mynform" name="myform" action="fileupload4" method="post"
       enctype="multipart/form-data">
        
       Name：<br>
       <input type="text" id="myname" name="myname"><br>      
       File:<br>
       <input id="mynfile2" type="file" name="myfile"><br>
       <br>
       <input id="submit" type="submit" name="submit" value="Commit">
    </form>
</body>
</html>