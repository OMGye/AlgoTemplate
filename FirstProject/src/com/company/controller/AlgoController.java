package com.company.controller;

import com.company.view.AlgoFrame;
import com.company.util.AlgoVisHelper;
import com.company.entity.Circle;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by upupgogogo on 2018/1/11.下午2:00
 */
public class AlgoController {

    private Circle[] circles;

    private AlgoFrame algoFrame;

    private boolean isAnimated = true;

    public AlgoController(int sceneWidth, int sceneHeight, int N, int R) {
        //初始化数据
        circles = new Circle[N];
        for (int i = 0; i < N; i++) {
            int x = (int) (Math.random() * (sceneWidth - 2 * R)) + R;
            int y = (int) (Math.random() * (sceneHeight - 2 * R)) + R;
            int vx = (int) (Math.random() * 11) - 5;
            int vy = (int) (Math.random() * 11) - 5;
            circles[i] = new Circle(x, y, vx, vy, R);
        }
        //初始化视图
        EventQueue.invokeLater(() -> {
            algoFrame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            algoFrame.addKeyListener(new AlgoKeyListener());
            algoFrame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }
    private void run(){
        while (true) {
            //绘制数据
            algoFrame.render(circles);
            AlgoVisHelper.pause();
            if(isAnimated){
            //更新数据
            for (Circle circle : circles) {
                circle.move(0, 0, algoFrame.getCanvasWidth(), algoFrame    .getCanvasHeight());
             }
            }
        }
    }
    private class AlgoKeyListener extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getKeyChar() == ' '){
                isAnimated = !isAnimated;
            }
        }
    }
    private class AlgoMouseListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
            e.translatePoint(0,-(algoFrame.getBounds().height-algoFrame.getCanvasHeight()));
            for (Circle circle : circles){
                if(circle.contain(e.getPoint())){
                    circle.isFilled = !circle.isFilled;
                }
            }
        }
    }

}