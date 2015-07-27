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
				List<FileItemStream> items = upload.parseRequest(request);// �õ����е��ļ�							
				upload.setHeaderEncoding("UTF-8"); 
				Iterator<FileItemStream> itr = items.iterator();//�����ļ�								
				while (itr.hasNext()) {// ���δ���ÿ���ļ�

					FileItem item = (FileItem) itr.next();
					String fileName = item.getName();// ����ļ���������·��
					//System.out.println("item:" + item.getName()); // �ϴ�������·��
					if (fileName != null) {
						File fullFile = new File(item.getName());
						//System.out.println("fullFile:" + fullFile.getName());// �ļ���
						File savedFile = new File(uploadPath,
								fullFile.getName());
						item.write(savedFile);// ��FileItem�е��ļ����浽ָ���ļ���
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