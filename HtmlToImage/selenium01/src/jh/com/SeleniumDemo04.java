/*------------------------------------------------------------------------- 
 * 版权所有：姜晗
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com
 * 创建时间：2015-4-4 下午10:51:03 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package jh.com;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class SeleniumDemo04 {
	public static void main(String[] args) {
			
		WebDriver driver = new PhantomJSDriver();
		driver.get("http://huaban.com/");
		System.out.println("mark1");
		
		//获取整个网页的img（集合）元素
		List<WebElement> inputs = driver.findElements(By.xpath("//img"));
		//System.out.println(inputs.get(0).getAttribute("src"));
		
		//List<WebElement> img2 = driver.findElements(By.xpath("//div"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//通过js获取网页的title 注意有return
		
		
		//获取all元素长度
		String alllengthString = "var alllength = " + "document.all;" + "return alllength.length";
		long  alllength = (Long) js.executeScript(alllengthString);
		System.out.println("alllength:" + alllength);
		String imgurl = null;
		for(int i = 0;i < (int)alllength; i++){
			String injs = "return window.getComputedStyle(document.all[" + i +"], null)['background']";	
			String cssimgurl = (String) js.executeScript(injs);
			//System.out.println("i:" + i + cssimgurl);
			imgurl = SeleniumDemo04.getUrlString(cssimgurl);
			if(imgurl != null){
				SeleniumDemo04.getHtmlPicture(imgurl,"cssimg" + Integer.toString(i));
			}
		}
		//String injs = "return window.getComputedStyle(document.getElementById('div'), null)['background']";	
		//String title2 = (String) js.executeScript(injs);
		//System.out.println("11" + alllength);
		//String title = (String) js.executeScript("return document.title");
		//System.out.println("11" + title2);
		
		
		//遍历图片
		for(int i = 0;i < inputs.size(); i++){
			SeleniumDemo04.getHtmlPicture(inputs.get(i).getAttribute("src"), "htmlimg" + Integer.toString(i));
		}
		// inputs.get(0).getText();
		
		driver.close();
		
	}

	public static void getHtmlPicture(String httpUrl,String fileName2) {
		URL url;
		BufferedInputStream in;
		FileOutputStream file;
		try {
			/*System.out.println("取网络图片");
			//获取图片名称。（/后面的）
			String fileName = httpUrl.substring(httpUrl.lastIndexOf("/"));			
			//去除特殊符号
			fileName = deleteSpecialSymbols(fileName);
			//判断字符串中有没有. 
			if(fileName.lastIndexOf(".") != -1){
				fileName = fileName.substring(0, fileName.lastIndexOf(".") + 4);
			}else if(fileName.substring(fileName.length()-4, fileName.length()-3) != "." && 
					fileName.substring(fileName.length()-5, fileName.length()-4) != "."){
				fileName = fileName + ".jpg";
				//判读图片地址后面有没有.jpg等文件类型，没有就加上文件类型
			}
			System.out.println("httpUrl:" + httpUrl);
			System.out.println("filename:" + fileName);*/
			String filePath = "F:\\";			
			url = new URL(httpUrl);

			in = new BufferedInputStream(url.openStream());

			file = new FileOutputStream(new File(filePath + fileName2 + ".jpg"));
			int t;
			while ((t = in.read()) != -1) {
				file.write(t);
			}
			file.close();
			in.close();
			System.out.println("图片获取成功");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/** 
	* @Title: deleteSpecialSymbols 
	* @Author: jianghan
	* @Description: TODO 去除特殊符号
	* @param fileName
	* @return
	*    
	*/
	private static String deleteSpecialSymbols(String fileName){
		fileName = fileName.replace("?", "");
		fileName = fileName.replace("=", "");
		fileName = fileName.replace("/", "");
		fileName = fileName.replace("*", "");
		return fileName;
	}
	
	private static String getUrlString(String cssimgurl){
		String imgurl = null;
		int urlLoc = cssimgurl.indexOf("url");
		int urlfirst = cssimgurl.indexOf("(", urlLoc);
		int urllast = cssimgurl.indexOf(")",urlfirst);
		//System.out.print("urlLoc" + urlLoc);
		if(urlLoc != -1){
			imgurl = cssimgurl.substring(urlfirst + 1, urllast);
		}		
		return imgurl;
	}
}
