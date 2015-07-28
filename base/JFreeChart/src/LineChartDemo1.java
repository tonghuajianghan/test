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
        this.setTitle("����ͼ");
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
        Dataset.addValue(212, "����", "�Է�");
        Dataset.addValue(504, "����", "˯��");
        Dataset.addValue(1520, "����", "ѧϰ");
        Dataset.addValue(5842, "����", "������ҵ");
        Dataset.addValue(2991, "����", "����");
        
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
    	//���ñ�����ʽ
    	chartTheme.setExtraLargeFont(new Font("����",Font.BOLD,20));
    	//�����������ʽ
    	chartTheme.setLargeFont(new Font("����", Font.BOLD, 14));
    	//����ͼ����ʽ
    	chartTheme.setRegularFont(new Font("����", Font.BOLD, 12));
    	chartTheme.setSmallFont(new Font("����", Font.BOLD, 10));
        ChartFactory.setChartTheme(chartTheme);
    	JFreeChart chart = ChartFactory.createLineChart(
            "ʱ�䰲��",   // ͼ�����
            null,                       // �����ǩ
            "����ʱ��",                   // ��λ���ǩ
            data,                         // ����
            PlotOrientation.VERTICAL,        //  ��λ,����;����
            true,                           // �Ƿ���ʾͼ�������ڼ򵥵�ͼ����False
            true,                            // tooltips
            false                            // urls
        );

        chart.addSubtitle(new TextTitle("һ������"));
        TextTitle source = new TextTitle(
            "Source: Java In A Nutshell (5th Edition) " 
            + "by David Flanagan (O'Reilly)"
        );
        source.setFont(new Font("SansSerif", Font.PLAIN, 10));
        source.setPosition(RectangleEdge.BOTTOM);
        source.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        chart.addSubtitle(source);
        
        chart.setBackgroundPaint(Color.white);//����ɫ

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setRangeGridlinesVisible(false);//�Ƿ���ʾ������
        /*URL imageURL = LineChartDemo1.class.getClassLoader().getResource(
            "OnBridge11small.png");
        if (imageURL != null) {
            ImageIcon temp = new ImageIcon(imageURL);
            // ʹ�ð�ť��Ϊ���ȴ����ص�ͼ��...
            chart.setBackgroundImage(temp.getImage());
            plot.setBackgroundPaint(new Color(0, 0, 0, 0));            
        }*/
        // �Զ��巶Χ��...
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());//����������ݱ�ǩ������ֻ��ʾ������ǩ����Ҫ��AutoTickUnitSelection��false��
        rangeAxis.setPositiveArrowVisible(true);//�Ƿ���ʾ�����ͷ��3D����Ч�� 
        // customise the renderer...
        LineAndShapeRenderer renderer 
                = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseShapesVisible(true); // �㣨�����ݵ㣩�ɼ�
        renderer.setDrawOutlines(true);//�Ƿ�ͼ�α߿� 
        renderer.setUseFillPaint(true);//ָ���Ƿ�������ݵ��
        renderer.setBaseFillPaint(Color.white);//�������ĵ���ɫ
        renderer.setSeriesStroke(0, new BasicStroke(3.0f));// ָ�������ͼ�α߿�������ʴ�
        renderer.setSeriesOutlineStroke(0, new BasicStroke(2.0f));// ָ�������ͼ�α߿�������ʴ�
        renderer.setSeriesShape(0, new Ellipse2D.Double(-5.0, -5.0, 10.0, 10.0));//ָ������ͼ�ε���״(������ͼ�ĵ�)
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
