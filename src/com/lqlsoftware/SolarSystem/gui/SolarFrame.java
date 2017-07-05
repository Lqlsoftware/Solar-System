package com.lqlsoftware.SolarSystem.gui;

import com.lqlsoftware.SolarSystem.utils.*;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by robinlu on 2017/7/3.
 */
public class SolarFrame extends GameFrame {

    BufferedImage background = GameUtil.getImage("images/background.jpg");
    double bgDegree = 0;

    Star Sun = new Star("images/Sun/", 100, 100,
            GameSetting.MAIN_WIDTH / 2, GameSetting.MAIN_HEIGHT / 2, 23, 1);

    Planet Earth = new Planet("images/Earth/", 40, 40,
            500, 220, 0.02, Sun, 86, 37);

    Planet Earth1 = new Planet("images/Earth/", 40, 40,
            400, 190, 0.018, Sun, 86, 37);

    Planet Earth2 = new Planet("images/Earth/", 40, 40,
            250, 150, 0.016, Sun, 86, 37);

    Planet Earth3 = new Planet("images/Earth/", 40, 40,
            200, 120, 0.01, Sun, 86, 37);

    public void paint(Graphics g) {
        g.drawImage(GameUtil.rotateImage(background, bgDegree),
                GameSetting.MAIN_WIDTH / 2 - 880, GameSetting.MAIN_HEIGHT / 2 - 540,
                1960, 1080, null);
        bgDegree += 0.05;
        bgDegree %= 360;

        Earth.drawTrace(g);
        Earth1.drawTrace(g);
        Earth2.drawTrace(g);
        Earth3.drawTrace(g);
        Earth1.drawBy(g, mouse_dx, mouse_dy);
        Earth2.drawBy(g, mouse_dx, mouse_dy);
        Earth3.drawBy(g, mouse_dx, mouse_dy);
        Earth.drawBy(g, mouse_dx, mouse_dy);
        mouse_dx = 0;
        mouse_dy = 0;
        Sun.drawBy(g);
    }

    public static void main(String[] args) {
        new SolarFrame().launchFrame();
    }
}
