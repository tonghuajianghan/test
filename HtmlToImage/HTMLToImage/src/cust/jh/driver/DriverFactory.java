/*------------------------------------------------------------------------- 
 * 版权所有：姜晗
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com
 * 创建时间：2015-4-4 下午11:52:26 
 * 版本号：v1.0 
 * 本类主要用途描述： 驱动工厂类
 * 
-------------------------------------------------------------------------*/
package cust.jh.driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import com.sun.jna.platform.dnd.GhostedDragImage;

import cust.jh.GUI.Const;

/** 
* @ClassName: DriverFactory 
* @Description: TODO 驱动工厂类
* @author jh 
* @date 2015-4-5 上午12:00:51 
*  
*/
public class DriverFactory {
	private static DriverFactory driverFactory;
 	//private static WebDriver driver;

	private DriverFactory() {
	}

	/**
	 * @Title: getInstance
	 * @Author: jianghan
	 * @Description: TODO 单例生成驱动工厂
	 * @return
	 * 
	 */
	public static synchronized DriverFactory getInstance() {
		if (driverFactory == null) {
			driverFactory = new DriverFactory();
		}
		return driverFactory;
	}
	
	/** 
	* @Title: initDriver 
	* @Author: jianghan
	* @Description: TODO 生成dirver
	* @return
	*    
	*/
	public WebDriver initDriver(){
		WebDriver driver = new PhantomJSDriver();
		return  driver;
	}
	
	/** 
	* @Title: setDriver 
	* @Author: jianghan
	* @Description: TODO 控制开启phantomjs数量
	* @param phantomjhNum
	* @return
	*    
	*/
	public List<WebDriver> setDriver(int phantomjhNum){
		List<WebDriver> listWebDriver = new ArrayList<WebDriver>();
		for(int i = 0; i < phantomjhNum;i++){
			WebDriver driver = new PhantomJSDriver();
			//System.out.println("driver" + driver.toString());
			//driver.manage().window().setSize(null); 
			listWebDriver.add(driver);	
			driver.close();
			//driver.quit();
		}
		return listWebDriver;
	}
	
}
