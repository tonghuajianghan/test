/*------------------------------------------------------------------------- 
* 版权所有：姜晗
* 作者：姜晗
* 联系方式：tonghuajianghan@gmail.com
* 创建时间：2015-4-4 下午08:41:34 
* 版本号：v1.0 
* 本类主要用途描述： 
* 
-------------------------------------------------------------------------*/
package jh.com;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class SeleniumDemo03 {
  public static void main(String[] args) {
	  Date date = new Date();
	  System.out.println(date);
	  WebDriver driver = new PhantomJSDriver(); 
      driver.get("http://www.sina.com.cn"); 
      
      try { 
          File srcFile = ((TakesScreenshot)driver). 
                  getScreenshotAs(OutputType.FILE); 
          FileUtils.copyFile 
          (srcFile,new File("d:\\screenshot2.png")); 
      } catch (Exception e) { 
          e.printStackTrace(); 
      }  
      driver.close(); 
      Date date2 = new Date();
      System.out.println(date);
  }  

}
