/*------------------------------------------------------------------------- 
* 版权所有：姜晗
* 作者：姜晗
* 联系方式：tonghuajianghan@gmail.com
* 创建时间：2015-4-7 下午09:32:21 
* 版本号：v1.0 
* 本类主要用途描述： 
* 
-------------------------------------------------------------------------*/
package cust.jh.thread;

import cust.jh.imagedeal.HtmlToImageAll;


/** 
* @ClassName: GetHtmlPictureThread 
* @Description: TODO HtmlToImageAll类 的getHtmlPicture方法，多线程
* @author jh 
* @date 2015-4-8 上午08:24:11 
*  
*/
public class GetHtmlPictureThread extends Thread{
	private String url = null;
	private String imgPath = null;
	
	public GetHtmlPictureThread(String url, String imgPath) {
		this.url = url;
		this.imgPath = imgPath;
	}
	
	public void run() {
		HtmlToImageAll htmlToImageAll = new HtmlToImageAll();
		htmlToImageAll.getHtmlPicture(url, imgPath);
	}
}
