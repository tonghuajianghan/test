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
 * 我的第一个大饼图，你想吃吗
 * @acer
 * 2012.10.17
 * 
 */

@SuppressWarnings("unused")
public class text_pie_0100 extends JFrame {
     
	PiePanel panel;//大饼图面板声明
	/*
	 * 此构造方法主要创建和初始化窗口的属性
	 */
	public text_pie_0100(){
		this.setTitle("my大饼子");//设置窗口标题
		this.setSize(500,200);//设置窗口大小
		this.setResizable(false);//窗口不可最大化
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭方式
		panel = new PiePanel(createJFreeChart(createPieDataset()));//?初始化panel
		this.getContentPane().add(panel);//将panel与窗口连接起来
		this.setVisible(true);//窗口可见
		
	}
	/*
	 * 初始化大饼图数据
	 * @return
	 */
	public static DefaultPieDataset createPieDataset(){
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("吃大饼",new Double(15.0));
		pieDataset.setValue("sleep", new Double(30.0));
		pieDataset.setValue("扯淡", new Double(30.0));
		pieDataset.setValue("看书",new Double(5.0));
		pieDataset.setValue("学习",new Double(20.0));
		return pieDataset;
		
	}
	
	/*
	 * 利用ChartFactory生成饼图对象
	 * @param data
	 * @return
	 * 
	 */
	public static JFreeChart createJFreeChart(PieDataset data){
		//正常解析中文的样式
		StandardChartTheme chartTheme = new StandardChartTheme("CN");
		//设置标题的样式
		chartTheme.setExtraLargeFont(new Font("宋体",Font.CENTER_BASELINE, 14));
		//设置轴向的样式
		chartTheme.setLargeFont(new Font("宋体",Font.BOLD, 64));
		//设置图例样式
		chartTheme.setRegularFont(new Font("宋体",Font.BOLD, 12));
		chartTheme.setSmallFont(new Font("宋体",Font.BOLD, 10));//拦截最小字体，最小字体字号为10
		
		ChartFactory.setChartTheme(chartTheme);//将样式表加入报表工具类中
		JFreeChart chart = ChartFactory.createPieChart("时间安排", data,true, true, false);//名字，数据数值 ， 图形，图例，是否显示url
		PiePlot plot = (PiePlot)chart.getPlot();
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({2} percent)"));
		//plot.setExplodePercent("扯淡",0.3D);
		return chart;
		
	}
	/*
	 * 设计存放饼图面板
	 * @author think
	 * 
	 */
	private  class PiePanel extends JPanel{
		public PiePanel(JFreeChart chart){
			this.setLayout(new BorderLayout());//设置面板的布局为边界布局
			ChartPanel chartPanel = new ChartPanel(chart);//放置饼图对象的面板
			this.add(chartPanel);
		}		
	}
	public static void main(String[] args) {
		new text_pie_0100();
	}
	
}

































