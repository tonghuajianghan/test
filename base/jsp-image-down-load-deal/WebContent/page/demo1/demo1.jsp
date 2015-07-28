<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.servlet.*"%>
<%@ page import="org.apache.commons.fileupload.disk.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
    boolean isMultipart = ServletFileUpload.isMultipartContent(request);//������������Ƿ�Ϊmultipart�����ݡ�
    if (isMultipart == true) {
       FileItemFactory factory = new DiskFileItemFactory();//Ϊ�����󴴽�һ��DiskFileItemFactory����ͨ��������������ִ�н��������еı���Ŀ��������һ��List�С�
       ServletFileUpload upload = new ServletFileUpload(factory);
       List<FileItem> items = upload.parseRequest(request);
       Iterator<FileItem> itr = items.iterator();
       while (itr.hasNext()) {
           FileItem item = (FileItem) itr.next();
           //��鵱ǰ��Ŀ����ͨ����Ŀ�����ϴ��ļ���
           if (item.isFormField()) {//�������ͨ����Ŀ����ʾ�����ݡ�
               String fieldName = item.getFieldName();
               if (fieldName.equals("name")) //��Ӧdemo1.html��type="text" name="name"
                  out.print("the field name is: " + item.getString());//��ʾ�����ݡ�
                  out.print("<br>");
               } else {//������ϴ��ļ�����ʾ�ļ�����
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