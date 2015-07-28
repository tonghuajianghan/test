<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.servlet.*"%>
<%@ page import="org.apache.commons.fileupload.disk.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
    boolean isMultipart = ServletFileUpload.isMultipartContent(request);//检查输入请求是否为multipart表单数据。
    if (isMultipart == true) {
       FileItemFactory factory = new DiskFileItemFactory();//为该请求创建一个DiskFileItemFactory对象，通过它来解析请求。执行解析后，所有的表单项目都保存在一个List中。
       ServletFileUpload upload = new ServletFileUpload(factory);
       List<FileItem> items = upload.parseRequest(request);
       Iterator<FileItem> itr = items.iterator();
       while (itr.hasNext()) {
           FileItem item = (FileItem) itr.next();
           //检查当前项目是普通表单项目还是上传文件。
           if (item.isFormField()) {//如果是普通表单项目，显示表单内容。
               String fieldName = item.getFieldName();
               if (fieldName.equals("name")) //对应demo1.html中type="text" name="name"
                  out.print("the field name is: " + item.getString());//显示表单内容。
                  out.print("<br>");
               } else {//如果是上传文件，显示文件名。
                  out.print("the upload file name is: " + item.getName());
                  out.print("<br>");
               }
           }
       } else {
         out.print("the enctype must be multipart/form-data");
       }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>File upload</title>
</head>
<body>
</body>
</html>