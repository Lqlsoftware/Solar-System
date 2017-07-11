package com.lqlsoftware.SolarSystem.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by robinlu on 2017/7/3.
 */
public class GameUtil {

    // 私有构造方法
    private GameUtil() {}

    // 获取图片
    public static BufferedImage getImage(String path) {
        URL url = GameUtil.class.getClassLoader().getResource(path);
        BufferedImage bi = null;

        try {
            bi = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bi;
    }

    // 图片旋转
    public static BufferedImage rotateImage(BufferedImage bufferedimage, double degree)
    {
        int w = bufferedimage.getWidth();
        int h = bufferedimage.getHeight();
        int type = bufferedimage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(w, h, type)).createGraphics())
                .setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);
        graphics2d.drawImage(bufferedimage, 0, 0, null);
        graphics2d.dispose();
        return img;
    }

}
