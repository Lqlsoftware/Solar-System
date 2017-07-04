package com.lqlsoftware.SolarSystem.utils;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by robinlu on 2017/7/3.
 */
public class GameFrame extends Frame {

    public void launchFrame() {
        setSize(GameSetting.MAIN_WIDTH, GameSetting.MAIN_HEIGHT);
        setLocation(GameSetting.LOCATION_X, GameSetting.LOCATION_Y);
        setVisible(true);

        new PaintThread().run();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
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
                     Thread.sleep(50);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
         }
    }
}
