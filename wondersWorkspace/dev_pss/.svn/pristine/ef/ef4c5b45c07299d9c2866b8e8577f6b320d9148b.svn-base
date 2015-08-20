package com.wondersgroup.core.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * @author shichenyue
 * @水印工具类
 */
public class WatermarkUtil {
    public static class Setting {
        private int height;

        private int width;

        private int textSize;

        private int serialSize;

        private int column;

        private int row;

        private String serial;

        private Color color;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getTextSize() {
            return textSize;
        }

        public void setTextSize(int textSize) {
            this.textSize = textSize;
        }

        public int getSerialSize() {
            return serialSize;
        }

        public void setSerialSize(int serialSize) {
            this.serialSize = serialSize;
        }

        public int getColumn() {
            return column;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public String getSerial() {
            return serial;
        }

        public void setSerial(String serial) {
            this.serial = serial;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }

    /**
     * 生成水印图片
     * 
     * @param file 生成图片名
     * @param path 生成图片路径
     * @param text 图片水印文字
     * @param custom 水印个性化设置
     * @return
     */
    public static boolean create(String file, String path, String text, Setting custom) {
        // 默认水印设置
        Setting setting = new Setting();
        setting.setWidth(640);
        setting.setHeight(1000);
        setting.setTextSize(62);
        setting.setSerialSize(26);
        setting.setRow(3);
        setting.setColumn(2);
        setting.setColor(Color.GRAY);
        setting.setSerial(DateUtil.date2String(new Date(System.currentTimeMillis()), "yyyyMMddHHmmss"));

        try {
            // 个性化水印设置
            if (custom != null) {
                FormUtil.copyProperties(setting, custom);
            }

            // 序列号尺寸
            int serialSize = setting.getSerialSize();
            // 水印文字尺寸
            int textSize = setting.getTextSize();
            // 水印图片宽度
            int width = setting.getWidth();
            // 水印图片高度
            int height = setting.getHeight();
            // 水印文字行数
            int row = setting.getRow();
            // 水印文字列数
            int column = setting.getColumn();
            // 水印序列号
            String serial = setting.getSerial();
            // 水印文字底色
            Color color = setting.getColor();

            int spacing = 1;
            float alpha = 0.3f;
            Font textFont = new Font("隶书", Font.BOLD, textSize);
            Font serialFont = new Font("times new roman", Font.BOLD, serialSize);
            double perRotate = -Math.PI / 5;
            double perRotate2 = 2 * Math.PI + Math.PI / 5;
            int delta = (textSize * text.getBytes().length - serialSize * serial.getBytes().length) / 4;

            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();

            g.setBackground(Color.WHITE);
            g.clearRect(0, 0, width, height);

            for (int i = 0; i < row; i++) {
                int ty = 250 + i * height / row;
                for (int j = 0; j < column; j++) {
                    int tx = 70 + j * width / column;

                    g.translate(tx, ty);
                    g.rotate(perRotate);
                    g.setColor(color);
                    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
                    g.setFont(textFont);
                    g.drawString(text, 0, 0);
                    g.setFont(serialFont);
                    g.drawString(serial, delta, serialSize + spacing);
                    g.rotate(perRotate2);
                    g.translate(-tx, -ty);
                }
            }

            g.dispose();

            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File pic = new File(path + File.separator + file + ".jpg");
            if (!pic.exists()) {
                pic.createNewFile();
            }

            FileOutputStream out = new FileOutputStream(pic);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            encoder.encode(image);
            out.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    /**
     * 根据默认设置生成水印图片
     * 
     * @param file
     * @param path
     * @param text
     * @return
     */
    public static boolean create(String file, String path, String text) {
        return create(file, path, text, null);
    }
}
