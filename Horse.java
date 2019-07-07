package ru.geekbrains.lesson_e;

import java.util.Random;

public class Horse extends Animal{

    private Random RANDOM = new Random();
    public double swimLenght = 50.0d + RANDOM.nextInt(50);

    public Horse(int age, String color, String name){
        super(age, color, name);
        runLenght = 750.0d + RANDOM.nextInt(750);
        jumpHeight = 3.0d + RANDOM.nextInt(1);
    }

    public double getSwim(){
        return swimLenght;
    }

    public void run(){
        System.out.println(name + " проскакала " + runLenght + " метров");
    }

    public void run(double runLenght){
        System.out.println(name + " проскакала " + (runLenght > this.runLenght ? this.runLenght + " метров и устала" : runLenght + " метров"));
    }

    public void jump(){
        System.out.println(name + " прыгнула " + jumpHeight + " метров");
    }

    public void jump(double jumpHeight){
        System.out.println(name + " прыгнула " + (jumpHeight > this.jumpHeight ? this.jumpHeight + " метров и устала" : jumpHeight + " метров"));
    }

    public void swim(){
        System.out.println(name + " проплыла " + swimLenght + " метров");
    }

    public void swim(double swimLenght){
        System.out.println(name + " проплыла " + (swimLenght > this.swimLenght ? this.swimLenght + " метров и устала" : swimLenght + " метров"));
    }

    @Override
    public void move(){
        System.out.println("Лошадь начала скакать");
    }

}
