package ru.geekbrains.lesson_g;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {

    private static final int WIN_WIDTH = 507; //впринципе, можно получать из GameWindow
    public static final int GM_HVA = 0;
    public static final int GM_HVH = 1;
    public int cellSize;
    public int linesCount;

    Map(){
//        setBackground(Color.BLACK);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength){
        cellSize = WIN_WIDTH / fieldSizeX;
        linesCount = fieldSizeX;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i <= linesCount; i++){
            g.drawLine(0, i * cellSize, WIN_WIDTH, i * cellSize);
            g.drawLine(i * cellSize, 0, i * cellSize, WIN_WIDTH);
        }
    }
}
