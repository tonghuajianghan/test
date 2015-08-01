/*------------------------------------------------------------------------- 
 * 版权所有：姜晗
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com
 * 创建时间：2015-4-9 下午02:20:23 
 * 版本号：v1.0 
 * 本类主要用途描述： 根据像素值删除图片,多线程
 * 
-------------------------------------------------------------------------*/
package cust.jh.thread;

import java.io.File;

import cust.jh.imagedeal.DeleteImgByPixel;

public class DeleteImgByPixelThread extends Thread{
	//private File file;
	private String fileName;
	private int inlength;

	public DeleteImgByPixelThread(String fileName,int inlength) {
		//this.file = file;
		this.fileName = fileName;
		this.inlength = inlength;
	}

	public void run() {
		DeleteImgByPixel deleteImgByPixel = new DeleteImgByPixel();
		deleteImgByPixel.getPixel(fileName,inlength);
	}
}
