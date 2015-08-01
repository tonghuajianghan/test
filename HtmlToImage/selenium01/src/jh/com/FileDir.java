/*------------------------------------------------------------------------- 
* 版权所有：姜晗
* 作者：姜晗
* 联系方式：tonghuajianghan@gmail.com
* 创建时间：2015-4-9 下午03:36:40 
* 版本号：v1.0 
* 本类主要用途描述： 
* 
-------------------------------------------------------------------------*/
package jh.com;

import java.io.File;

public class FileDir {
	 public static void main(String[] args) {
	  String path="d:/";
	  File file=new File(path);
	  File[] tempList = file.listFiles();
	  for (int i = 0; i < tempList.length; i++) {
	   if (tempList[i].isDirectory()) {
	    System.out.println("文件夹："+tempList[i]);
	   }
	  }
	 }
	}
