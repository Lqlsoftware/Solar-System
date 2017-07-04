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
    public static Image getImage(String path) {
        URL url = GameUtil.class.getClassLoader().getResource(path);
        BufferedImage bi = null;

        try {
            bi = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bi;
    }

}
