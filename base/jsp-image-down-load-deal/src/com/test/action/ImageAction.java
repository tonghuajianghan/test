package com.test.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ImageAction extends ActionBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8322484219426712236L;
	
	@SuppressWarnings("deprecation")
	public String execute() throws Exception,IOException{
		
	    DiskFileItemFactory factory = new DiskFileItemFactory();//初始化上
        String path = request.getRealPath("/upload/hh");
        System.out.print(path);
        factory.setRepository(new File(path));
        //设置上传工厂的限制
        factory.setSizeThreshold(1024 * 1024);
        //设置一个上传的ServletFileUPload对象
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            //处理HTTP请求，item是所有的表单项
            List<FileItem> list = upload.parseRequest(request);
            //遍历所有的表单项
            for (FileItem item : list) {
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    
                    System.out.println("----name="+name);
                    
                    String value = item.getString("gbk");
                    
                    request.setAttribute(name, value);
                } else {
                    //取得文件域的表单域名
                    String name = item.getFieldName();
                    //取得文件名（各浏览器所取值不同，所以下面要进行相应的处理）
                    String value = item.getName();

                    int start = value.lastIndexOf("\\");

                    String filename = value.substring(start + 1);
                    request.setAttribute(name, filename) ;
                    item.write(new File(path,filename));
                    
//                    OutputStream os = new FileOutputStream(new File(path,
//                            filename));
//
//                    InputStream is = item.getInputStream();
//
//                    byte[] buffer = new byte[400];
//
//                    int length = 0;
//
//                    while ((length = is.read(buffer)) > 0) {
//                        os.write(buffer, 0, length);
//                    }
//                    os.close();
//                    is.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("upload/result.jsp").forward(request,
                response);
    
		return "success";
	}

}
