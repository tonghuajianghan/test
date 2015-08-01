/*------------------------------------------------------------------------- 
* 版权所有：姜晗
* 作者：姜晗
* 联系方式：tonghuajianghan@gmail.com
* 创建时间：2015-4-7 下午08:23:30 
* 版本号：v1.0 
* 本类主要用途描述： 
* 
-------------------------------------------------------------------------*/
package jh.com;

/**
* 测试扩展Thread类实现的多线程程序
*
* @author leizhimin 2008-9-13 18:22:13
*/
public class TestThread extends Thread{
    public TestThread(String name) {
        super(name);
    }

    public void run() {     
            System.out.println(this.getName());      
    }

    public static void main(String[] args) {
    	for(int i = 0;i < 10 ;i++){
    		Thread t1 = new TestThread(Integer.toString(i));
           // Thread t2 = new TestThread("李四");
            t1.start();
           // t2.start();
    	}
        
    }
}
