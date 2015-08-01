/*------------------------------------------------------------------------- 
 * 版权所有：姜晗
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com
 * 创建时间：2015-4-8 上午10:20:40 
 * 版本号：v1.0 
 * 本类主要用途描述： 新建文件夹
 * 
-------------------------------------------------------------------------*/
package cust.jh.filedeal;

import java.io.File;

/**
 * @ClassName: FileDir
 * @Description: TODO 新建文件夹
 * @author jh
 * @date 2015-4-8 上午10:24:37
 * 
 */
public class FileDir {
	/**
	 * @Title: getDir
	 * @Author: jianghan
	 * @Description: TODO 新建文件夹
	 * @param dir
	 * 
	 */
	public void getDir(String dir) {
		File file = new File(dir);
		file.mkdirs();
	}

	/** 
	* @Title: getDirIsOrNot 
	* @Author: jianghan
	* @Description: TODO 当目录下已经存在相同的文件夹时，不生成新的文件夹
	* 断电，等异常情况的处理
	* @param fileImgPath
	* @param imgPathDir
	* @return
	*    
	*/
	public boolean getDirIsOrNot(String fileImgPath, String imgPathDir) {
		boolean isDir = false;//没有相等的选项		
		String path = fileImgPath;
		File file = new File(path);
		File[] tempList = file.listFiles();
		for (int i = 0; i < tempList.length; i++) {
			if (tempList[i].isDirectory()) {
				if(imgPathDir.equals(tempList[i].toString())){
					isDir = true;
					break;
				}
			}
		}
		return isDir;
	}
}
