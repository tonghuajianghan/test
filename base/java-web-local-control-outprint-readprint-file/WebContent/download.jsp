<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%@ page import="java.lang.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>download</title>
</head>
<body>
  <p>download</p>
   <%
    response.setContentType("application/x-download");//设置response内容的类型
	response.setHeader("Content-disposition",
			"inline;filename=PatentExport.xls");
	OutputStream outp;
	try {
		outp = response.getOutputStream();	
		OutputStreamWriter os= new   OutputStreamWriter(outp);
		os.write("word", 0, 2);
		outp.flush();
		os.close();
		outp.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
  %> 
</body>
</html>