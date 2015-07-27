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
	//定义一个内部类，做一个面板，让面板来加载这些饼图
	private JPanel piePanel;
	
	public JFreeChart_Pie_03(){//设置窗口的相关属性
		this.setTitle("");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,300);
		this.setResizable(false);
		
		piePanel = new JPanel();
		piePanel.setLayout(new BorderLayout());
		//饼图提供的面板 JFreeChart主键 他所提供的构造方法是接受一个JFreeChart的一个对象
		ChartPanel chartPanel = new  ChartPanel(createJFreeChart(createDefaultPieDataset()));
		piePanel.add(chartPanel);
		this.getContentPane().add(piePanel);
		this.setVisible(true);//设置窗口可以显示
	}
	/**
	 * 构造饼图数据
	 * @return
	 */
	public DefaultPieDataset createDefaultPieDataset(){
		DefaultPieDataset data = new DefaultPieDataset();
		data.setValue("吃饭", new Double(15.0));
		data.setValue("睡觉", new Double(30.0));
	    data.setValue("学习", new Double(20.0));
        data.setValue("不务正业", new Double(30.0));
        data.setValue("看书", new Double(5.0) );
		
		return data;
	}
	
	//构造饼图，必须生成JFreeChart对象
	public static JFreeChart createJFreeChart(PieDataset data){//添加一个参数，这个参数是需要获取饼图数据的参数
		//构造模板完成后，回到这里，设置饼图模板
		ChartFactory.setChartTheme(createStandardChartTheme());
		
		JFreeChart chart = ChartFactory.createPieChart3D("3D大饼", data, true, true, false);
		//3D饼图的形状进行简单的设置
		PiePlot3D localPiePlot3D = (PiePlot3D) chart.getPlot();//获取图形属性格式对象
		//设置当没有数据时给出一个提示信息
		localPiePlot3D.setNoDataMessage("没有此数据");
		//设置饼图的方位或方向
		localPiePlot3D.setDirection(Rotation.CLOCKWISE);
		//设置饼图透明度
		localPiePlot3D.setForegroundAlpha(0.5F);
		//设置饼图背景颜色
		localPiePlot3D.setBackgroundPaint(Color.WHITE);
		return chart;
	}
	//构造饼图的模板
	public static StandardChartTheme createStandardChartTheme(){
		StandardChartTheme theme = new StandardChartTheme("CN");
		theme.setExtraLargeFont(new Font("宋体",Font.BOLD,20));
		//设置轴向的样式
		theme.setLargeFont(new Font("宋体", Font.BOLD, 14));
		//设置图例样式
		theme.setRegularFont(new Font("宋体", Font.BOLD, 12));
		theme.setSmallFont(new Font("宋体", Font.BOLD, 10));

		return theme;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new JFreeChart_Pie_03();

	}

}
