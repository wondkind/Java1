package ru.geekbrains.lesson_d;


import java.util.Random;

public class Employee {

    Random RANDOM = new Random();

    String firstName = new String();
    String secondName = new String();
    String thirdName = new String();
    String telephone = new String();
    String post = new String(); //не знаю как должность по-английски
    static int counterID = 1; //статическая переменная для формирования УИДа
    int id; //уникальный порядковый номер
    private int salary;
    int age;

    Employee(String firstName, String secondName, String thirdName, String telephone, String post) {
        salary = RANDOM.nextInt(20000) + 18000;
        age = RANDOM.nextInt(42) + 18;
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.telephone = telephone;
        this.post = post;
        id = counterID;
        counterID++;
    }

    void setSalary(int salary){
        this.salary = salary;
    }

    void addSalary(int addingSalary){
        this.salary = this.salary + 5000;
    }

    String getFirstName(){
        return firstName;
    }

    String getSecondName(){
        return secondName;
    }

    String getThirdName(){
        return thirdName;
    }

    String getTelephone(){
        return telephone;
    }

    int getId(){
        return id;
    }

    int getSalary(){
        return salary;
    }

    int getAge(){
        return age;
    }

    String getPost(){
        return post;
    }

}
