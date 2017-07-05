package com.lqlsoftware.SolarSystem.utils;


import java.awt.*;
import java.awt.event.*;

/**
 * Created by robinlu on 2017/7/3.
 */
public class GameFrame extends Frame {

    private Image offScreenImage;  //图形缓存

    protected int mouse_x, mouse_y;

    protected int mouse_dx, mouse_dy;

    public Image getOffScreenImage() {
        if(offScreenImage == null)
            return this.createImage(GameSetting.MAIN_WIDTH, GameSetting.MAIN_HEIGHT);
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

        addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                mouse_x = e.getX();
                mouse_y = e.getY();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                mouse_dx = mouse_x == 0 ? 0 : e.getX() - mouse_x;
                mouse_dy = mouse_y == 0 ? 0 : e.getY() - mouse_y;
                mouse_x = e.getX();
                mouse_y = e.getY();
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
