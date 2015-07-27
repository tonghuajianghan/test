package com.zj.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.test.util.MyImage;

public class Upload4 extends ActionBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3424717200834547774L;

	private String myname;

	public void setMyname(String myname) {
		this.myname = myname;
	}

	public String getMyname() {
		return myname;
	}

	public String execute() throws Exception, IOException,
			FileNotFoundException {

		System.out.println(myname);

		String uploadPath = "D:\\temp";
		String tempPath = "d:\\temp\\buffer\\"; // ��ʱ�ļ�Ŀ¼

		File uploadFile = new File(uploadPath);
		if (!uploadFile.exists()) {
			uploadFile.mkdirs();
		}
		File tempPathFile = new File(tempPath);
		if (!tempPathFile.exists()) {
			tempPathFile.mkdirs();
		}

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart == true) {
			try {
				DiskFileItemFactory factory = new DiskFileItemFactory();

				// Set factory constraints
				factory.setSizeThreshold(4096); // ���û�������С��������4kb
				factory.setRepository(tempPathFile);// ���û�����Ŀ¼

				ServletFileUpload upload = new ServletFileUpload(factory);

				// Set overall request size constraint
				upload.setSizeMax(4194304); // ��������ļ��ߴ磬������4MB

				List<FileItemStream> items = upload.parseRequest(request);// �õ����е��ļ�
				upload.setHeaderEncoding("UTF-8");
				Iterator<FileItemStream> itr = items.iterator();// �����ļ�
				while (itr.hasNext()) {// ���δ���ÿ���ļ�

					FileItem item = (FileItem) itr.next();
					if (item.isFormField()) {// �������ͨ����Ŀ����ʾ�����ݡ�
						String fieldName = item.getFieldName();
						if (fieldName.equals("myname")) {// ��Ӧdemo1.html��type="text"
															// name="name"
							System.out.println("myname2:"
									+ "the field name is: " + item.getString());
						} else {// ������ϴ��ļ�����ʾ�ļ�����
							System.out.println("myname2:"
									+ "the upload file name is: "
									+ item.getName());
						}
					} else {
						String fileName = item.getName();// ����ļ���������·��
						if (fileName != null) {
							File fullFile = new File(item.getName());
							// System.out.println("fullFile:" +
							// fullFile.getName());// �ļ���
							File savedFile = new File(uploadPath,
									fullFile.getName());
							item.write(savedFile);// ��FileItem�е��ļ����浽ָ���ļ���
                            MyImage mi = new MyImage();
                            mi.dealImage(savedFile);
						}
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
