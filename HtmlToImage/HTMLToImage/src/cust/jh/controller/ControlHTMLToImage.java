/*------------------------------------------------------------------------- 
 * 版权所有：姜晗
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com
 * 创建时间：2015-4-5 上午10:30:18 
 * 版本号：v1.0 
 * 本类主要用途描述： 获取图片控制类
 * 
-------------------------------------------------------------------------*/
package cust.jh.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.openqa.selenium.WebDriver;

import cust.jh.GUI.Const;
import cust.jh.GUI.HTMLToImageJFrame;
import cust.jh.GUI.HtmlToImageGUI;
import cust.jh.driver.DriverFactory;
import cust.jh.filedeal.FileDeal;
import cust.jh.filedeal.FileDir;
import cust.jh.imagedeal.HtmlToImageAll;
import cust.jh.thread.HtmlToImageAllThread;
import cust.jh.thread.HtmlToImageThread;

/**
 * @ClassName: ControlHTMLToImage
 * @Description: TODO 获取图片控制类
 * @author jh
 * @date 2015-4-5 上午11:21:31
 * 
 */
public class ControlHTMLToImage {
	/*public static void main(String[] args) {
		ControlHTMLToImage controlHTMLToImage = new ControlHTMLToImage();
		controlHTMLToImage.getControlImage("D:\\2.txt", "D:\\HtmlToImage\\");
	}*/

	/**
	 * @Title: getControlImage
	 * @Author: jianghan
	 * @Description: TODO 获取图片
	 * 
	 */
	public void getControlImage(String filePath, String fileImgPath) {
		// 获取文件内容
		FileDeal filedeal = new FileDeal();
		String lineTxt = filedeal.txt2String(filePath);
		List<String> list = filedeal.getUrlByString(lineTxt);

		// 获取文件夹路径
		FileDir fileDir = new FileDir();

		// 通过url，将整个html生成图片
		String url = null;
		// 生成整个图片路径
		String imgPath = null;
		// 整个图片的存储文件夹
		String imgPathDir = null;

		// 生成网页中所有图片
		HtmlToImageAll htmlToImageAll = new HtmlToImageAll();
		// 生成网页中所有图片路径
		String imgPathAll = null;
		// 所有图片的存储文件夹
		String imgPathAllDir = null;

		File errorPath = new File(fileImgPath, "errorPath.txt");
		File errorPathWhole = new File(fileImgPath, "errorPathWhole.txt");
		File errorPathUrl = new File(fileImgPath, "errorPathUrl.txt");
		FileWriter errorPathWriter = null;
		FileWriter errorPathWholeWriter = null;
		FileWriter errorPathUrlWriter = null;
		try {
			errorPathWriter = new FileWriter(errorPath, true);
			errorPathWholeWriter = new FileWriter(errorPathWhole, true);
			errorPathUrlWriter = new FileWriter(errorPathUrl, true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// 遍历url
		CountDownLatch threadSignal = new CountDownLatch(list.size());// 初始化countDown
		final CyclicBarrier cyclic = new CyclicBarrier(1);
		Lock lock = new ReentrantLock();
		final Condition full = lock.newCondition();  
		for (int i = 0; i < list.size(); i++) {
			// System.out.println("i:" + i);
			// 获取url
			url = list.get(i);

			// 获取整个网页截图
			// 获取图片绝对路径,借用处理字符串类
			String imgPathIn = htmlToImageAll.deleteSpecialSymbols(url);
			int imgPathDirTail = 0;
			imgPathDir = fileImgPath + imgPathIn + "("
					+ Integer.toString(imgPathDirTail) + ")";
            //判断以前是否截取过该网站，要是有文件名加1
			boolean isDir = fileDir.getDirIsOrNot(fileImgPath, imgPathDir);
			while (isDir == true) {
				if(imgPathDir.endsWith("(" +Integer.toString(imgPathDirTail) + ")")){
					String s = imgPathDir.substring(0, imgPathDir.lastIndexOf("(" +Integer.toString(imgPathDirTail) + ")"));
					imgPathDir = s + "(" + Integer.toString(++imgPathDirTail) + ")";
				}
				/*imgPathDir = imgPathDir.replaceAll(
						Integer.toString(imgPathDirTail),
						Integer.toString(++imgPathDirTail));*/
				isDir = fileDir.getDirIsOrNot(fileImgPath, imgPathDir);

			}
			fileDir.getDir(imgPathDir);
			imgPathAllDir = imgPathDir + "\\AllImage";
			fileDir.getDir(imgPathAllDir);
			imgPathAll = imgPathAllDir + "\\";
			// Const.errorPath.add(imgPathAll);
			try {
				errorPathWriter.write(imgPathAll + "error.txt" + ";" + "\n");
				errorPathUrlWriter.write(imgPathAll + "errorUrl.txt" + ";" + "\n");
				errorPathWholeWriter.write(imgPathDir + "\\errorWhole.txt"
						+ ";" + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			imgPath = imgPathDir + "\\" + imgPathIn + ".png";
			url = "http://" + url;

			// 生成整个图片
			HtmlToImageThread htmlToImageThread = new HtmlToImageThread(url,
					imgPath, imgPathDir, threadSignal,cyclic,lock,full);
			htmlToImageThread.start();

			// 生成网页中所有图片
			HtmlToImageAllThread htmlToImageAllThread = new HtmlToImageAllThread(
					url, imgPathAll, threadSignal,lock,full);
			htmlToImageAllThread.start();
		}
		try {
			errorPathWriter.close();
			errorPathWholeWriter.close();
			errorPathUrlWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 等待所有子线程执行完
		try {
			threadSignal.await();
			HTMLToImageJFrame.textArea.append("截取完成,程序结束\n");
			//System.out.println("last");
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
