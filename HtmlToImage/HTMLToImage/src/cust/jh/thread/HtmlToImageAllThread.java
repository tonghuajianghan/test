/*------------------------------------------------------------------------- 
 * 版权所有：姜晗
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com
 * 创建时间：2015-4-7 下午08:30:18 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package cust.jh.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import cust.jh.GUI.Const;
import cust.jh.imagedeal.HtmlToImageAll;

/** 
* @ClassName: HtmlToImageAllThread 
* @Description: TODO HtmlToImageAll类的 getImage，多线程
* @author jh 
* @date 2015-4-8 上午08:25:12 
*  
*/
public class HtmlToImageAllThread extends Thread {
	private String url = null;
	private String imgPathAll = null;
	//private WebDriver driver = null;
	private CountDownLatch threadsSignal;  
	
	private Lock lock;
	private Condition full;
	private static int threads;
	CountDownLatch signal = new CountDownLatch(5); 

	public HtmlToImageAllThread(String url, String imgPathAll,CountDownLatch threadsSignal,Lock lock,Condition full) {
		this.url = url;
		this.imgPathAll = imgPathAll;
		//this.driver = driver;
		this.threadsSignal = threadsSignal;  
		this.lock = lock;
		this.full = full;
	}
	
	public void addThreads() throws Exception {
		lock.lock();
		try {
			if (threads > Const.phantomjsNum) {
				full.await();
			}
			threads++;
		} finally {
			lock.unlock();
		}
	}

	public void removeThreads() {
		lock.lock();
		try {
			if (threads <= Const.phantomjsNum) {
				full.signal();
			}
			threads--;
		} finally {
			lock.unlock();
		}
	}

	public void run() {	
		// 生成网页中所有图片
		try {
			addThreads();
			Thread.sleep(4000);
			 HtmlToImageAll htmlToImageAll = new HtmlToImageAll();
				htmlToImageAll.getImage(url, imgPathAll);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			removeThreads();
			threadsSignal.countDown();
			/*if (threads == 0) {
				threadsSignal.countDown();
			}*/
		}
	}
}
