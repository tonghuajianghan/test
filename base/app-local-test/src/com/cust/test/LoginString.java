//�� null �������ݸ������еĹ��췽���򷽷����׳� NullPointerException
//static ��ʾ����Ҫ������ʵ���Ϳ��Ե��õķ���

package com.cust.test;

public class LoginString {
	public static void main(String[] args) {
	    //byteToString();
	    //testcharAt();
		//testcodePointAt();
		//testcompareTo();
		testcopyValueOf();
	}
	public static void byteToString(){//ͨ��ʹ��ƽ̨��Ĭ���ַ�������ָ���� byte ���飬����һ���µ� String
		byte[] b ={1,0,1};
		String sb = new String(b);
		System.out.println(sb);
	}
	public static void testcharAt(){//����ָ���������� char ֵ
		String sc = "abc";
		char scc = sc.charAt(0);
		System.out.println(scc);
	}
	public static void testcodePointAt(){// ����ָ�����������ַ���Unicode ����㣩��
		String sp = "def";
		int i = sp.codePointAt(1);
		System.out.println(i);
	}
	public static void testcompareTo(){//���ֵ�˳��Ƚ������ַ���,
		String sct = "abc";
		String sct2 = "def";
		int i = sct.compareTo(sct2);//a��dǰ�淵��һ��-1
		System.out.println(i);
	}
	
	//public satic String concat()  ��ָ���ַ������ӵ����ַ����Ľ�β
	
	public static void testcopyValueOf(){//�ַ�����ת�����ַ���
		String scv = "";
		char[] data = {'1','2','3'};
		scv = String.copyValueOf(data);
		System.out.println(scv);
	}
	
	
}







