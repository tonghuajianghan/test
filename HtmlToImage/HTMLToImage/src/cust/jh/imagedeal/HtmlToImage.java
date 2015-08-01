/*------------------------------------------------------------------------- 
 * 版权所有：姜晗 
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com
 * 创建时间：2015-4-5 上午10:24:13 
 * 版本号：v1.0 
 * 本类主要用途描述： 将整个html文件转换成图片。获取这个网页的图片
 * 
-------------------------------------------------------------------------*/
package cust.jh.imagedeal;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cust.jh.GUI.HTMLToImageJFrame;
import cust.jh.driver.DriverFactory;

/** 
* @ClassName: HtmlToImage 
* @Description: TODO 将整个html文件转换成图片。获取这个网页的图片
* @author jh 
* @date 2015-4-5 上午11:17:05 
*  
*/
public class HtmlToImage {

	/**
	 * @Title: getImageAll
	 * @Author: jianghan
	 * @Description: TODO 将整个html文件转换成图片
	 * @param url
	 * @param imgPath
	 * @throws InterruptedException 
	 * 
	 */
	public void getImageAll(String url, String imgPath,String imgPathDir){	
		//生成图片
		WebDriver driver = DriverFactory.getInstance().initDriver();	
		try {		
			
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);	
			
			File srcFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(imgPath));		
			//HTMLToImageJFrame.textArea.append("成功截取" + imgPath  +"\n");
			//HTMLToImageJFrame.textArea.append( "网址首页图片截取完成" + url +"\n");	
			
			/*File errorFile = new File(imgPathDir,"rightWhole.txt");
			FileWriter errorFileWriter;
			try {
				errorFileWriter = new FileWriter(errorFile);
				errorFileWriter.write(url + ";" + "\n");//将字符串写入到指定的路径下的文件中
				errorFileWriter.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	*/			
			Thread.sleep(5000);			
			driver.close();
			driver.quit();			
		} catch (Exception e) {
			//HTMLToImageJFrame.textArea.append("错误" + imgPath +"\n");
			File errorFile = new File(imgPathDir,"errorWhole.txt");
			FileWriter errorFileWriter;
			try {
				errorFileWriter = new FileWriter(errorFile);
				errorFileWriter.write(url + ";" + "\n");//将字符串写入到指定的路径下的文件中
				errorFileWriter.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}				
			e.printStackTrace();
			driver.close();
			driver.quit();
		}	
	}
}
