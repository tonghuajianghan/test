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
        List<FileItemStream> items = upload.parseRequest(request);//�õ����е��ļ�
       Iterator<FileItemStream> itr = items.iterator();
       System.out.println("mark2");
       System.out.println(itr.hasNext());
       System.out.println(request);
        while(itr.hasNext()){//���δ���ÿ���ļ�
        	
         FileItem item=(FileItem)itr.next();       
         String fileName=item.getName();//����ļ���������·��
         System.out.println("item" + item.getName());    //�ϴ�������·��     
         if(fileName!=null){
        	 File fullFile=new File(item.getName());
        	 System.out.println("fullFile" + fullFile.getName());//�ļ���
             File savedFile=new File(uploadPath,fullFile.getName());
             item.write(savedFile);//��FileItem�е��ļ����浽ָ���ļ���
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