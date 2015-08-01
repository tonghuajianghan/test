/*------------------------------------------------------------------------- 
 * 版权所有：姜晗
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com
 * 创建时间：2015-4-9 下午02:17:16 
 * 版本号：v1.0 
 * 本类主要用途描述： 根据像素值删除图片
 * 
-------------------------------------------------------------------------*/
package cust.jh.imagedeal;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import cust.jh.GUI.Const;
import cust.jh.GUI.HTMLToImageJFrame;

/**
 * @ClassName: DeleteImgByPixel
 * @Description: TODO 根据像素值删除图片
 * @author jh
 * @date 2015-4-9 下午02:35:44
 * 
 */
public class DeleteImgByPixel {
	// 图片长
	private int imgHight;
	// 图片宽
	private int imgWeight;

	public int getImgHight() {
		return imgHight;
	}

	public void setImgHight(int imgHight) {
		this.imgHight = imgHight;
	}

	public int getImgWeight() {
		return imgWeight;
	}

	public void setImgWeight(int imgWeight) {
		this.imgWeight = imgWeight;
	}

	/**
	 * @Title: getPixel
	 * @Author: jianghan
	 * @Description: TODO 获取图片像素信息
	 * @param file
	 * 
	 */
	public void getPixel(String fileName, int inlength) {
		/*try {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(Const.isControlError == false){
				File file = new File(fileName);
				if (!file.equals(null)) {
					Image src = null;
					if (file.length() >= inlength) {
						src = ImageIO.read(file); // 构造Image对象
						if (!src.equals(null)) {
							int wideth = src.getWidth(null); // 得到源图宽
							int height = src.getHeight(null); // 得到源图长
							if(Const.imgWeightIsMin == true){
								if(Const.imgHightIsMin ==true){
									if (!(wideth <= Const.imgWeight && height <= Const.imgHight)) {
										deleteImg(file);
									}
								}else{
									if (!(wideth <= Const.imgWeight && height >= Const.imgHight)) {
										deleteImg(file);
									}
								}
							}else{
								if(Const.imgHightIsMin ==true){
									if (!(wideth >= Const.imgWeight && height <= Const.imgHight)) {
										deleteImg(file);
									}
								}else{
									if (!(wideth >= Const.imgWeight && height >= Const.imgHight)) {
										deleteImg(file);
									}
								}
							}
						}
					}
				}
			}
		} catch (IOException e) {
			HTMLToImageJFrame.textArea.append("图片不完整处理失败"  +"\n");
		}*/
	}

	/**
	 * @Title: deleteImg
	 * @Author: jianghan
	 * @Description: TODO 删除图片
	 * @param file
	 * 
	 */
	private void deleteImg(File file) {
		if (file.isFile()) { // 为文件时调用删除文件方法
			file.delete();
		}
	}
}
