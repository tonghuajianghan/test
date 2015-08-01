/*------------------------------------------------------------------------- 
* 版权所有：姜晗
* 作者：姜晗
* 联系方式：tonghuajianghan@gmail.com
* 创建时间：2015-4-8 上午10:18:32 
* 版本号：v1.0 
* 本类主要用途描述： 
* 
-------------------------------------------------------------------------*/
package jh.com;

import java.io.File;

public class Test {
 public static void main(String args[]) {
  File file = new File("D:\\A\\B\\C");
  file.mkdirs();
  
  file = new File("D:\\A\\B\\D");
  file.mkdir();
 }
 }
