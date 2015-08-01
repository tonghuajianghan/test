/*------------------------------------------------------------------------- 
 * 版权所有：姜晗
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com
 * 创建时间：2015-4-21 上午09:26:16 
 * 版本号：v1.0 
 * 本类主要用途描述： 处理错误
 * 
-------------------------------------------------------------------------*/
package cust.jh.controller;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cust.jh.GUI.HTMLToImageJFrame;
import cust.jh.filedeal.FileDeal;
import cust.jh.thread.GetHtmlPictureThread;
import cust.jh.thread.HtmlToImageAllThread;
import cust.jh.thread.HtmlToImageThread;

/** 
* @ClassName: ControlError 
* @Description: TODO  处理错误
* @author jh 
* @date 2015-4-24 上午11:15:45 
*  
*/
public class ControlError {
	
	private CountDownLatch threadSignal;

	/** 
	* @Title: getErrorPath 
	* @Author: jianghan
	* @Description: TODO 获取多个错误文件路径
	* @param errorPath
	*    
	*/
	public void getErrorPath(String errorPath) {
		// 获取文件内容
		FileDeal filedeal = new FileDeal();
		String lineTxt = filedeal.txt2String(errorPath);
		List<String> list = filedeal.getUrlByString(lineTxt);
		//filedeal.clearFile(errorPath);
		// 遍历错误网址文件地址
		String errorPathUrl = null;
		String imgPath = null;
		for (int i = 0; i < list.size(); i++) {
			// 获取错误网址文件地址
			errorPathUrl = list.get(i);
			// System.out.println( i + "url:" + errorPathUrl);
			imgPath = errorPathUrl.substring(0, errorPathUrl.length() - 9);
			//System.out.println(i + "url:" + imgPath);
			reloadError(errorPathUrl, imgPath);
		}
	}

	/** 
	* @Title: reloadError 
	* @Author: jianghan
	* @Description: TODO 处理多个文件错误
	* @param filePath
	* @param imgPath
	*    
	*/
	public void reloadError(String filePath, String imgPath) {
		// 获取文件内容
		FileDeal filedeal = new FileDeal();
		String lineTxt = filedeal.txt2String(filePath);
		List<String> list = filedeal.getUrlByString(lineTxt);
		filedeal.clearFile(filePath);
		
		// 遍历url
		String url = null;
		for (int i = 0; i < list.size(); i++) {
			// System.out.println("i:" + i);
			// 获取url
			url = list.get(i);
			//System.out.println(i + "url:" + url);

			GetHtmlPictureThread getHtmlPictureThread3 = new GetHtmlPictureThread(
					url, imgPath);
			getHtmlPictureThread3.start();
		}

	}
	
	
	/** 
	* @Title: getErrorPathUrl 
	* @Author: jianghan
	* @Description: TODO 处理获取全部文件时网络连接等错误
	* @param errorPathUrl1
	*    
	*/
	public CountDownLatch getErrorPathUrl(String errorPathUrl1) {
		// 获取文件内容
		FileDeal filedeal = new FileDeal();
		String lineTxt = filedeal.txt2String(errorPathUrl1);
		List<String> list = filedeal.getUrlByString(lineTxt);
		//filedeal.clearFile(errorPathWhole);
		// 遍历错误网址文件地址
		String errorPathUrl = null;
		for (int i = 0; i < list.size(); i++) {
			// 获取错误网址文件地址
			errorPathUrl = list.get(i);
			//System.out.println(i + "url:" + errorPathUrl);
			reloadErrorUrl(errorPathUrl);
		}
		
		threadSignal.countDown();
		return threadSignal;
	}
	/** 
	* @Title: reloadErrorUrl 
	* @Author: jianghan
	* @Description: TODO 处理获取全部文件时网络连接等错误
	* @param filePath
	*    
	*/
	public void reloadErrorUrl(String filePath) {
		// 获取文件内容
		FileDeal filedeal = new FileDeal();
		String lineTxt = filedeal.txt2String(filePath);
		List<String> list = filedeal.getUrlByString(lineTxt);
		filedeal.clearFile(filePath);
		// 遍历url
		String url = null;
		String imgPathDir = null;
		threadSignal = new CountDownLatch(list.size());// 初始化countDown
		final CyclicBarrier cyclic = new CyclicBarrier(1);
		Lock lock = new ReentrantLock();
		final Condition full = lock.newCondition(); 
		for (int i = 0; i < list.size(); i++) {
			// System.out.println("i:" + i);
			// 获取url
			url = list.get(i);
			//System.out.println("filePath" +filePath);
			imgPathDir = filePath.substring(0, filePath.length() - 12);
			//System.out.println(i + "url:" + url);
			//System.out.println(i + "imgPathDir:" + imgPathDir);
			// 生成整个图片
			// 生成网页中所有图片
			HtmlToImageAllThread htmlToImageAllThread = new HtmlToImageAllThread(
					url, imgPathDir, threadSignal,lock,full);
			htmlToImageAllThread.start();
		}
		if(list.size() == -1){
			//HTMLToImageJFrame.textArea.append("错误处理完成,没有错误\n");
		}
		
	}
	/** 
	* @Title: getErrorPathWhole 
	* @Author: jianghan
	* @Description: TODO 获取整个网站图片路径
	* @param errorPathWhole
	*    
	*/
	public void getErrorPathWhole(String errorPathWhole) {
		// 获取文件内容
		FileDeal filedeal = new FileDeal();
		String lineTxt = filedeal.txt2String(errorPathWhole);
		List<String> list = filedeal.getUrlByString(lineTxt);
		//filedeal.clearFile(errorPathWhole);
		// 遍历错误网址文件地址
		String errorPathUrl = null;
		for (int i = 0; i < list.size(); i++) {
			// 获取错误网址文件地址
			errorPathUrl = list.get(i);
			//System.out.println(i + "url:" + errorPathUrl);
			reloadErrorWhole(errorPathUrl);
		}
		/*//等待所有子线程执行完  
		try {
			threadSignal.await();
			HTMLToImageJFrame.textArea.append("错误处理完成,程序结束\n");
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	}

	/** 
	* @Title: reloadErrorWhole 
	* @Author: jianghan
	* @Description: TODO 处理整个网站图片
	* @param filePath
	*    
	*/
	public void reloadErrorWhole(String filePath) {
		// 获取文件内容
		FileDeal filedeal = new FileDeal();
		String lineTxt = filedeal.txt2String(filePath);
		List<String> list = filedeal.getUrlByString(lineTxt);
		filedeal.clearFile(filePath);
		// 遍历url
		String url = null;
		String imgPath = null;
		String imgPathDir = null;
		threadSignal = new CountDownLatch(list.size());// 初始化countDown
		final CyclicBarrier cyclic = new CyclicBarrier(1);		
		Lock lock = new ReentrantLock();
		final Condition full = lock.newCondition();  
		for (int i = 0; i < list.size(); i++) {
			// System.out.println("i:" + i);
			// 获取url
			url = list.get(i);
			//System.out.println("filePath" +filePath);
			imgPathDir = filePath.substring(0, filePath.length() - 14);
			imgPath = imgPathDir + url.substring(7, url.length()) + ".png";
			//System.out.println(i + "url:" + url);
			//System.out.println(i + "imgPath:" + imgPath);
			// 生成整个图片		
			HtmlToImageThread htmlToImageThread = new HtmlToImageThread(url,
					imgPath, imgPathDir,threadSignal,cyclic,lock,full);
			htmlToImageThread.start();
		}
		if(list.size() == -1){
			HTMLToImageJFrame.textArea.append("错误处理完成,没有错误\n");
		}
		
	}

	/** 
	* @Title: emptyError 
	* @Author: jianghan
	* @Description: TODO 清空错误列表文件
	* @param imgPath
	* @param fileName
	*    
	*/
	/*public void emptyError(String imgPath,String fileName) {

		File rightFile = new File(imgPath, fileName);
		FileWriter rightFileWriter;
		try {
			rightFileWriter = new FileWriter(rightFile);
			rightFileWriter.write("");
			rightFileWriter.close();
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/
}
