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
		   Image src = javax.imageio.ImageIO.read(myimage); // ����Image����
		   int wideth = src.getWidth(null); // �õ�Դͼ��
		   int height = src.getHeight(null); // �õ�Դͼ��	
		   System.out.println("" + wideth);
		   System.out.println("" + height);
		   		   		   		   
		    BufferedImage tag = new BufferedImage(200, 200,
		      BufferedImage.TYPE_INT_RGB);
		    tag.getGraphics().drawImage(src, 0, 0, 200, 200, null); // ������С���ͼ
		    FileOutputStream out = new FileOutputStream(myimage); // ������ļ���
		    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		    encoder.encode(tag); // ��JPEG����
		    out.close();
		   
	}
	   
}
