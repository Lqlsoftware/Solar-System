package com.lqlsoftware.SolarSystem.utils;

import java.awt.*;

/**
 * Created by robinlu on 2017/7/4.
 */
public class Planet extends Star {

    private double longAxis;

    private double shortAxis;

    private double speed;

    private Star center;

    double xdegree, ydegree;

    protected double count;

    public Planet(String imagePath, int width, int height,
                  double longAxis, double shortAxis, double speed, Star center) {
        super(imagePath, width, height,
                center.getLocation_x() + longAxis, center.getLocation_y());
        this.longAxis = longAxis;
        this.shortAxis = shortAxis;
        this.speed = speed;
        this.center = center;
        this.ydegree = Math.PI / 2;
    }

    public Planet(String dynamicPhotoPath, int width, int height,
                  double longAxis, double shortAxis, double speed, Star center,
                  Integer dynamicPhotoNum, Integer startFrom) {
        super(dynamicPhotoPath, width, height,
                center.getLocation_x() + longAxis, center.getLocation_y(),
                dynamicPhotoNum, startFrom);
        this.longAxis = longAxis;
        this.shortAxis = shortAxis;
        this.speed = speed;
        this.center = center;
        this.ydegree = Math.PI / 2;
    }

    public void drawBy(Graphics g, int mouse_dx, int mouse_dy) {
        if (isDynamic) {
            img = dynamicPhotoMap.get(counter);
            g.drawImage(img, (int)location_x, (int)location_y, width, height, null);
            if ((int)count == 1) {
                counter = counter == dynamicPhotoNum ? 1 : counter + 1;
                count -= 1;
            }
            count = count + dynamicPhotoNum / 2 / Math.PI * speed;
        } else
            g.drawImage(img, (int)location_x, (int)location_y, width, height, null);

        move(mouse_dx, mouse_dy);
    }

    public void drawTrace(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.white);
        g.drawOval((int)(center.getLocation_x() + center.getWidth() / 2 - longAxis),
                (int)(center.getLocation_y() + center.getHeight() / 2 - shortAxis * Math.abs(Math.sin(ydegree))),
                (int)(2 * longAxis), (int)(2 * shortAxis * Math.abs(Math.sin(ydegree))));
        g.setColor(color);
    }

    public void move(int mouse_dx, int mouse_dy) {
        ydegree = ydegree + mouse_dy * Math.PI / GameSetting.MAIN_HEIGHT;
        location_x = center.getLocation_x() + center.getWidth() / 2 + longAxis * Math.cos(xdegree) - this.getWidth() / 2;
        location_y = center.getLocation_y() + center.getHeight() / 2 + shortAxis * Math.sin(xdegree) * Math.sin(ydegree) - this.getHeight() / 2;
        xdegree += speed;
    }
}
