package cn.edu.cust.util.action;


public class CommonAction2Test {
	
	private static void show(String... msgs){
		System.out.println(msgs);
		System.out.println(msgs.length);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		show();
		show((String[])null);
		show("");
	}

}
