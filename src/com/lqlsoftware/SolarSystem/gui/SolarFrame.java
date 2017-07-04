package com.lqlsoftware.SolarSystem.gui;

import com.lqlsoftware.SolarSystem.utils.GameFrame;
import com.lqlsoftware.SolarSystem.utils.GameUtil;

import java.awt.*;

/**
 * Created by robinlu on 2017/7/3.
 */
public class SolarFrame extends GameFrame {

    public void paint(Graphics g) {
        g.setFont(new Font("等线", 0, 100));
        g.drawString("FuckChat", 350, 230);
        g.setFont(new Font("等线", 0, 20));
        g.drawString("LqlSoftware", 470, 280);
        g.drawImage(GameUtil.getImage("images/fuckchat.png"), 100, 100, null);
    }

    public static void main(String[] argvs) {
        new SolarFrame().launchFrame();
    }
}
