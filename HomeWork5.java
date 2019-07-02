package ru.geekbrains.lesson_e;

public class HomeWork5 {
    public static void main(String[] args) {

        Dog doberman = new Dog(2, "черный", "Лилит");
        doberman.move();
        doberman.run(501);
        doberman.jump(0.5d);
        doberman.swim(5);
        System.out.println(doberman.getName() + " может пробежать " + doberman.getRunLenght() + " метров");

        Dog toyterror = new Dog(1, "черный", "Рики");
        System.out.println(toyterror.getName() + " может пробежать " + toyterror.getRunLenght() + " метров");

        Cat scotland = new Cat(9, "серый", "Милли");
        scotland.move();
        scotland.swim(5);
        System.out.println("Возраст кошки " + scotland.getAge() + " лет");

        Horse mustang = new Horse(7, "оранжевый", "Дымка");
        mustang.move();
        mustang.jump();
        System.out.println("Лошадь может прыгать " + mustang);

        Animal[] arrAnimal = {doberman, scotland, mustang};

        for (int i = 0; i < arrAnimal.length; i++){
            if (arrAnimal[i] instanceof Cat){
                System.out.println(arrAnimal[i].name + " не умеет плавать");
            } else {
                arrAnimal[i].swim();
            }
        }
    }
}
