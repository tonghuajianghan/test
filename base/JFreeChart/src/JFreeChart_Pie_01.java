import java.awt.BorderLayout;
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
 * 我的第一个饼图设计应用
 * @author think
 *
 */
@SuppressWarnings("unused")
public class JFreeChart_Pie_01 extends JFrame {
	
	PiePanel panel;
	/**
	 * 此构造方法主要创建和初始化窗口的属性
	 */
	public JFreeChart_Pie_01(){
		this.setTitle("大饼图");//设置窗口标题
		this.setSize(500, 300);//设置窗口大小
		this.setResizable(false);//窗口不可最大化
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭方式
		panel = new PiePanel(createJFreeChart(createPieDataset()));
		this.getContentPane().add(panel);
		this.setVisible(true);//窗口可见
		
	}
	/**
	 * 初始化饼图数据
	 * @return
	 */
	public static DefaultPieDataset createPieDataset(){
		DefaultPieDataset pieDataset= new DefaultPieDataset();
		//填充饼图的图形数据
		pieDataset.setValue("吃饭", new Double(15.0));
		pieDataset.setValue("睡觉", new Double(30.0));
		pieDataset.setValue("学习", new Double(20.0));
		pieDataset.setValue("不务正业", new Double(30.0));
		pieDataset.setValue("看书", new Double(5.0) );
		return pieDataset;
	}
	/**
	 * 利用ChartFactory生成饼图对象
	 * @param data
	 * @return
	 */
	public static JFreeChart createJFreeChart(PieDataset data){
		//正常解析中文的样式
		StandardChartTheme chartTheme = new StandardChartTheme("CN");
		//设置标题样式
		chartTheme.setExtraLargeFont(new Font("宋体",Font.BOLD,20));
		//设置轴向的样式
		chartTheme.setLargeFont(new Font("宋体", Font.BOLD, 14));
		//设置图例样式
		chartTheme.setRegularFont(new Font("宋体", Font.BOLD, 12));
		chartTheme.setSmallFont(new Font("宋体", Font.BOLD, 10));

		ChartFactory.setChartTheme(chartTheme);//将样式加入报表工厂类中
		JFreeChart chart = ChartFactory.createPieChart("时间安排", data, true, true, false);//名字，数据数值，图形，图例，是否显示URL
		PiePlot plot = (PiePlot)chart.getPlot();
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({2} percent)"));
		/*plot.setExplodePercent("不务正业", 0.3D);*/
		return chart;
	}
	/**
	 * 设计存放饼图面板
	 * @author think
	 *
	 */
	private class PiePanel extends JPanel{
		public PiePanel(JFreeChart chart){
			this.setLayout(new BorderLayout());//设置面板的布局为边界布局
			ChartPanel chartPanel = new ChartPanel(chart);//放置饼图对象的面板
		    this.add(chartPanel);
		}
	}
	public static void main(String[] args){
		new JFreeChart_Pie_01();
	}
}
