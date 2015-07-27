package pie_chart;

import java.awt.BorderLayout;
//import java.awt.Borderlayout;
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


/*
 * �ҵĵ�һ�����ͼ���������
 * @acer
 * 2012.10.17
 * 
 */

@SuppressWarnings("unused")
public class text_pie_0100 extends JFrame {
     
	PiePanel panel;//���ͼ�������
	/*
	 * �˹��췽����Ҫ�����ͳ�ʼ�����ڵ�����
	 */
	public text_pie_0100(){
		this.setTitle("my�����");//���ô��ڱ���
		this.setSize(500,200);//���ô��ڴ�С
		this.setResizable(false);//���ڲ������
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رշ�ʽ
		panel = new PiePanel(createJFreeChart(createPieDataset()));//?��ʼ��panel
		this.getContentPane().add(panel);//��panel�봰����������
		this.setVisible(true);//���ڿɼ�
		
	}
	/*
	 * ��ʼ�����ͼ����
	 * @return
	 */
	public static DefaultPieDataset createPieDataset(){
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("�Դ��",new Double(15.0));
		pieDataset.setValue("sleep", new Double(30.0));
		pieDataset.setValue("����", new Double(30.0));
		pieDataset.setValue("����",new Double(5.0));
		pieDataset.setValue("ѧϰ",new Double(20.0));
		return pieDataset;
		
	}
	
	/*
	 * ����ChartFactory���ɱ�ͼ����
	 * @param data
	 * @return
	 * 
	 */
	public static JFreeChart createJFreeChart(PieDataset data){
		//�����������ĵ���ʽ
		StandardChartTheme chartTheme = new StandardChartTheme("CN");
		//���ñ������ʽ
		chartTheme.setExtraLargeFont(new Font("����",Font.CENTER_BASELINE, 14));
		//�����������ʽ
		chartTheme.setLargeFont(new Font("����",Font.BOLD, 64));
		//����ͼ����ʽ
		chartTheme.setRegularFont(new Font("����",Font.BOLD, 12));
		chartTheme.setSmallFont(new Font("����",Font.BOLD, 10));//������С���壬��С�����ֺ�Ϊ10
		
		ChartFactory.setChartTheme(chartTheme);//����ʽ����뱨��������
		JFreeChart chart = ChartFactory.createPieChart("ʱ�䰲��", data,true, true, false);//���֣�������ֵ �� ͼ�Σ�ͼ�����Ƿ���ʾurl
		PiePlot plot = (PiePlot)chart.getPlot();
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({2} percent)"));
		//plot.setExplodePercent("����",0.3D);
		return chart;
		
	}
	/*
	 * ��ƴ�ű�ͼ���
	 * @author think
	 * 
	 */
	private  class PiePanel extends JPanel{
		public PiePanel(JFreeChart chart){
			this.setLayout(new BorderLayout());//�������Ĳ���Ϊ�߽粼��
			ChartPanel chartPanel = new ChartPanel(chart);//���ñ�ͼ��������
			this.add(chartPanel);
		}		
	}
	public static void main(String[] args) {
		new text_pie_0100();
	}
	
}

































