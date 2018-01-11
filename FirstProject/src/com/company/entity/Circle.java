package com.company.entity;

/**
 * Created by upupgogogo on 2018/1/9.下午4:34
 */
public class Circle {
    private int r;
    public int x;
    public int y;
    public int vx;
    public int vy;

    public Circle(int x, int y, int vx, int vy,int r) {
        this.r = r;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public int getR() {
        return r;
    }
    public void move(int minx,int miny,int maxx,int maxy){
        x+=vx;
        y+=vy;
        checkCollision(minx,miny,maxx,maxy);
    }
    private void checkCollision(int minx,int miny,int maxx,int maxy){
        if(x-r<0){x = r; vx = -vx;}
        if(y-r<0){y = r; vy = -vy;}
        if(x+r>maxx){x = maxx-r; vx = -vx;}
        if(y+r>maxy){y = maxy-r; vy = -vy;}
    }
}
