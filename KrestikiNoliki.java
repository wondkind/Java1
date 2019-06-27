package ru.geekbrains.lesson_c;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '_';

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static int fieldSizeY = 3;
    private static int fieldSizeX = 3;
    private static char[][] field;
    private static int seqVal = 3; //количество символов подряд для победы

    private static void initMap(){
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++){
            for (int x = 0; x < fieldSizeX; x++){
                field[y][x] = EMPTY_DOT;
            }
        }
    }

    private static void printMap(){
        for (int y = 0; y < fieldSizeY; y++){
            for (int x = 0; x < fieldSizeX; x++){
//                field[y][x] = EMPTY_DOT;
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
    }

    private static boolean isValidCell(int y, int x){
        return fieldSizeX > x && x >= 0 && fieldSizeY > y && y >= 0;
    }

    private static boolean isEmptyCell(int y, int x){
        return field[y][x] == EMPTY_DOT;
    }

    private static void humanTurn(){
        int x;
        int y;

        do {
            System.out.println("Введите координаты хода X (от 1 до " + fieldSizeX + ") и Y (от 1 до " + fieldSizeY + ") через пробел >>");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(y, x) || !isEmptyCell(y, x));

        field[y][x] = HUMAN_DOT;
    }

    private static void aiTurn(){
        int east = 0; //направление: если > 0 то вправо; если < 0 то влево
        int south = 0; //аналогично: > 0 вниз; < 0 вверх
        int x = 0;
        int y = 0;
        int cnt = 1;
        int dir;
        int preDir;
        char currDot;
        char enemyDot;
        boolean midVal = false;
        boolean condition;
        int midX = 0;
        int midY = 0;
        /*
            Либо пытается выиграть, либо блокировать. Что первое попадётся.
            Можно переделать чтобы либо побеждать вначале пытался, либо блокировать.
        */
        for (int i = 0; i < fieldSizeY; i++){
            for (int k = 0; k < fieldSizeX; k++){

                if (field[i][k] == EMPTY_DOT){
                    midVal = true;
                    midX = k;
                    midY = i;
                    currDot = EMPTY_DOT;
                }
                else {
                    currDot = field[i][k];
                }

                dir = 1;
                preDir = 0;

                while (dir < 5){
                    if (cnt == seqVal){

                        if (midVal){
                            field[midY][midX] = AI_DOT;
                            return;
                        }

                        cnt = 1;
                        dir++;
                        continue;

                    }

                    if (dir != preDir){
                        if (dir == 1){
                            south = 0;
                            east = 1;
                        } else if(dir == 2){
                            south = 1;
                            east = 1;
                        } else if(dir == 3){
                            south = 1;
                            east = 0;
                        } else {
                            south = 1;
                            east = -1;
                        }
                        if (field[i][k] == EMPTY_DOT) midVal = true;
                        else midVal = false;
                        cnt = 1;
                        preDir = dir;
                    }

                    x = k + cnt*east;
                    y = i + cnt*south;
                    condition = x < fieldSizeX && x >= 0 && y < fieldSizeY && y >= 0;


                    if(midVal && condition && field[y][x] != EMPTY_DOT && cnt == 1) {
                        currDot = field[y][x];
                        cnt++;
                        continue;

                    } else if (midVal && condition && field[y][x] == EMPTY_DOT && cnt == 1){

                        dir++;
                        continue;

                    }

                    if(condition && field[y][x] == currDot){
                        cnt++;
                        continue;
                    } else if (condition && field[y][x] == EMPTY_DOT && !midVal){
                        midVal = true;
                        midX = x;
                        midY = y;
                        cnt++;
                        continue;
                    }

                    dir++;

                }


            }
        }

        do{
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(y, x));

        field[y][x] = AI_DOT;
    }

    private static boolean checkWin(char c){

        int chWn = 0;
        int south = 0;
        int east = 0;
        int x;
        int y;
        int dir;
        int preDir;

        for (int i = 0; i < fieldSizeY; i++){
            for(int k = 0; k < fieldSizeX; k++){
                if (field[i][k] == c){

                    preDir = 0;
                    dir = 1;

                    while (dir < 5){

                        if (chWn == seqVal) return true;

                        if (dir != preDir){
                            if (dir == 1){
                                south = 0;
                                east = 1;
                            } else if(dir == 2){
                                south = 1;
                                east = 1;
                            } else if(dir == 3){
                                south = 1;
                                east = 0;
                            } else {
                                south = 1;
                                east = -1;
                            }
                            chWn = 1;
                            preDir = dir;
                        }

                        x = k + chWn*east;
                        y = i + chWn*south;

                        if(x < fieldSizeX && x >= 0
                                && y < fieldSizeY && y >= 0
                                && field[y][x] == c){
                            chWn++;
                            continue;
                        }

                        dir++;

                    }
                }
            }
        }

        return false;
    }

    private static boolean isMapFull(){
        for (int y = 0; y < fieldSizeY; y++){
            for (int x = 0; x < fieldSizeY; x++){
                if(field[y][x] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        while (true){
            initMap();
            printMap();

            while (true) {
                humanTurn();
                if(checkWin(HUMAN_DOT)){
                    System.out.println("Human win!");
                    break;
                }
                if (isMapFull()){
                    System.out.println("Draw!");
                    break;
                }
//                printMap();
                aiTurn();
                printMap();
                if(checkWin(AI_DOT)){
                    System.out.println("Computer win!");
                    break;
                }
                if (isMapFull()){
                    System.out.println("Draw!");
                    break;
                }
            }
            System.out.println("Хотите сыграть еще? (y/n)");
            if (SCANNER.next().equals("n")) break;
        }

    }
}
