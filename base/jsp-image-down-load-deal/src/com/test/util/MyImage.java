package com.test.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class MyImage {
	public void dealImage(File myimage) throws IOException{		   
		   Image src = javax.imageio.ImageIO.read(myimage); // 构造Image对象
		   int wideth = src.getWidth(null); // 得到源图宽
		   int height = src.getHeight(null); // 得到源图长	
		   System.out.println("" + wideth);
		   System.out.println("" + height);
		   		   		   		   
		    BufferedImage tag = new BufferedImage(200, 200,
		      BufferedImage.TYPE_INT_RGB);
		    tag.getGraphics().drawImage(src, 0, 0, 200, 200, null); // 绘制缩小后的图
		    FileOutputStream out = new FileOutputStream(myimage); // 输出到文件流
		    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		    encoder.encode(tag); // 近JPEG编码
		    out.close();
		   
	}
	   
}
