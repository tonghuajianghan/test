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
			this.setTitle("柱");
			this.setSize(500,300);
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			panel = new BarPanel(createJFreeChart(getDataSet2()));
			this.getContentPane().add(panel);
			this.setVisible(true);
			
		}
		public static JFreeChart createJFreeChart(CategoryDataset data){
			 StandardChartTheme chartTheme = new StandardChartTheme("CN");
				chartTheme.setExtraLargeFont(new Font("宋体",Font.BOLD,20));
				//设置轴向的样式
				chartTheme.setLargeFont(new Font("宋体", Font.BOLD, 14));
				//设置图例样式
				chartTheme.setRegularFont(new Font("宋体", Font.BOLD, 12));
				chartTheme.setSmallFont(new Font("宋体", Font.BOLD, 10));
				ChartFactory.setChartTheme(chartTheme);
		JFreeChart chart = ChartFactory.createBarChart3D(
							"水果产量图", // 图表标题
							"水果", // 目录轴的显示标签
							"产量", // 数值轴的显示标签
							data, // 数据集
							PlotOrientation.VERTICAL, // 图表方向：水平、垂直
							true, 	// 是否显示图例(对于简单的柱状图必须是false)
							false, 	// 是否生成工具
							false 	// 是否生成URL链接
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
	 * 获取一个演示用的简单数据集对象
	 * @return
	 */
	/*private static CategoryDataset getDataSet() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(100, null, "苹果");
		dataset.addValue(200, null, "梨子");
		dataset.addValue(300, null, "葡萄");
		dataset.addValue(400, null, "香蕉");
		dataset.addValue(500, null, "荔枝");
		return dataset;
	}*/
	/**
	 * 获取一个演示用的组合数据集对象
	 * @return
	 */
	
	private static CategoryDataset getDataSet2() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(100, "北京", "苹果");
		dataset.addValue(100, "上海", "苹果");
		dataset.addValue(100, "广州", "苹果");
		dataset.addValue(200, "北京", "梨子");
		dataset.addValue(200, "上海", "梨子");
		dataset.addValue(200, "广州", "梨子");
		dataset.addValue(300, "北京", "葡萄");
		dataset.addValue(300, "上海", "葡萄");
		dataset.addValue(300, "广州", "葡萄");
		dataset.addValue(400, "北京", "香蕉");
		dataset.addValue(400, "上海", "香蕉");
		dataset.addValue(400, "广州", "香蕉");
		dataset.addValue(500, "北京", "荔枝");
		dataset.addValue(500, "上海", "荔枝");
		dataset.addValue(500, "广州", "荔枝");
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