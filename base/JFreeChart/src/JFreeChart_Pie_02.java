import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 * ��ͼ���
 * 1.��ͼ��ɫ����
 * 2.��ͼ�Զ���ı���
 * 3.��ͼ����ʽ����
 * @author think
 *
 */
/**
 * ��ͼ���ڵ����á�����
 * @author think
 *
 */
public class JFreeChart_Pie_02 extends JFrame{
	/**
	 * ���д����ڿ�ʼ��һ���Զ�������
	 */
	PiePanel panel;
	
	public JFreeChart_Pie_02(){
		this.setTitle("������ͼ");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		
		panel = new PiePanel(createJFreeChart(createPieDataset()));
		this.getContentPane().add(panel);
		this.setVisible(true);
	}
	/**
	 * ��ͼ������
	 * @return
	 */
	public DefaultPieDataset createPieDataset(){
		
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("�Է�", new Double(15.0));
		pieDataset.setValue("˯��", new Double(30.0));
		pieDataset.setValue("ѧϰ", new Double(20.0));
		pieDataset.setValue("������ҵ", new Double(30.0));
		pieDataset.setValue("����", new Double(5.0) );
		return pieDataset;	
	}
	public JFreeChart createJFreeChart(PieDataset data){
		StandardChartTheme chartTheme = new StandardChartTheme("CN");
		chartTheme.setExtraLargeFont(new Font("����",Font.BOLD,20));
		//�����������ʽ
		chartTheme.setLargeFont(new Font("����", Font.BOLD, 14));
		//����ͼ����ʽ
		chartTheme.setRegularFont(new Font("����", Font.BOLD, 12));
		chartTheme.setSmallFont(new Font("����", Font.BOLD, 10));

		ChartFactory.setChartTheme(chartTheme);//����ʽ���뱨��������
		JFreeChart chart = ChartFactory.createPieChart("�г�", data, true, true, false );
		//��ȡPiePlot���󣬴˶�����Ҫ���ñ�ͼ������ԣ�����ɫ����״������
		PiePlot plot = (PiePlot)chart.getPlot();
		//����ÿ����ͼ����ɫ
		plot.setSectionPaint("�Է�",new Color(160, 160, 255));
		plot.setSectionPaint("˯��",new Color(128, 128, 223));
		plot.setSectionPaint("ѧϰ",new Color(96, 96, 191));
		plot.setSectionPaint("������ҵ",new Color(64, 64, 159));
		plot.setSectionPaint("����", new Color(32, 32, 127));
		// �Զ�����ʾ�ٷֱȵ���ʽ
		//�Զ��巽ʽ{0}��ʾѡ�{1}��ʾ��ֵ��{2}��ʾ��ռ����
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({2} percent)"));
		//����ͼƬͻ�𲿷� �ص���ʾ
		plot.setExplodePercent("������ҵ", 0.5D);//�������ֵ�Ƿ���ľ���0.5d��0.1d��
		return chart;
	}
	private class PiePanel extends JPanel{
		public PiePanel(JFreeChart chart){
			this.setLayout(new BorderLayout());
			ChartPanel chartPanel = new ChartPanel(chart);
			this.add(chartPanel);// �ѱ�ͼ���ӽ���
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JFreeChart_Pie_02();
	}

}
