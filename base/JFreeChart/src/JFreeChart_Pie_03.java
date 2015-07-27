import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

/**
 * 
 * @author think
 *
 */
public class JFreeChart_Pie_03 extends JFrame{
	//����һ���ڲ��࣬��һ����壬�������������Щ��ͼ
	private JPanel piePanel;
	
	public JFreeChart_Pie_03(){//���ô��ڵ��������
		this.setTitle("");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,300);
		this.setResizable(false);
		
		piePanel = new JPanel();
		piePanel.setLayout(new BorderLayout());
		//��ͼ�ṩ����� JFreeChart���� �����ṩ�Ĺ��췽���ǽ���һ��JFreeChart��һ������
		ChartPanel chartPanel = new  ChartPanel(createJFreeChart(createDefaultPieDataset()));
		piePanel.add(chartPanel);
		this.getContentPane().add(piePanel);
		this.setVisible(true);//���ô��ڿ�����ʾ
	}
	/**
	 * �����ͼ����
	 * @return
	 */
	public DefaultPieDataset createDefaultPieDataset(){
		DefaultPieDataset data = new DefaultPieDataset();
		data.setValue("�Է�", new Double(15.0));
		data.setValue("˯��", new Double(30.0));
	    data.setValue("ѧϰ", new Double(20.0));
        data.setValue("������ҵ", new Double(30.0));
        data.setValue("����", new Double(5.0) );
		
		return data;
	}
	
	//�����ͼ����������JFreeChart����
	public static JFreeChart createJFreeChart(PieDataset data){//���һ�������������������Ҫ��ȡ��ͼ���ݵĲ���
		//����ģ����ɺ󣬻ص�������ñ�ͼģ��
		ChartFactory.setChartTheme(createStandardChartTheme());
		
		JFreeChart chart = ChartFactory.createPieChart3D("3D���", data, true, true, false);
		//3D��ͼ����״���м򵥵�����
		PiePlot3D localPiePlot3D = (PiePlot3D) chart.getPlot();//��ȡͼ�����Ը�ʽ����
		//���õ�û������ʱ����һ����ʾ��Ϣ
		localPiePlot3D.setNoDataMessage("û�д�����");
		//���ñ�ͼ�ķ�λ����
		localPiePlot3D.setDirection(Rotation.CLOCKWISE);
		//���ñ�ͼ͸����
		localPiePlot3D.setForegroundAlpha(0.5F);
		//���ñ�ͼ������ɫ
		localPiePlot3D.setBackgroundPaint(Color.WHITE);
		return chart;
	}
	//�����ͼ��ģ��
	public static StandardChartTheme createStandardChartTheme(){
		StandardChartTheme theme = new StandardChartTheme("CN");
		theme.setExtraLargeFont(new Font("����",Font.BOLD,20));
		//�����������ʽ
		theme.setLargeFont(new Font("����", Font.BOLD, 14));
		//����ͼ����ʽ
		theme.setRegularFont(new Font("����", Font.BOLD, 12));
		theme.setSmallFont(new Font("����", Font.BOLD, 10));

		return theme;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new JFreeChart_Pie_03();

	}

}
