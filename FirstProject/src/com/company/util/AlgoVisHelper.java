package com.company.util;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by upupgogogo on 2018/1/9.下午2:54
 */
public class AlgoVisHelper {
    private AlgoVisHelper(){

    }
    /**
     * @param g2d
     * @param width
     * */
    public static void setStrockWidth(Graphics2D g2d,int width){
        int strokWidyh = width;
        g2d.setStroke(new BasicStroke(width,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
    }
    /**
     * @param g2d
     * @param x
     * @param y
     * @param r
     * */
    public static void drawCircle(Graphics2D g2d , int x , int y , int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r,y-r,2*r,2*r);
        g2d.draw(circle);
    }
    public static void fillCircle(Graphics2D g2d , int x , int y , int r){
        Ellipse2D circle = new Ellipse2D.Double(x-r,y-r,2*r,2*r);
        g2d.fill(circle);
    }
    public static void pause(){
        try {
            Thread.sleep(20);
        }catch (Exception ex){
            System.out.println();
        }


    }
}
