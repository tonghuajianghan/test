/*------------------------------------------------------------------------- 
* 版权所有：姜晗
* 作者：姜晗
* 联系方式：tonghuajianghan@gmail.com
* 创建时间：2015-4-4 下午08:22:24 
* 版本号：v1.0 
* 本类主要用途描述： 
* 
-------------------------------------------------------------------------*/
package jh.com;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class SeleniumDemo02 {
  public static void main(String[] args) throws InterruptedException {
	  String URL="http://www.baidu.com";
	  //System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe"); 
	  WebDriver driver = new HtmlUnitDriver();
	  driver.get(URL);
	  //max size the browser
	  driver.manage().window().maximize(); 	    
	  Thread.sleep(2000);
	  snapshot((TakesScreenshot)driver,"open_baidu.png");
  }
  
  public static void snapshot(TakesScreenshot drivername, String filename)
  {
      // this method will take screen shot ,require two parameters ,one is driver name, another is file name
      
    String currentPath = System.getProperty("user.dir"); //get current work folder
    System.out.println(currentPath);
    File scrFile = drivername.getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        try {
            System.out.println("save snapshot path is:"+currentPath+"/"+filename);
            FileUtils.copyFile(scrFile, new File(currentPath+"\\"+filename));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Can't save screenshot");
            e.printStackTrace();
        } 
        finally
        {
           
            System.out.println("screen shot finished");
        }
  }
}
