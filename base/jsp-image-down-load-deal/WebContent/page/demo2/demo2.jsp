<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.servlet.*"%>
<%@ page import="org.apache.commons.fileupload.disk.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%String uploadPath="D:\\temp";
  System.out.println("mark1");
  boolean isMultipart = ServletFileUpload.isMultipartContent(request);
  if(isMultipart==true){
      try{
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItemStream> items = upload.parseRequest(request);//得到所有的文件
       Iterator<FileItemStream> itr = items.iterator();
       System.out.println("mark2");
       System.out.println(itr.hasNext());
       System.out.println(request);
        while(itr.hasNext()){//依次处理每个文件
        	
         FileItem item=(FileItem)itr.next();       
         String fileName=item.getName();//获得文件名，包括路径
         System.out.println("item" + item.getName());    //上传的完整路径     
         if(fileName!=null){
        	 File fullFile=new File(item.getName());
        	 System.out.println("fullFile" + fullFile.getName());//文件名
             File savedFile=new File(uploadPath,fullFile.getName());
             item.write(savedFile);//将FileItem中的文件保存到指定文件下
         }
        }
        out.print("upload succeed");
      }
      catch(Exception e){
         e.printStackTrace();
      }
  }
  else{
      out.println("the enctype must be multipart/form-data");
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