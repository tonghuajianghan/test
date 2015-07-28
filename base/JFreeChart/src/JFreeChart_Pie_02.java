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
 * 饼图的深化
 * 1.饼图颜色设置
 * 2.饼图自定义的比率
 * 3.饼图的样式设置
 * @author think
 *
 */
/**
 * 饼图窗口的设置···
 * @author think
 *
 */
public class JFreeChart_Pie_02 extends JFrame{
	/**
	 * 面板写完后，在开始加一个自定义的面板
	 */
	PiePanel panel;
	
	public JFreeChart_Pie_02(){
		this.setTitle("深入大饼图");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 300);
		
		panel = new PiePanel(createJFreeChart(createPieDataset()));
		this.getContentPane().add(panel);
		this.setVisible(true);
	}
	/**
	 * 饼图的数据
	 * @return
	 */
	public DefaultPieDataset createPieDataset(){
		
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("吃饭", new Double(15.0));
		pieDataset.setValue("睡觉", new Double(30.0));
		pieDataset.setValue("学习", new Double(20.0));
		pieDataset.setValue("不务正业", new Double(30.0));
		pieDataset.setValue("看书", new Double(5.0) );
		return pieDataset;	
	}
	public JFreeChart createJFreeChart(PieDataset data){
		StandardChartTheme chartTheme = new StandardChartTheme("CN");
		chartTheme.setExtraLargeFont(new Font("宋体",Font.BOLD,20));
		//设置轴向的样式
		chartTheme.setLargeFont(new Font("宋体", Font.BOLD, 14));
		//设置图例样式
		chartTheme.setRegularFont(new Font("宋体", Font.BOLD, 12));
		chartTheme.setSmallFont(new Font("宋体", Font.BOLD, 10));

		ChartFactory.setChartTheme(chartTheme);//将样式加入报表工厂类中
		JFreeChart chart = ChartFactory.createPieChart("行程", data, true, true, false );
		//获取PiePlot对象，此对象主要设置饼图相关属性，如颜色、形状。。。
		PiePlot plot = (PiePlot)chart.getPlot();
		//设置每个饼图的颜色
		plot.setSectionPaint("吃饭",new Color(160, 160, 255));
		plot.setSectionPaint("睡觉",new Color(128, 128, 223));
		plot.setSectionPaint("学习",new Color(96, 96, 191));
		plot.setSectionPaint("不务正业",new Color(64, 64, 159));
		plot.setSectionPaint("看书", new Color(32, 32, 127));
		// 自定义显示百分比的样式
		//自定义方式{0}表示选项，{1}表示数值，{2}表示所占比例
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({2} percent)"));
		//设置图片突起部分 重点显示
		plot.setExplodePercent("不务正业", 0.5D);//后面的数值是分离的距离0.5d比0.1d大
		return chart;
	}
	private class PiePanel extends JPanel{
		public PiePanel(JFreeChart chart){
			this.setLayout(new BorderLayout());
			ChartPanel chartPanel = new ChartPanel(chart);
			this.add(chartPanel);// 把饼图面板加进来
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
