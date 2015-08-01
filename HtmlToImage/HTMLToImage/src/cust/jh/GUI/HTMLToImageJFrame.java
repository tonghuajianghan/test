/*------------------------------------------------------------------------- 
 * 版权所有：姜晗
 * 作者：姜晗
 * 联系方式：tonghuajianghan@gmail.com
 * 创建时间：2015-4-15 上午11:42:18 
 * 版本号：v1.0 
 * 本类主要用途描述： 
 * 
-------------------------------------------------------------------------*/
package cust.jh.GUI;

import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cust.jh.controller.ControlError;
import cust.jh.controller.ControlHTMLToImage;
import cust.jh.thread.ControlErrorThread;
import cust.jh.thread.ControlHtmlToImageThread;

public class HTMLToImageJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1023104634571707853L;

	private String urlPath = null;
	private String imgPath = null;

	// 定义该图像中所需要的组件的引用
	private Frame f;
	private JFileChooser fileChooser = new JFileChooser(".");

	// 定义打开和保存对话框
	private static FileDialog openDia;
	// 设置文本区域来保存打开的数据

	private JPanel contentPane;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public static JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HTMLToImageJFrame frame = new HTMLToImageJFrame();
					frame.setVisible(true);
					// 默认模式为 FileDialog.LOAD
					openDia = new FileDialog(frame, "我的打开", FileDialog.LOAD);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HTMLToImageJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("     url文件：");
		lblNewLabel.setBounds(10, 10, 123, 22);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(101, 11, 177, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		// 获取url文件
		JButton btnNewButton = new JButton("获取url文件");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openDia.setVisible(true);
				String dirPath = openDia.getDirectory();// 获取文件路径
				String fileName = openDia.getFile();// 获取文件名称
				//System.out.println(dirPath + fileName);
				textField.setText(dirPath + fileName);
				urlPath = dirPath + fileName;
				Const.urlPath = urlPath;
			}
		});
		btnNewButton.setBounds(288, 10, 127, 23);
		contentPane.add(btnNewButton);

		// 生成文件目录
		JLabel lblNewLabel_1 = new JLabel("生成文件目录：");
		lblNewLabel_1.setBounds(10, 42, 97, 15);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(101, 42, 177, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton_1 = new JButton("生成文件位置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
				// 触发JButton(此例仅设置有一个按钮，多按钮请自行更改)
				if (source instanceof JButton) {
					openFile();
				}
			}
		});
		btnNewButton_1.setBounds(288, 43, 128, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_2 = new JLabel("同时开启phantomjs数:");
		lblNewLabel_2.setBounds(10, 133, 157, 15);
		contentPane.add(lblNewLabel_2);

		final JSpinner spinner = new JSpinner();
		spinner.setValue(5);
		spinner.setBounds(10, 164, 43, 22);
		contentPane.add(spinner);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 106, 787, 10);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-14, 220, 811, 22);
		contentPane.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 272, 797, 22);
		contentPane.add(separator_2);

		JLabel lblNewLabel_3 = new JLabel("输出结果：");
		lblNewLabel_3.setBounds(10, 289, 81, 30);
		contentPane.add(lblNewLabel_3);

		textField_2 = new JTextField();
		textField_2.setBounds(309, 164, 66, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(309, 193, 66, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(524, 164, 66, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		final JCheckBox checkBox = new JCheckBox("图像分辨率过滤（默认大于）:");
		checkBox.setBounds(260, 129, 216, 23);
		contentPane.add(checkBox);
		//System.out.println("checkBox" + checkBox.isSelected());

		final JCheckBox checkBox_1 = new JCheckBox("图像大小过滤（默认大于）:");
		checkBox_1.setBounds(496, 129, 214, 23);
		contentPane.add(checkBox_1);

		final JCheckBox checkBox_2 = new JCheckBox("长:");
		checkBox_2.setBounds(260, 162, 43, 23);
		contentPane.add(checkBox_2);

		final JCheckBox checkBox_3 = new JCheckBox("宽:");
		checkBox_3.setBounds(260, 192, 43, 23);
		contentPane.add(checkBox_3);

		final JCheckBox chckbxKb = new JCheckBox("");
		chckbxKb.setBounds(496, 164, 27, 23);
		contentPane.add(chckbxKb);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("是否小于");
		chckbxNewCheckBox.setBounds(375, 163, 81, 23);
		contentPane.add(chckbxNewCheckBox);

		final JCheckBox checkBox_4 = new JCheckBox("是否小于");
		checkBox_4.setBounds(375, 191, 103, 23);
		contentPane.add(checkBox_4);

		final JCheckBox checkBox_5 = new JCheckBox("是否小于");
		checkBox_5.setBounds(607, 163, 103, 23);
		contentPane.add(checkBox_5);

		// 开始生成图片
		JButton button = new JButton("开始");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//开启phantomjs数量
				Const.phantomjsNum = (Integer) spinner.getValue();
				/*if((phantomjsNum%2)==1){
					phantomjsNum = phantomjsNum + 1;
					Const.phantomjsNum = (phantomjsNum / 2);
				}else{
					Const.phantomjsNum = (phantomjsNum / 2);
				}*/
				//System.out.println("phantomjsNum" + Const.phantomjsNum);
				
				textArea.setText("开始：\n");
				// 执行获取图片方法
				ControlHTMLToImage controlHTMLToImage = new ControlHTMLToImage();				
				if (Integer.parseInt(spinner.getValue().toString()) > 0) {
					Const.phantomjsNum = Integer.parseInt(spinner.getValue()
							.toString());
				}

				Const.checkBox = checkBox.isSelected();
				Const.checkBox_1 = checkBox_1.isSelected();
				Const.checkBox_2 = checkBox_2.isSelected();
				Const.checkBox_3 = checkBox_3.isSelected();
				Const.checkBox_4 = chckbxKb.isSelected();

				// 分辨率复选框
				if (checkBox.isSelected() == true) {
					// 长复选框
					if (checkBox_2.isSelected() == true) {
						// 长不为空
						if (!textField_2.getText().equals(null)
								&& !textField_2.getText().equals("")) {
							Const.imgHight = Integer.parseInt(textField_2
									.getText());
							//是否小于
							if(chckbxNewCheckBox.isSelected() == true){
								Const.imgHightIsMin = true;
							}else{
								Const.imgHightIsMin = false;
							}
							
						} else {
							getDiaLog("length");
						}
					}
					// 宽复选框
					if (checkBox_3.isSelected() == true) {
						// 宽不为空
						if (!textField_3.getText().equals(null)
								&& !textField_3.getText().equals("")) {
							Const.imgWeight = Integer.parseInt(textField_3
									.getText());
							//是否小于
							if(checkBox_4.isSelected() == true){
								Const.imgWeightIsMin = true;
							}else{
								Const.imgWeightIsMin = false;
							}
						} else {
							getDiaLog("weight");
						}
					}
				}
				// 大小复选框
				if (checkBox_1.isSelected() == true) {
					// 大小
					if (chckbxKb.isSelected() == true) {
						// 大小不为空
						if (!textField_4.getText().equals(null)
								&& !textField_4.getText().equals("")) {
							Const.imgSize = Integer.parseInt(textField_4
									.getText());
							//是否小于
							if(checkBox_5.isSelected() == true){
								Const.imgSizeIsMin = true;
							}else{
								Const.imgSizeIsMin = false;
							}
						} else {
							getDiaLog("size");
						}
					}
				}

				//System.out.println(imgPath);
				if (urlPath == null) {
					getDiaLog("urlPath");
				} else if (imgPath == null) {
					getDiaLog("imgPath");
				} else {
					ControlHtmlToImageThread controlHTMLToImageThread = new ControlHtmlToImageThread(urlPath, imgPath + "\\");
					controlHTMLToImageThread.start();
					//controlHTMLToImage.getControlImage(urlPath, imgPath + "\\");
				}
			}
		});
		button.setBounds(14, 235, 93, 23);
		contentPane.add(button);

		JButton btnNewButton_2 = new JButton("开始处理错误");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Const.isControlError = true;
				// System.out.println("imgPath" + Const.imgPath);
				textArea.setText("开始处理错误：\n");
				
				CountDownLatch threadSignal = new CountDownLatch(1);// 初始化countDown
				ControlErrorThread controlErrorThread = new ControlErrorThread(threadSignal);
				controlErrorThread.start();
				// 等待所有子线程执行完
				/*try {
					threadSignal.await();
					HTMLToImageJFrame.textArea.append("截取完成,程序结束\n");
					//System.out.println("last");
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
			}
		});
		btnNewButton_2.setBounds(156, 235, 157, 23);
		contentPane.add(btnNewButton_2);

		/*JButton btnNewButton_3 = new JButton("清空错误");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlError controlError = new ControlError();
				controlError.emptyError(Const.imgPath, "\\errorPath.txt");
				controlError.emptyError(Const.imgPath, "\\errorPathWhole.txt");
			}
		});
		btnNewButton_3.setBounds(335, 235, 93, 23);
		contentPane.add(btnNewButton_3);*/

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(98, 285, 492, 143);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblKb = new JLabel("KB");
		lblKb.setBounds(589, 167, 21, 15);
		contentPane.add(lblKb);
		
		JLabel label = new JLabel("*2");
		label.setBounds(63, 167, 27, 15);
		contentPane.add(label);

		
	}

	public void openFile() {
		try {
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.setDialogTitle("打开文件夹");
			int ret = fileChooser.showOpenDialog(null);
			if (ret == JFileChooser.APPROVE_OPTION) {
				// 文件夹路径
				//System.out.println(fileChooser.getSelectedFile()
						//.getAbsolutePath());
				imgPath = fileChooser.getSelectedFile().getAbsolutePath();
				textField_1.setText(imgPath);
				Const.imgPath = imgPath;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	/**
	 * @Title: getDiaLog
	 * @Author: jianghan
	 * @Description: TODO 获取当url，imgPath 为空时的对话框
	 * @param string
	 * 
	 */
	private void getDiaLog(String string) {
		final Dialog d1 = new Dialog(f, string + "对话框", true);
		d1.setBounds(400, 200, 350, 150);// 设置弹出对话框的位置和大小
		d1.setLayout(new FlowLayout());// 设置弹出对话框的布局为流式布局
		Label lab = new Label();// 创建lab标签填写提示内容
		lab.setText(string + " is null");
		d1.add(lab);

		d1.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				d1.setVisible(false);
			}
		});
		d1.setVisible(true);
	}
}
