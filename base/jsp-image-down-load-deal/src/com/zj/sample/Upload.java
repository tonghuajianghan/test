package com.zj.sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Upload extends ActionBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7050253729619078484L;

	public String execute() throws Exception, IOException ,FileNotFoundException {
		String uploadPath = "D:\\temp";		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart == true) {
			try {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItemStream> items = upload.parseRequest(request);// 得到所有的文件							
				upload.setHeaderEncoding("UTF-8"); 
				Iterator<FileItemStream> itr = items.iterator();//迭代文件								
				while (itr.hasNext()) {// 依次处理每个文件

					FileItem item = (FileItem) itr.next();
					String fileName = item.getName();// 获得文件名，包括路径
					//System.out.println("item:" + item.getName()); // 上传的完整路径
					if (fileName != null) {
						File fullFile = new File(item.getName());
						//System.out.println("fullFile:" + fullFile.getName());// 文件名
						File savedFile = new File(uploadPath,
								fullFile.getName());
						item.write(savedFile);// 将FileItem中的文件保存到指定文件下
					}
				}
				System.out.println("upload succeed");				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("the enctype must be multipart/form-data");			
		}
		return "success";

	}
}