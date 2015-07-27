/* -------------------
 * LineChartDemo1.java
 * -------------------
 * (C) Copyright 2002-2005, by Object Refinery Limited.
 *
 */



import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.Ellipse2D;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;

/**
 * A simple demonstration application showing how to create a line chart using 
 * data from a {@link CategoryDataset}.
 */
public class LineChartDemo1 extends JFrame {
	LinePanel panel;

    /**
     * Creates a new demo.
     *
     * @param title  the frame title.
     */
    public LineChartDemo1() {
        this.setTitle("折线图");
        this.setSize(500,300);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new LinePanel(createChart(createDataset()));
        this.getContentPane().add(panel);
        this.setVisible(true);
    }

    /**
     * Creates a sample dataset.
     * 
     * @return The dataset.
     */
    private static CategoryDataset createDataset() {
        DefaultCategoryDataset Dataset = new DefaultCategoryDataset();
        Dataset.addValue(212, "正常", "吃饭");
        Dataset.addValue(504, "正常", "睡觉");
        Dataset.addValue(1520, "正常", "学习");
        Dataset.addValue(5842, "正常", "不务正业");
        Dataset.addValue(2991, "正常", "看书");
        
        return Dataset;
    }
    
    /**
     * Creates a sample chart.
     * 
     * @param dataset  a dataset.
     * 
     * @return The chart.
     */
    private static JFreeChart createChart(CategoryDataset data) {
        
        // create the chart...
    	StandardChartTheme chartTheme = new StandardChartTheme("CN");
    	//设置标题样式
    	chartTheme.setExtraLargeFont(new Font("宋体",Font.BOLD,20));
    	//设置轴向的样式
    	chartTheme.setLargeFont(new Font("宋体", Font.BOLD, 14));
    	//设置图例样式
    	chartTheme.setRegularFont(new Font("宋体", Font.BOLD, 12));
    	chartTheme.setSmallFont(new Font("宋体", Font.BOLD, 10));
        ChartFactory.setChartTheme(chartTheme);
    	JFreeChart chart = ChartFactory.createLineChart(
            "时间安排",   // 图表标题
            null,                       // 域轴标签
            "所花时间",                   // 方位轴标签
            data,                         // 数据
            PlotOrientation.VERTICAL,        //  定位,定向;方针
            true,                           // 是否显示图例，对于简单的图必须False
            true,                            // tooltips
            false                            // urls
        );

        chart.addSubtitle(new TextTitle("一天所作"));
        TextTitle source = new TextTitle(
            "Source: Java In A Nutshell (5th Edition) " 
            + "by David Flanagan (O'Reilly)"
        );
        source.setFont(new Font("SansSerif", Font.PLAIN, 10));
        source.setPosition(RectangleEdge.BOTTOM);
        source.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        chart.addSubtitle(source);
        
        chart.setBackgroundPaint(Color.white);//背景色

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setRangeGridlinesVisible(false);//是否显示横轴线
        /*URL imageURL = LineChartDemo1.class.getClassLoader().getResource(
            "OnBridge11small.png");
        if (imageURL != null) {
            ImageIcon temp = new ImageIcon(imageURL);
            // 使用按钮因为它等待加载的图像...
            chart.setBackgroundImage(temp.getImage());
            plot.setBackgroundPaint(new Color(0, 0, 0, 0));            
        }*/
        // 自定义范围轴...
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());//数据轴的数据标签（可以只显示整数标签，需要将AutoTickUnitSelection设false）
        rangeAxis.setPositiveArrowVisible(true);//是否显示正向箭头（3D轴无效） 
        // customise the renderer...
        LineAndShapeRenderer renderer 
                = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseShapesVisible(true); // 点（即数据点）可见
        renderer.setDrawOutlines(true);//是否画图形边框 
        renderer.setUseFillPaint(true);//指定是否填充数据点的
        renderer.setBaseFillPaint(Color.white);//数据中心的颜色
        renderer.setSeriesStroke(0, new BasicStroke(3.0f));// 指定分类的图形边框的线条笔触
        renderer.setSeriesOutlineStroke(0, new BasicStroke(2.0f));// 指定分类的图形边框的线条笔触
        renderer.setSeriesShape(0, new Ellipse2D.Double(-5.0, -5.0, 10.0, 10.0));//指定分类图形的形状(如折线图的点)
        return chart;
    }
    
    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     * 
     * @return A panel.
     */
   private class LinePanel extends JPanel{
	   public LinePanel(JFreeChart chart){
		   this.setLayout(new BorderLayout());
		   ChartPanel chartPanel = new ChartPanel(chart);
		   this.add(chartPanel);
	   }
   }
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(String[] args) {
        new LineChartDemo1();
    }

}
