package team.hulu.cms.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 验证码工具类
 *
 * @author yurizhang
 * @date 2020/6/23 18:24
 */
public class CaptchaUtils {
    /**
     * 验证码宽度
     */
    private static final Integer CAPTCHA_WIDTH = 100;
    /**
     * 验证码高度
     */
    private static final Integer CAPTCHA_HEIGHT = 30;
    /**
     * 干扰线和噪点的数量
     */
    private static final Integer NOISE_NUMBER = 10;
    /**
     * random对象
     */
    private static final Random random = new Random();

    /**
     * 生成验证码图片
     *
     * @param captchaCode
     * @return
     */
    public static BufferedImage genCaptchaImage(String captchaCode) {
        //1.先构建一个画板对象--内存中的画板对象，最后需要借助响应流写出到客户端
        BufferedImage bufferedImage = new BufferedImage(CAPTCHA_WIDTH, CAPTCHA_HEIGHT, BufferedImage.TYPE_INT_RGB);
        //2.获取画笔对象
        Graphics graphics = bufferedImage.getGraphics();
        //设置画笔的颜色
        graphics.setColor(randomColor());
        //填充背景色
        graphics.drawRect(0, 0, CAPTCHA_WIDTH, CAPTCHA_HEIGHT);
        //3.绘制字符串
        //设置画笔颜色
        graphics.setColor(randomColor());
        //设置字体
        graphics.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        //将字符串画上去
        graphics.drawString(captchaCode, 20, 20);
        //4.绘制噪音线和噪音点
        for (int i = 1; i <= NOISE_NUMBER; i++) {
            graphics.setColor(randomColor());
            graphics.drawLine(random.nextInt(CAPTCHA_WIDTH), random.nextInt(CAPTCHA_HEIGHT), random.nextInt(CAPTCHA_WIDTH), random.nextInt(CAPTCHA_HEIGHT));
        }
        return bufferedImage;
    }

    /**
     * 生成随机的颜色
     *
     * @return
     */
    public static Color randomColor(){
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
}
