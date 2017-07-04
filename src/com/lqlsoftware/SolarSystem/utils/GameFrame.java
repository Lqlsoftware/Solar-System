package com.lqlsoftware.SolarSystem.utils;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by robinlu on 2017/7/3.
 */
public class GameFrame extends Frame {

    private Image offScreenImage;  //图形缓存

    public Image getOffScreenImage() {
        if(offScreenImage == null)
            return this.createImage(800, 600);
        else
            return offScreenImage;
    }

    public void launchFrame() {
        setSize(GameSetting.MAIN_WIDTH, GameSetting.MAIN_HEIGHT);
        setLocation(GameSetting.LOCATION_X, GameSetting.LOCATION_Y);
        setVisible(true);


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        new PaintThread().run();
    }

    /*
     * 重画窗口线程内部类
     *
     */
    class PaintThread extends Thread {
         public void run(){
             while (true) {
                 repaint();
                 try {
                     Thread.sleep(10);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }
    }

    @Override
    public void update(Graphics g) {
        // 获取缓存区
        Image offScreen = getOffScreenImage();
        Graphics temp = offScreen.getGraphics();

        // 将内容输出到缓存区
        paint(temp);

        // 显示缓存区
        g.drawImage(offScreen, 0, 0, null);
    }
}
