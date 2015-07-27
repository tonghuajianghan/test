package cn.edu.cust.util;

public class StringUtil {
	
	public static byte[] getBytes(String content, String charset){
		try{
			return content.getBytes(charset);
		}catch(Exception ex){
			return content.getBytes();
		}
	}

}
