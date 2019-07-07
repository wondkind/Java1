package ru.geekbrains.lesson_e;

import java.util.Random;

public class Cat extends Animal{

    private Random RANDOM = new Random();

    public Cat(int age, String color, String name){
        super(age, color, name);
        runLenght = 100.0d + RANDOM.nextInt(100);
        jumpHeight = 2.0d + RANDOM.nextInt(1);
    }

    public void run(){
        System.out.println(name + " пробежала " + runLenght + " метров");
    }

    public void run(double runLenght){
        System.out.println(name + " пробежала " + (runLenght > this.runLenght ? this.runLenght + " метров и устала" : runLenght + " метров"));
    }

    public void jump(){
        System.out.println(name + " прыгнула " + jumpHeight + " метров");
    }

    public void jump(double jumpHeight){
        System.out.println(name + " прыгнула " + (jumpHeight > this.jumpHeight ? this.jumpHeight + " метров и устала" : jumpHeight + " метров"));
    }

    public void swim(){
        System.out.println(name + " не умеет плавать");
    }

    public void swim(double swim){
        System.out.println(name + " не умеет плавать");
    }

    @Override
    public void move(){
        System.out.println("Кошка начала медленно двигаться");
    }
}
