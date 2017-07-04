package com.lqlsoftware.SolarSystem.utils;

import com.lqlsoftware.SolarSystem.utils.GameUtil;

import java.awt.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by robinlu on 2017/7/4.
 */
public class Star {

    protected Image img;

    protected double location_x, location_y;

    protected int width, height;

    protected boolean isDynamic;

    protected ConcurrentHashMap<Integer, Image> dynamicPhotoMap;

    protected Integer dynamicPhotoNum;

    protected Integer counter;

    // draw on graphics
    public void drawBy(Graphics g) {
        if (isDynamic) {
            img = dynamicPhotoMap.get(counter);
            g.drawImage(img, (int)location_x, (int)location_y, width, height, null);
            counter = counter == dynamicPhotoNum ? 1 : counter + 1;
        } else
            g.drawImage(img, (int)location_x, (int)location_y, width, height, null);
    }

    public Star (String imagePath, int width, int height, double location_x, double location_y) {
        isDynamic = false;
        img = GameUtil.getImage(imagePath);
        setWidth(width);
        setHeight(height);
        setLocation_x(location_x);
        setLocation_y(location_y);
    }

    public Star (String dynamicPhotoPath, int width, int height,
                 double location_x, double location_y,
                 Integer dynamicPhotoNum, Integer startFrom) {
        // 读取图片到map里
        dynamicPhotoMap = new ConcurrentHashMap<>();
        for (counter = 1;counter <= dynamicPhotoNum;counter++) {
            img = GameUtil.getImage(dynamicPhotoPath + (counter < 10 ? "0" + counter : counter) + ".png");
            dynamicPhotoMap.put(counter, img);
        }
        this.dynamicPhotoNum = dynamicPhotoNum;
        isDynamic = true;
        counter = startFrom;
        setWidth(width);
        setHeight(height);
        setLocation_x(location_x);
        setLocation_y(location_y);
    }

    // getter and setter

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getLocation_x() {
        return location_x;
    }

    public void setLocation_x(double location_x) {
        this.location_x = location_x;
    }

    public double getLocation_y() {
        return location_y;
    }

    public void setLocation_y(double location_y) {
        this.location_y = location_y;
    }

}
