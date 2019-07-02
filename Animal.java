package ru.geekbrains.lesson_e;

public abstract class Animal {

    protected String name;
    protected int age;
    protected String color;
    protected double runLenght;
    protected double jumpHeight;


    protected Animal(int age, String color, String name){
        this.name = name;
        this.color = color;
        this.age = age;
        this.runLenght = 0;
        this.jumpHeight = 0;
    }

    protected Animal(){
        this.name = "Ktulhu";
        this.color = "Green";
        this.age = 1000000;
        this.runLenght = 1000000;
        this.jumpHeight = 1000000;
    }

    protected final String getName(){
        return name;
    }
    protected final String getColor(){
        return color;
    }
    protected final int getAge(){
        return age;
    }
    protected final double getRunLenght(){
        return runLenght;
    }
    protected final double getJumpHeight(){
        return jumpHeight;
    }
    protected final void setName(String name){
        this.name = name;
    }
    protected final void setColor(String color){
        this.color = color;
    }
    protected final void setAge(int age){
        this.age = age;
    }

    protected void move(){
        System.out.println("Животное начало двигаться");
    }

    protected abstract void run();
    protected abstract void jump();
    protected abstract void swim();

}
