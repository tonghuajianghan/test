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

import java.util.concurrent.CountDownLatch;

import cust.jh.GUI.Const;
import cust.jh.GUI.HTMLToImageJFrame;
import cust.jh.controller.ControlError;

public class ControlErrorThread extends Thread{
	private String errorPath;
	private String errorPathWhole;
	private String errorPathUrl;
	private CountDownLatch threadSignal;

	public ControlErrorThread(CountDownLatch threadSignal) {	
		this.threadSignal = threadSignal;
	}

	public void run() {
		ControlError controlError = new ControlError();
		controlError.getErrorPath(Const.imgPath + "\\errorPath.txt");
		controlError.getErrorPathWhole(Const.imgPath
				+ "\\errorPathWhole.txt");
		CountDownLatch threadSignal = controlError.getErrorPathUrl("D:\\HtmlToImage\\errorPathUrl.txt");
		threadSignal.countDown();
		/*if(!threadSignal.equals(null)){
			HTMLToImageJFrame.textArea.append("截取完成,程序结束\n");
		}*/
		
		/*try {
			threadSignal.await();
			if(!threadSignal.equals(null)){
				HTMLToImageJFrame.textArea.append("截取完成,程序结束\n");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
	}
}
