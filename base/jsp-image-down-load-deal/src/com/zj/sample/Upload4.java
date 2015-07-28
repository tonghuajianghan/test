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
		String tempPath = "d:\\temp\\buffer\\"; // 临时文件目录

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
				factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb
				factory.setRepository(tempPathFile);// 设置缓冲区目录

				ServletFileUpload upload = new ServletFileUpload(factory);

				// Set overall request size constraint
				upload.setSizeMax(4194304); // 设置最大文件尺寸，这里是4MB

				List<FileItemStream> items = upload.parseRequest(request);// 得到所有的文件
				upload.setHeaderEncoding("UTF-8");
				Iterator<FileItemStream> itr = items.iterator();// 迭代文件
				while (itr.hasNext()) {// 依次处理每个文件

					FileItem item = (FileItem) itr.next();
					if (item.isFormField()) {// 如果是普通表单项目，显示表单内容。
						String fieldName = item.getFieldName();
						if (fieldName.equals("myname")) {// 对应demo1.html中type="text"
															// name="name"
							System.out.println("myname2:"
									+ "the field name is: " + item.getString());
						} else {// 如果是上传文件，显示文件名。
							System.out.println("myname2:"
									+ "the upload file name is: "
									+ item.getName());
						}
					} else {
						String fileName = item.getName();// 获得文件名，包括路径
						if (fileName != null) {
							File fullFile = new File(item.getName());
							// System.out.println("fullFile:" +
							// fullFile.getName());// 文件名
							File savedFile = new File(uploadPath,
									fullFile.getName());
							item.write(savedFile);// 将FileItem中的文件保存到指定文件下
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
