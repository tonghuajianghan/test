/*------------------------------------------------------------------------- 
 * 版权所有：姜晗
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com
 * 创建时间：2015-4-9 下午04:58:57 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package jh.com;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JFileChooser fileChooser = new JFileChooser(".");
	private JButton button = new JButton("打开文件");

	public MyFrame() {
		this.setTitle("文件夹选择");
		this.setPreferredSize(new Dimension(200, 100));
		this.getContentPane().add(button, BorderLayout.NORTH);
		button.addActionListener(this);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setIgnoreRepaint(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		// 触发JButton(此例仅设置有一个按钮，多按钮请自行更改)
		if (source instanceof JButton) {
			openFile();
		}

	}

	public void openFile() {
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setDialogTitle("打开文件夹");
		int ret = fileChooser.showOpenDialog(null);
		if (ret == JFileChooser.APPROVE_OPTION) {
			// 文件夹路径
			System.out.println(fileChooser.getSelectedFile().getAbsolutePath());
		}
	}

	public static void main(String[] args) {
		Frame frame = new MyFrame();
		frame.setVisible(true);
	}

}
