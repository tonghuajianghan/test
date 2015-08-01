/*------------------------------------------------------------------------- 
* 版权所有：姜晗
* 作者：姜晗
* 联系方式：tonghuajianghan@gmail.com
* 创建时间：2015-4-6 下午08:58:29 
* 版本号：v1.0 
* 本类主要用途描述： 图片格式累
* 
-------------------------------------------------------------------------*/
package cust.jh.imagedeal;

import java.util.ArrayList;
import java.util.List;

/** 
* @ClassName: ImgFormat 
* @Description: TODO 用于存储图片格式
* @author jh 
* @date 2015-4-6 下午08:58:44 
*  
*/
public class ImgFormat {
	public List<String> getFormat(){
		List<String> listImg = new ArrayList<String>();
		listImg.add(".jpg");
		listImg.add(".png");
		listImg.add(".jpg");
		listImg.add(".gif");
		listImg.add(".svg");
		return listImg;
	}
}
