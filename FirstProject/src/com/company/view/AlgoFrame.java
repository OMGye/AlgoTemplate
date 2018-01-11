package com.company.view;

import com.company.util.AlgoVisHelper;
import com.company.entity.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by upupgogogo on 2018/1/8.下午8:08
 */
public class AlgoFrame extends JFrame{

    private int canvasWidth;

    private int canvasHeight;

    public AlgoFrame(String title,int canvasWidth,int canvasHeight) {
       super(title);
       this.canvasWidth = canvasWidth;
       this.canvasHeight = canvasHeight;
       AlgoCanvas algoCanvas = new AlgoCanvas();
       algoCanvas.setPreferredSize(new Dimension(canvasWidth,canvasHeight));
       setContentPane(algoCanvas);
       pack();
       setResizable(false);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setVisible(true);
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    private Circle[] circles;
    public void render(Circle[] circles){
        this.circles = circles;
        this.repaint();
    }
    private class AlgoCanvas extends JPanel{

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponents(g);
            //g.drawOval(50,50,300,300);
            Graphics2D g2d = (Graphics2D)g;
            //抗锯齿
            RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                                                               RenderingHints.VALUE_ANTIALIAS_ON
                                                              );
            g2d.addRenderingHints(renderingHints);

            //具体绘制
            //AlgoVisHelper.setStrockWidth(g2d,10);
            g2d.setColor(Color.red);
            for (Circle circle :circles){
                if(circle.isFilled){
                    AlgoVisHelper.fillCircle(g2d,circle.x,circle.y,circle.getR());
                }
                AlgoVisHelper.drawCircle(g2d,circle.x,circle.y,circle.getR());
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth,canvasHeight);
        }
    }

}
