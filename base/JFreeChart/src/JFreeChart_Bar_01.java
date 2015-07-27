import java.awt.BorderLayout;
import java.awt.Font;


import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.StandardChartTheme;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class JFreeChart_Bar_01 extends JFrame{
	    BarPanel panel;
		public JFreeChart_Bar_01(){
			this.setTitle("��");
			this.setSize(500,300);
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			panel = new BarPanel(createJFreeChart(getDataSet2()));
			this.getContentPane().add(panel);
			this.setVisible(true);
			
		}
		public static JFreeChart createJFreeChart(CategoryDataset data){
			 StandardChartTheme chartTheme = new StandardChartTheme("CN");
				chartTheme.setExtraLargeFont(new Font("����",Font.BOLD,20));
				//�����������ʽ
				chartTheme.setLargeFont(new Font("����", Font.BOLD, 14));
				//����ͼ����ʽ
				chartTheme.setRegularFont(new Font("����", Font.BOLD, 12));
				chartTheme.setSmallFont(new Font("����", Font.BOLD, 10));
				ChartFactory.setChartTheme(chartTheme);
		JFreeChart chart = ChartFactory.createBarChart3D(
							"ˮ������ͼ", // ͼ�����
							"ˮ��", // Ŀ¼�����ʾ��ǩ
							"����", // ��ֵ�����ʾ��ǩ
							data, // ���ݼ�
							PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
							true, 	// �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
							false, 	// �Ƿ����ɹ���
							false 	// �Ƿ�����URL����
							);
		   
		return chart;
		}
		/*FileOutputStream fos_jpg = null;
		try {
			fos_jpg = new FileOutputStream("D://fruit.jpg");
			ChartUtilities.writeChartAsJPEG(fos_jpg,100,chart,400,300,null);
		} finally {
			try {
				fos_jpg.close();
			} catch (Exception e) {}
		}*/
	
	/**
	 * ��ȡһ����ʾ�õļ����ݼ�����
	 * @return
	 */
	/*private static CategoryDataset getDataSet() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(100, null, "ƻ��");
		dataset.addValue(200, null, "����");
		dataset.addValue(300, null, "����");
		dataset.addValue(400, null, "�㽶");
		dataset.addValue(500, null, "��֦");
		return dataset;
	}*/
	/**
	 * ��ȡһ����ʾ�õ�������ݼ�����
	 * @return
	 */
	
	private static CategoryDataset getDataSet2() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(100, "����", "ƻ��");
		dataset.addValue(100, "�Ϻ�", "ƻ��");
		dataset.addValue(100, "����", "ƻ��");
		dataset.addValue(200, "����", "����");
		dataset.addValue(200, "�Ϻ�", "����");
		dataset.addValue(200, "����", "����");
		dataset.addValue(300, "����", "����");
		dataset.addValue(300, "�Ϻ�", "����");
		dataset.addValue(300, "����", "����");
		dataset.addValue(400, "����", "�㽶");
		dataset.addValue(400, "�Ϻ�", "�㽶");
		dataset.addValue(400, "����", "�㽶");
		dataset.addValue(500, "����", "��֦");
		dataset.addValue(500, "�Ϻ�", "��֦");
		dataset.addValue(500, "����", "��֦");
		return dataset;
	}
	private class BarPanel extends JPanel{
		public BarPanel(JFreeChart chart){
			this.setLayout(new BorderLayout());
			ChartPanel chartPanel = new ChartPanel(chart);
			this.add(chartPanel);
		}
	}
	public static void main(String[] args){
		new JFreeChart_Bar_01();
	}
	
}