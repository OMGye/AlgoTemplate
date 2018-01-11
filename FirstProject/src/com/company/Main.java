package com.company;

import com.company.controller.AlgoController;

import javax.swing.*;
import java.awt.*;

public class Main {


    public static void main(String[] args) {
         int sceneWidth = 600;
         int sceneHeight = 600;
         int N = 20;
         int R = 50;
        new AlgoController(sceneWidth,sceneHeight ,N,R);
    }
}
