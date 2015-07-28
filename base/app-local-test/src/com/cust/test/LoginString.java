//将 null 参数传递给此类中的构造方法或方法将抛出 NullPointerException
//static 表示不需要创建类实例就可以调用的方法

package com.cust.test;

public class LoginString {
	public static void main(String[] args) {
	    //byteToString();
	    //testcharAt();
		//testcodePointAt();
		//testcompareTo();
		testcopyValueOf();
	}
	public static void byteToString(){//通过使用平台的默认字符集解码指定的 byte 数组，构造一个新的 String
		byte[] b ={1,0,1};
		String sb = new String(b);
		System.out.println(sb);
	}
	public static void testcharAt(){//返回指定索引处的 char 值
		String sc = "abc";
		char scc = sc.charAt(0);
		System.out.println(scc);
	}
	public static void testcodePointAt(){// 返回指定索引处的字符（Unicode 代码点）。
		String sp = "def";
		int i = sp.codePointAt(1);
		System.out.println(i);
	}
	public static void testcompareTo(){//按字典顺序比较两个字符串,
		String sct = "abc";
		String sct2 = "def";
		int i = sct.compareTo(sct2);//a在d前面返回一个-1
		System.out.println(i);
	}
	
	//public satic String concat()  将指定字符串连接到此字符串的结尾
	
	public static void testcopyValueOf(){//字符数组转换成字符串
		String scv = "";
		char[] data = {'1','2','3'};
		scv = String.copyValueOf(data);
		System.out.println(scv);
	}
	
	
}







