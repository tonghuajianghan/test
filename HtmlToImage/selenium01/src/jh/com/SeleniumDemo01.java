/*------------------------------------------------------------------------- 
* 版权所有：姜晗
* 作者：姜晗
* 联系方式：tonghuajianghan@gmail.com
* 创建时间：2015-4-4 下午06:30:32 
* 版本号：v1.0 
* 本类主要用途描述： 
* 
-------------------------------------------------------------------------*/
package jh.com;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.DefaultSelenium;

@SuppressWarnings("deprecation")
public class SeleniumDemo01  
{  
  public static void main(String[] args)  
  {  
      String host = "localhost";  
      int port = 4444;  
      String url = "http://www.baidu.com/";  
      String browserType = "*firefox";  
   
      String keyWordsLocator = "document.getElementById('kw')";     
      String search = "document.getElementById('su')";  
      DefaultSelenium selenium = new DefaultSelenium(host,port,browserType,url);  
      selenium.start();  
      selenium.open(url);  
      selenium.type(keyWordsLocator,"java selenium");  
      selenium.click(search);  
      selenium.waitForPageToLoad("30000"); 
      WebDriver driver = new FirefoxDriver();
      //SeleniumDemo01.captureScreenshot(arg0, driver);
      //selenium.stop();  
       
  } 
  public static void captureScreenshot(String arg0,WebDriver driver){  
       
      
      String imagePath = "D:/" + File.separator+arg0+"_"  
              +arg0+".png";  
      File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
      try {  
        org.apache.commons.io.FileUtils.copyFile(screenShotFile, new File(imagePath));  
    } catch (IOException e) {  
        e.printStackTrace();   
    }  
}  
}  
