/*------------------------------------------------------------------------- 
 * 版权所有：姜晗
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com
 * 创建时间：2015-4-6 上午08:41:17 
 * 版本号：v1.0 
 * 本类主要用途描述： 将网页中的所有图片下载下来
 * 
-------------------------------------------------------------------------*/
package cust.jh.imagedeal;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cust.jh.GUI.Const;
import cust.jh.GUI.HTMLToImageJFrame;
import cust.jh.driver.DriverFactory;
import cust.jh.thread.DeleteImgByPixelThread;
import cust.jh.thread.GetHtmlPictureThread;

/**
 * @ClassName: HtmlToImageAll
 * @Description: TODO 将网页中的所有图片下载下来
 * @author jh
 * @date 2015-4-6 上午08:42:18
 * 
 */
public class HtmlToImageAll {
	
	/** 
	* @Title: getImage 
	* @Author: jianghan
	* @Description: TODO 获取多张图片
	* @param url
	* @param imgPath
	 * @throws InterruptedException 
	*    
	*/
	public void getImage(String url, String imgPath){
		WebDriver driver = DriverFactory.getInstance().initDriver();
		try{
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);					
			JavascriptExecutor js = (JavascriptExecutor) driver;		
			HtmlToImageAll htmlToImageAll = new HtmlToImageAll();	
			
			// 遍历html图片
			List<WebElement> inputs = driver.findElements(By.xpath("//img"));		
			for (int i = 0; i < inputs.size(); i++) {
				if(inputs.get(i).getAttribute("src") != null){
					//页面图片
					//htmlToImageAll.getHtmlPicture(inputs.get(i).getAttribute("src"),imgPath);
					GetHtmlPictureThread getHtmlPictureThread = new GetHtmlPictureThread(inputs.get(i).getAttribute("src"), imgPath);
					getHtmlPictureThread.start();
					if(inputs.get(i).getAttribute("data-src") != null){
						//延迟加载图片
						htmlToImageAll.getHtmlPicture(inputs.get(i).getAttribute("data-src"),imgPath);
						GetHtmlPictureThread getHtmlPictureThread2 = new GetHtmlPictureThread(inputs.get(i).getAttribute("data-src"), imgPath);
						getHtmlPictureThread2.start();
					}			
				}			
			}
			
			//获取css中的图像	
			// 获取all元素长度
			String alllengthString = "var alllength = " + "document.all;"
					+ "return alllength.length";
			long alllength = (Long) js.executeScript(alllengthString);
			//System.out.println("alllength:" + alllength);
			String imgurl = null;
			for (int i = 0; i < (int) (alllength-1); i++) {
				//System.out.println("i:" + i);
				String injs = "return window.getComputedStyle(document.all[" + i
						+ "], null)['background']";
				String injs2 = "var all = '';" + "all = window.getComputedStyle(document.all[" + i
						       + "], null)['background'];"
				               + "if(all != null){return all}";			
				String cssimgurl = null;
				
				Object object = js.executeScript(injs2);
				if(object != null){
					cssimgurl = (String)object;
				}	
				imgurl = htmlToImageAll.getUrlString(cssimgurl);
				if (imgurl != null) {
					//htmlToImageAll.getHtmlPicture(imgurl,imgPath);
					GetHtmlPictureThread getHtmlPictureThread3 = new GetHtmlPictureThread(imgurl, imgPath);
					getHtmlPictureThread3.start();
				}						
			}		
			Thread.sleep(5000);			
			HTMLToImageJFrame.textArea.append( "网址全部图片截取完成" + url +"\n");		
			driver.close();
			driver.quit();
		}catch(Exception e){
			HTMLToImageJFrame.textArea.append("截取全部图片时错误" + url  +"\n");
			File errorFile = new File(imgPath,"errorUrl.txt");
			FileWriter errorFileWriter;
			try {
				errorFileWriter = new FileWriter(errorFile,true);
				errorFileWriter.write(url.replace(";", "") + ";" + "\n");//将字符串写入到指定的路径下的文件中
				errorFileWriter.close();	
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			driver.close();
			driver.quit();
		}
		
		
	}

	/** 
	* @Title: getHtmlPicture 
	* @Author: jianghan
	* @Description: TODO 生成图片
	* @param httpUrl
	*    
	*/
	public void getHtmlPicture(String httpUrl,String imgPath) {
		URL url = null;
		BufferedInputStream in = null;
		FileOutputStream file;
		File fileSourse;
		HtmlToImageAll htmlToImageAll = new HtmlToImageAll();
		String fileName = htmlToImageAll.getFileName(httpUrl);
		String filePath = imgPath;
		try {
			/*File rightFile = new File(imgPath,"right.txt");
			FileWriter rightFileWriter = new FileWriter(rightFile,true);				
			rightFileWriter.write(httpUrl.replace(";", "") + ";" + "\n");//将字符串写入到指定的路径下的文件中
			rightFileWriter.close();*/
						
			url = new URL(httpUrl);

			if(!url.equals(null)){
				in = new BufferedInputStream(url.openStream());
			}
				
			int inlength = in.available();
			//System.out.println("a" + inlength);
			//文件小于的文件下载保存
			if(Const.imgSizeIsMin == true){
				if(inlength <= (Const.imgSize*1024)){
					fileSourse = new File(filePath + fileName);
					file = new FileOutputStream(fileSourse);
					int t;
					if(in != null){
							while ((t = in.read()) != -1) {					
								file.write(t);					
							}							
					}
					file.close();
					//像素过滤
					DeleteImgByPixelThread deleteImgByPixelThread = new DeleteImgByPixelThread(filePath + fileName,inlength);
					deleteImgByPixelThread.start();
					HTMLToImageJFrame.textArea.append("成功截取" + filePath + fileName  +"\n");
					
				}	
			}else{
				//文件大于于的文件下载保存
				if(inlength > (Const.imgSize*1024)){
					fileSourse = new File(filePath + fileName);
					file = new FileOutputStream(fileSourse);
					int t;
					if(in != null){
							while ((t = in.read()) != -1) {					
								file.write(t);					
							}							
					}
					file.close();
					//像素过滤
					DeleteImgByPixelThread deleteImgByPixelThread = new DeleteImgByPixelThread(filePath + fileName,inlength);
					deleteImgByPixelThread.start();
					HTMLToImageJFrame.textArea.append("成功截取" + filePath + fileName  +"\n");					
				}	
			}
								
			in.close();
		} catch (Exception e) {
			HTMLToImageJFrame.textArea.append("错误" + filePath + fileName  +"\n");
			File rightFile = new File(imgPath,"error.txt");
			FileWriter rightFileWriter;
			try {
				rightFileWriter = new FileWriter(rightFile,true);
				rightFileWriter.write(httpUrl.replace(";", "") + ";" + "\n");//将字符串写入到指定的路径下的文件中
				rightFileWriter.close();	
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}									
			e.printStackTrace();
		}
	}
	
	/** 
	* @Title: getFileName 
	* @Author: jianghan
	* @Description: TODO 通过url获取图片名字
	* @param httpUrl
	* @return
	*    
	*/
	private String getFileName(String httpUrl){
		String fileName = null;		
		if(httpUrl != null){
			//System.out.println("httpUrl:" + httpUrl);
			fileName = httpUrl.substring(httpUrl.indexOf("//") + 2);	
			// 字符串中有.
			if (fileName.indexOf(".") != -1) {	
				if(fileName.indexOf(".gif") != -1){
					fileName =  fileName.substring(0,fileName.indexOf(".gif") + 4);
				}else if(fileName.indexOf(".jpg") != -1){
					fileName =  fileName.substring(0,fileName.indexOf(".jpg") + 4);
				}else if(fileName.indexOf(".jpeg") != -1){
					fileName =  fileName.substring(0,fileName.indexOf(".jpeg") + 4);
				}else if(fileName.indexOf(".svg") != -1){
					fileName =  fileName.substring(0,fileName.indexOf(".svg") + 4);
				}else if(fileName.indexOf(".png") != -1){
					fileName =  fileName.substring(0,fileName.indexOf(".png") + 4);
				}else{
					fileName = fileName.substring(fileName.lastIndexOf("/"));
					fileName = fileName + ".jpg";
				}
				
			} else{
				//没有.
				if(!fileName.equals(null)){
					if (fileName.substring(fileName.length() - 4,
							fileName.length() - 3) != "."
							&& fileName.substring(fileName.length() - 5,
									fileName.length() - 4) != ".") {
						fileName = fileName + ".jpg";
						// 判读图片地址后面有没有.jpg等文件类型，没有就加上文件类型
					}
				}				
			}
			fileName = deleteSpecialSymbols(fileName);
			//System.out.println("filename:" + fileName);
		}		
		return fileName;
	}

	/**
	 * @Title: deleteSpecialSymbols
	 * @Author: jianghan
	 * @Description: TODO 去除特殊符号
	 * @param fileName
	 * @return
	 * 
	 */
	public String deleteSpecialSymbols(String fileName) {
		fileName = fileName.replace("?", "");
		fileName = fileName.replace("=", "");
		fileName = fileName.replace("/", "");
		fileName = fileName.replace("*", "");
		fileName = fileName.replace(":", "");
		fileName = fileName.replace("\\", "");
		fileName = fileName.replace("\"", "");
		fileName = fileName.replace("<", "");
		fileName = fileName.replace(">", "");
		return fileName;
	}

	/**
	 * @Title: getUrlString
	 * @Author: jianghan
	 * @Description: TODO 获取css中的url时，对路径字符串截取
	 * @param cssimgurl
	 * @return
	 * 
	 */
	private String getUrlString(String cssimgurl) {
		String imgurl = null;
		int urlLoc = cssimgurl.indexOf("url");
		int urlfirst = cssimgurl.indexOf("(", urlLoc);
		int urllast = cssimgurl.indexOf(")", urlfirst);
		// System.out.print("urlLoc" + urlLoc);
		if (urlLoc != -1) {
			imgurl = cssimgurl.substring(urlfirst + 1, urllast);
		}
		return imgurl;
	}

}
