/*------------------------------------------------------------------------- 
* 版权所有：姜晗
* 作者：姜晗
* 联系方式：tonghuajianghan@gmail.com
* 创建时间：2015-4-8 下午10:41:12 
* 版本号：v1.0 
* 本类主要用途描述： 
* 
-------------------------------------------------------------------------*/
package jh.com;

import java.awt.Button;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
  
public class FrameDemo {  
  
    //定义该图像中所需要的组件的引用  
    private Frame f;  
    private Panel p1 = new Panel();
    private Panel p2 = new Panel();
    
    private Label a1;
    private Label a2;
    private TextField b1;
    private TextField b2;
    private Button but;
    
    //定义打开和保存对话框
	private FileDialog openDia,saveDia;
	//设置文本区域来保存打开的数据
	private TextArea ta;

	private File file;
    
    FrameDemo(){  
        init();          
    }      
    public void init(){  
          
        f=new Frame("my freame");  
        f.setBounds(300,100,300,300);  
        f.setLayout(new FlowLayout());  //采用流式布局  
        
        a1 = new Label("url:");
        a2 = new Label("imgPath:");
        b1 = new TextField("name");
        b2 = new TextField("password");          
        but = new  Button("my button");  
       
        p1.add(a1);
        p1.add(b1);
        p2.add(a2);
        p2.add(b2);
        p2.add(but);
        f.add(p1);
        f.add(p2);
        
        //默认模式为 FileDialog.LOAD
		openDia = new FileDialog(f,"我的打开",FileDialog.LOAD);
		saveDia = new FileDialog(f,"我的保存",FileDialog.SAVE);
         
          
        //加载一下窗体上的事件.  
        myEvent();  
        //显示窗体  
        f.setVisible(true);  
    }  
    private void myEvent(){  
        f.addWindowListener(new WindowAdapter(){  
            @Override  
            public void windowClosing(WindowEvent e) {  
                System.exit(0);  
            }  
        });  
          
        but.addActionListener(new ActionListener() {  
              
            @Override  
            public void actionPerformed(ActionEvent e) {  
            	openDia.setVisible(true);
				String dirPath = openDia.getDirectory();//获取文件路径
				String fileName = openDia.getFile();//获取文件名称
				System.out.println(dirPath + fileName);
				b1.setText(dirPath + fileName);
            }
				
        });  
        
          
    }  
      
    public static void main(String[] args) {  
        FrameDemo f=new FrameDemo();  
    }  
  
}  
