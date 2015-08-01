/*------------------------------------------------------------------------- 
* 版权所有：姜晗
* 作者：姜晗
* 联系方式：tonghuajianghan@gmail.com
* 创建时间：2015-4-30 下午06:44:50 
* 版本号：v1.0 
* 本类主要用途描述： 
* 
-------------------------------------------------------------------------*/
package cust.jh.thread;

import cust.jh.controller.ControlHTMLToImage;

public class ControlHtmlToImageThread extends Thread{
	private String filePath;
	private String fileImgPath;

	public ControlHtmlToImageThread(String filePath, String fileImgPath) {
		//this.file = file;
		this.filePath = filePath;
		this.fileImgPath = fileImgPath;
	}

	public void run() {
		ControlHTMLToImage controlHTMLToImage = new ControlHTMLToImage();
		controlHTMLToImage.getControlImage(filePath,fileImgPath);
	}
}
