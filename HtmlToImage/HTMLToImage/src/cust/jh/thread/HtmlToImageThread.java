/*------------------------------------------------------------------------- 
 * 版权所有：姜晗
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com
 * 创建时间：2015-4-7 下午08:55:40 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package cust.jh.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cust.jh.GUI.Const;
import cust.jh.imagedeal.HtmlToImage;

/**
 * @ClassName: HtmlToImageThread
 * @Description: TODO HtmlToImage类的获取整个网页图片，多线程
 * @author jh
 * @date 2015-4-8 上午08:27:12
 * 
 */
public class HtmlToImageThread extends Thread {
	private String url = null;
	private String imgPath = null;
	private String imgPathDir = null;
	// private WebDriver driver = null;
	private CountDownLatch threadsSignal;
	private CyclicBarrier cyclic;

	private Lock lock;
	private Condition full;
	private static int threads;
	CountDownLatch signal = new CountDownLatch(5);  
	
	public HtmlToImageThread(String url, String imgPath, String imgPathDir,
			CountDownLatch threadsSignal, CyclicBarrier cyclic,Lock lock,Condition full) {
		this.url = url;
		this.imgPath = imgPath;
		this.imgPathDir = imgPathDir;
		// this.driver = driver;
		this.threadsSignal = threadsSignal;
		this.cyclic = cyclic;
		this.lock = lock;
		this.full = full;
	}

	/** 
	* @Title: addThreads 
	* @Author: jianghan
	* @Description: TODO 添加线程
	* @throws Exception
	*    
	*/
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

	/** 
	* @Title: removeThreads 
	* @Author: jianghan
	* @Description: TODO 移除线程
	*    
	*/
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
		try {
			cyclic.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			addThreads();
			Thread.sleep(4000);
			//System.out.println("current=" + threads);  
			HtmlToImage htmlToImage = new HtmlToImage();
			htmlToImage.getImageAll(url, imgPath, imgPathDir);
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
