/*------------------------------------------------------------------------- 
* 版权所有：姜晗
* 作者：姜晗
* 联系方式：tonghuajianghan@gmail.com
* 创建时间：2015-4-8 下午10:25:24 
* 版本号：v1.0 
* 本类主要用途描述： 图形化用户界面类
* 
-------------------------------------------------------------------------*/
package cust.jh.GUI;

import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import cust.jh.controller.ControlHTMLToImage;

/** 
* @ClassName: HtmlToImageGUI 
* @Description: TODO  图形化用户界面类
* @author jh 
* @date 2015-4-9 上午11:37:20 
*  
*/
public class HtmlToImageGUI extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4559958802160748495L;
	private String urlPath = null;
	private String imgPath = null;
	
	//定义该图像中所需要的组件的引用  
    private Frame f;  
    private Panel p1 = new Panel();
    private JFileChooser fileChooser = new JFileChooser(".");
    
    private JLabel a1;
    private JLabel a2;
    private JTextField b1;
    private JTextField b2;
    
    private JButton butURL;
    private JButton butImgPath;
    private JButton but;
    
    //定义打开和保存对话框
	private FileDialog openDia;
	//设置文本区域来保存打开的数据
    
	public HtmlToImageGUI(){  
        init();          
    }      
    public void init(){  
    	//System.out.println("first");
          
        f=new Frame("url获取图片");  
        f.setBounds(50,100,420,210);  
        //f.setLayout(new FlowLayout());  //采用流式布局  
        p1.setLayout(new GridLayout(3,2));
        
        //p1.setBounds(300,100,300,110);  
        
        a1 = new JLabel("                   url地址文件:");
        a2 = new JLabel("               保存图片地址:");
        b1 = new JTextField("url");
        b2 = new JTextField("imgPath");  
        
        butURL = new  JButton("getURL");  
        butImgPath = new  JButton("getImgPath");  
        but = new  JButton("截取图片");  
       
        p1.add(a1);
        p1.add(b1);
        p1.add(butURL);
        p1.add(a2);
        p1.add(b2);      
        p1.add(butImgPath);
        p1.add(but);
        f.add(p1);
        
        
        //默认模式为 FileDialog.LOAD
		openDia = new FileDialog(f,"我的打开",FileDialog.LOAD);
         
          
        //加载一下窗体上的事件.  
        myEvent();  
        //显示窗体  
        f.setVisible(true);  
    }  
    /** 
    * @Title: myEvent 
    * @Author: jianghan
    * @Description: TODO 触发事件方法
    *    
    */
    private void myEvent(){  
    	//关闭窗口
        f.addWindowListener(new WindowAdapter(){  
            @Override  
            public void windowClosing(WindowEvent e) {  
                System.exit(0);  
            }  
        });  
        //获取url文件
        butURL.addActionListener(new ActionListener() {  
            
            @Override  
            public void actionPerformed(ActionEvent e) {  
            	openDia.setVisible(true);
				String dirPath = openDia.getDirectory();//获取文件路径
				String fileName = openDia.getFile();//获取文件名称
				//System.out.println(dirPath + fileName);
				b1.setText(dirPath + fileName);
				urlPath = dirPath + fileName;
            }
				
        }); 
        //新建生成图片文件
        butImgPath.addActionListener(new ActionListener() {  
            
            @Override  
            public void actionPerformed(ActionEvent e) {  
            	Object source = e.getSource();
            	// 触发JButton(此例仅设置有一个按钮，多按钮请自行更改)
            	if (source instanceof JButton) {
            	    openFile();
            	}	
            }
				
        }); 
        //执行获取图片方法  
        but.addActionListener(new ActionListener() {  
              
            @Override  
            public void actionPerformed(ActionEvent e) {  
            	ControlHTMLToImage controlHTMLToImage = new ControlHTMLToImage();
            	//System.out.println(imgPath);
            	//System.out.println( imgPath + "\\");
            	if(urlPath == null){
            		getDiaLog("urlPath");
            	}else if(imgPath == null){
            		getDiaLog("imgPath");
            	}else{
            		controlHTMLToImage.getControlImage(urlPath, imgPath + "\\");
            	}            	                 	           	
            }
				
        });  
        
          
    }  
    
    /** 
    * @Title: getDiaLog 
    * @Author: jianghan
    * @Description: TODO 获取当url，imgPath 为空时的对话框
    * @param string
    *    
    */
    private void getDiaLog(String string){
    	 final Dialog d1 = new Dialog(f, string + "对话框",true);           		 
		 d1.setBounds(400, 200, 350, 150);//设置弹出对话框的位置和大小
	     d1.setLayout(new FlowLayout());//设置弹出对话框的布局为流式布局
	     Label lab = new Label();//创建lab标签填写提示内容
	     lab.setText(string + " is null");
	     d1.add(lab);
	     
	     d1.addWindowListener(new WindowAdapter(){  
	            @Override  
	            public void windowClosing(WindowEvent e) {  
	                d1.setVisible(false);
	            }  
	        });  
	     d1.setVisible(true);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	} 
	public void openFile() {
	  try {
		  fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.setDialogTitle("打开文件夹");
			int ret = fileChooser.showOpenDialog(null);
			if (ret == JFileChooser.APPROVE_OPTION) {
			   //文件夹路径
			   //System.out.println(fileChooser.getSelectedFile().getAbsolutePath());
			   imgPath = fileChooser.getSelectedFile().getAbsolutePath();
			   b2.setText(imgPath);
			}
		
	  } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	  }	
		
   }
}
