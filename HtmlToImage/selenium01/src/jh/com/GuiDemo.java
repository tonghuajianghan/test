package jh.com;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GuiDemo {  
    public static void main(String[] args) {  
        Frame f=new Frame("my awt");  
        f.setSize(500,400);  
        f.setLocation(300,200);  
        f.setLayout(new FlowLayout());  
          
        Button b=new Button("button");  
          
        f.add(b);  
          
        f.addWindowListener(new MyWin());  
          
        f.setVisible(true);  
        System.out.println("Hello world!");  
    }  
  
} 

//因为接口WindowLinstener中的所有方法都被子类 WindowAdapter实现了,.  
//并且覆盖了其中的所有方法,那么我们只能继承 WindowAdapter 覆盖我们的方法即可  
class MyWin extends WindowAdapter{  
    
  @Override  
  public void windowClosing(WindowEvent e) {  
      // TODO Auto-generated method stub  
      //System.out.println("Window closing"+e.toString());  
      System.out.println("我关了");  
      System.exit(0);  
  }  
  @Override  
  public void windowActivated(WindowEvent e) {  
      //每次获得焦点 就会触发  
      System.out.println("我活了");    
      //super.windowActivated(e);  
  }  
  @Override  
  public void windowOpened(WindowEvent e) {  
      // TODO Auto-generated method stub  
      System.out.println("我开了");  
      //super.windowOpened(e);  
  }  
    
}  