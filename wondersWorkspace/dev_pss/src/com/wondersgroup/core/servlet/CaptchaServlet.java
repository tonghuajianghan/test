package com.wondersgroup.core.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

import com.wondersgroup.core.constant.ConfigConstants;
import com.wondersgroup.core.constant.GlobalConstants;

/**
 * 生成图片验证码
 * 
 * @author SHI
 */
public class CaptchaServlet extends HttpServlet {

    private static final long serialVersionUID = -7590124316244221163L;

    /** 渲染配置 */
    private static Map<String, Map<String, String>> config = new HashMap<String, Map<String, String>>();

    /** 默认渲染配置 */
    private static Map<String, String> defaults = new HashMap<String, String>();

    /** 验证码类型：中文汉字 */
    private static final String CAPTCHA_TYPE_CHINESE = "chn";

    /** 验证码类型：字符串 */
    private static final String CAPTCHA_TYPE_STRING = "str";

    /** 验证码类型：算术题 */
    private static final String CAPTCHA_TYPE_MATH = "math";

    /** 默认验证码备选文字 */
    private static final String SEED_DEFAULT = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /** 默认验证码备选中文大写数字 */
    private static final String[] SEED_MATH = new String[] { "零", "壹", "贰", "叄", "肆", "伍", "陆", "柒", "捌", "玖" };

    /**
     * 初始化验证码Servlet
     */
    public void init() throws ServletException {
        // 防止绘图出错
        System.setProperty("java.awt.headless", "true");

        // 验证码配置项
        List<String> options = new ArrayList<String>();
        options.add("type"); // 类型
        options.add("seed"); // 备选文字
        options.add("size"); // 文字字数
        options.add("width"); // 图片宽度
        options.add("height"); // 图片高度
        options.add("font.size"); // 文字大小
        options.add("font.family"); // 文字字体
        options.add("noisy"); // 干扰效果
        options.add("noisy.spot"); // 干扰点数量
        options.add("noisy.line"); // 干扰线数量
        options.add("rot"); // 文字旋转角度

        // 读取默认配置
        for (String opt : options) {
            defaults.put(opt, ConfigConstants.getInstance().get("captcha." + opt));
        }

        // 读取预设配置
        for (String preset : ConfigConstants.getInstance().get("captcha.preset").split(",")) {
            config.put(preset, new HashMap<String, String>());
            config.get(preset).putAll(defaults);
            for (String opt : options) {
                String value = ConfigConstants.getInstance().get("captcha." + preset + "." + opt);
                if (value != null) {
                    config.get(preset).put(opt, value);
                }
            }
        }
    }

    /**
     * GET方式获取验证码
     * 
     * @param req
     * @param res
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession ssn = req.getSession();
        if (ssn != null) {
            res.setContentType("image/jpeg"); // 设置图像生成格式
            res.setHeader("Pragma", "No-cache"); // 设置响应头信息，禁用浏览器缓存
            res.setHeader("Cache-Control", "no-cache"); // 设置响应头信息，禁用浏览器缓存

            // 读取验证码选项，即预设配置
            // 如果选项为以逗号间隔的多个预设配置，将从中随机选取其一作为验证码渲染配置
            String preset = req.getParameter("preset");
            // 验证码选项为空，则获取默认选项
            preset = StringUtils.isBlank(preset) ? ConfigConstants.getInstance().get("captcha.default") : preset;

            // 根据验证码选项读取渲染配置
            Map<String, String> conf = defaults;
            if (StringUtils.isNotBlank(preset)) {
                // 预设配置不唯一则随机选取
                String[] mix = preset.split(",");
                preset = mix[(new Random()).nextInt(mix.length)];
                // 判断配置选项有效性
                if (config.containsKey(preset)) {
                    conf = config.get(preset);
                }
            }

            // 根据配置渲染验证码图片
            this.render(conf, ssn, res.getOutputStream());
        }
    }

    /**
     * 渲染验证码图片
     * 
     * @param conf
     * @param ssn
     * @param out
     * @throws IOException
     */
    private void render(Map<String, String> conf, HttpSession ssn, OutputStream out) throws IOException {
        // 验证码类型（中文汉字、字符串、算术题、常规）
        String type = conf.get("type");

        // 根据验证码类型选择不同渲染方式
        if (CAPTCHA_TYPE_CHINESE.equals(type)) {
            // 生成中文汉字验证码
            this.renderChinese(conf, ssn, out);
        } else if (CAPTCHA_TYPE_STRING.equals(type)) {
            // 生成字符串验证码
            this.renderStr(conf, ssn, out);
        } else if (CAPTCHA_TYPE_MATH.equals(type)) {
            // 生成算术题验证码
            this.renderMath(conf, ssn, out);
        } else {
            // 默认生成常规模式验证码，即从备选文字中随机选取指定位数字符串作为验证码文字
            // 备选文字
            String seed = conf.get("seed");
            // 备选文字为空，则选取默认值
            seed = StringUtils.isBlank(seed) ? SEED_DEFAULT : seed;
            // 验证码字数
            int size = Integer.valueOf(conf.get("size"));
            // 验证码文字
            String captcha = RandomStringUtils.random(size, seed);
            // 渲染验证码图片
            this.render(conf, captcha, captcha, ssn, out);
        }
    }

    /**
     * 渲染中文汉字验证码图片
     * 
     * @param conf
     * @param ssn
     * @param out
     * @throws IOException
     */
    private void renderChinese(Map<String, String> conf, HttpSession ssn, OutputStream out) throws IOException {
        // 中文汉字验证码
        String captcha = null;

        // 备选中文汉字
        String seed = conf.get("seed");

        // 验证码字数
        int size = Integer.valueOf(conf.get("size"));

        // 无备选中文汉字，则随机生成，否则从备选中随机获取
        if (StringUtils.isBlank(seed)) {
            captcha = this.randomChinese(size);
        } else {
            captcha = RandomStringUtils.random(size, seed);
        }

        // 渲染验证码图片
        this.render(conf, captcha, captcha, ssn, out);
    }

    /**
     * 渲染字符串验证码图片
     * 
     * @param conf
     * @param ssn
     * @param out
     * @throws IOException
     */
    private void renderStr(Map<String, String> conf, HttpSession ssn, OutputStream out) throws IOException {
        // 随机对象
        Random random = new Random();

        // 字符串验证码
        String captcha = "";

        // 备选字符串，以逗号分隔
        String[] seed = conf.get("seed").split(",");

        // 从备选字符串中随机选取验证码文字
        if (seed.length >= 1) {
            captcha = seed[random.nextInt(seed.length)];
        }

        // 渲染验证码图片
        this.render(conf, captcha, captcha, ssn, out);
    }

    /**
     * 渲染算术题验证码图片
     * 
     * @param conf
     * @param ssn
     * @param out
     * @throws IOException
     */
    private void renderMath(Map<String, String> conf, HttpSession ssn, OutputStream out) throws IOException {
        // 随机对象
        Random random = new Random();

        // 算术题内容文字
        StringBuilder words = new StringBuilder();
        // 算术题验证码（运算结果）
        int captcha = 0;
        // 算术题操作数
        int a, b;

        // 备选中文大写数字，以逗号分隔
        List<String> seed = StringUtils.isBlank(conf.get("seed")) ? new ArrayList<String>() : Arrays.asList(conf.get("seed").split(","));

        // 备选数字为空，则选取默认值
        if (seed.isEmpty()) {
            seed = Arrays.asList(SEED_MATH);
        }

        // 根据备选数字随机生成运算操作数
        int limit = seed.size();
        a = random.nextInt(limit);
        b = random.nextInt(limit);

        // 拼接算术题内容文字并求值

        words.append(seed.get(a));

        switch (random.nextInt(3)) {
        case 0:
            words.append("加");
            captcha = a + b;
            break;
        case 1:
            words.append("减");
            captcha = a - b;
            break;
        case 2:
            words.append("乘");
            captcha = a * b;
            break;
        }

        words.append(seed.get(b)).append("等于");

        // 渲染验证码图片
        this.render(conf, words.toString(), String.valueOf(captcha), ssn, out);
    }

    /**
     * 渲染验证码图片
     * 
     * @param conf 渲染配置
     * @param words 图片文字
     * @param captcha 验证码
     * @param ssn 会话对象
     * @param out 输出流对象
     * @throws IOException
     */
    private void render(Map<String, String> conf, String words, String captcha, HttpSession ssn, OutputStream out) throws IOException {
        // 随机对象
        Random random = new Random();
        // 验证码文字字数
        int size = words.length();
        // 验证码图片宽度
        int width = Integer.valueOf(conf.get("width"));
        // 验证码图片高度
        int height = Integer.valueOf(conf.get("height"));
        // 验证码文字大小
        int fontSize = Integer.valueOf(conf.get("font.size"));
        // 验证码文字字体
        String fontFamily = conf.get("font.family");

        // 验证码文字最大横向偏移量
        int offsetX = Math.max(1, width - fontSize * size);
        // 验证码文字最大纵向偏移量
        int offsetY = Math.max(1, (height - fontSize) / 2);
        // 验证码文字最大旋转角度
        int radians = Integer.valueOf(conf.get("rot"));
        // 验证码当前文字初始横向偏移
        int position = 0;

        // 创建图像
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 获取绘图对象
        Graphics2D g2d = (Graphics2D) bi.getGraphics();

        // 绘制图像背景
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, width, height);

        // 设置字体
        g2d.setFont(new Font(fontFamily, Font.BOLD, fontSize));

        // 根据验证码文字最大横向偏移量，随机分配文字间隔
        List<Integer> spacing = new ArrayList<Integer>();
        // 将允许的最大横向偏移空间随机分割为“文字字数+1”段
        for (int i = 0; i < size; i++) {
            int offset = random.nextInt(offsetX);
            spacing.add(offset);
            offsetX -= offset;
        }
        spacing.add(offsetX);

        // 循环绘制验证码文字
        for (int i = 0; i < size; i++) {
            // 随机纵向偏移
            int y = Math.min(height, fontSize) + random.nextInt(offsetY);

            // 随机获取文字横向间隔
            int s = random.nextInt(spacing.size());

            // 随机横向偏移
            int x = position + spacing.get(s);

            // 更新下一文字初始横向偏移
            position = x + Math.min(width / size, fontSize);

            // 更新剩余文字允许的横向间隔
            spacing.remove(s);

            // 随机生成字体颜色
            g2d.setColor(this.randomColor(180));
            // 随机旋转角度
            double rot = radians == 0 ? 0 : Math.toRadians(random.nextInt(radians));
            // 随机旋转方向
            rot = random.nextInt(2) == 0 ? rot : -rot;
            // 旋转图像
            g2d.rotate(rot, x, y);
            // 绘制验证码文字
            g2d.drawString(words.substring(i, i + 1), x, y);
            // 恢复图像
            g2d.rotate(-rot, x, y);
        }

        // 验证码图片干扰效果
        String noisy = conf.get("noisy");

        // 验证码图片包含干扰点
        if (noisy.contains("spot")) {
            // 验证码图片干扰点数量
            int spot = conf.containsKey("noisy.spot") ? Integer.valueOf(conf.get("noisy.spot")) : 0;

            // 循环绘制干扰点
            for (int i = 0; i < spot; i++) {
                // 设置随机颜色
                g2d.setColor(this.randomColor(255));
                // 在随机位置绘制干扰点
                g2d.drawOval(random.nextInt(width), random.nextInt(height), 0, 0);
            }
        }

        // 验证码图片包含干扰线
        if (noisy.contains("line")) {
            // 验证码图片干扰线数量
            int line = conf.containsKey("noisy.line") ? Integer.valueOf(conf.get("noisy.line")) : 0;

            // 循环绘制干扰线
            for (int i = 0; i < line; i++) {
                // 设置随机颜色
                g2d.setColor(this.randomColor(180));
                // 在随机位置绘制干扰线
                g2d.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
            }
        }

        // 释放绘图资源
        g2d.dispose();

        // 将验证码图片输出至页面
        ImageIO.write(bi, "jpg", out);

        // 将验证码信息保存至当前会话
        ssn.setAttribute(GlobalConstants.SESSION_CAPTCHA_IMG, captcha);
    }

    /**
     * 随机生成颜色
     * 
     * @param r
     * @return
     */
    private Color randomColor(int r) {
        // 随机对象
        Random random = new Random();

        // 返回随机生成的颜色对象
        return new Color(random.nextInt(r), random.nextInt(r), random.nextInt(r));
    }

    /**
     * 随机生成中文汉字
     * 
     * @param size
     * @return
     * @throws UnsupportedEncodingException
     */
    private String randomChinese(int size) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();

        // 循环生成随机中文汉字
        for (int i = 0; i < size; i++) {
            // 随机对象
            Random random = new Random(new Random().nextInt(10000));

            // 双字节数组
            byte[] b = new byte[2];
            b[0] = (new Integer(176 + Math.abs(random.nextInt(39)))).byteValue();
            b[1] = (new Integer(161 + Math.abs(random.nextInt(93)))).byteValue();

            // 将双字节数组转为汉字
            sb.append(new String(b, "GB2312"));
        }

        // 返回中文字符串
        return sb.toString();
    }
}