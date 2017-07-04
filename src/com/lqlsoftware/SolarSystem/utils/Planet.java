package com.lqlsoftware.SolarSystem.utils;

import org.omg.CORBA.MARSHAL;

import java.awt.*;

/**
 * Created by robinlu on 2017/7/4.
 */
public class Planet extends Star {

    private double longAxis;

    private double shortAxis;

    private double speed;

    private Star center;

    double degree;

    protected double count;

    public Planet(String imagePath, int width, int height,
                  double longAxis, double shortAxis, double speed, Star center) {
        super(imagePath, width, height,
                center.getLocation_x() + longAxis, center.getLocation_y());
        this.longAxis = longAxis;
        this.shortAxis = shortAxis;
        this.speed = speed;
        this.center = center;
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
    }

    @Override
    public void drawBy(Graphics g) {
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
        location_x = center.getLocation_x() + center.getWidth() / 2 + longAxis * Math.cos(degree);
        location_y = center.getLocation_y() + center.getHeight() / 2 + shortAxis * Math.sin(degree);
        degree += speed;
    }
}
