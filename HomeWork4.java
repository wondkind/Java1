package ru.geekbrains.lesson_d;

public class HomeWork {
    public static void main(String[] args) {

        Employee[] workers = new Employee[5];

        workers[0] = new Employee("Ivan",
                "Ivanovich",
                "Ivanov",
                "+7(913)555-35-35",
                "Programmist");

        workers[1] = new Employee("Sidor",
                "Sidorovich",
                "Sidorov",
                "+7(923)555-35-35",
                "Director");

        workers[2] = new Employee("Petr",
                "Petrovich",
                "Petrov",
                "+7(933)555-35-35",
                "Marketolog");

        workers[3] = new Employee("Sergey",
                "Sergeevich",
                "Sergeev",
                "+7(943)555-35-35",
                "Programmist");

        workers[4] = new Employee("Aleksey",
                "Alekseevich",
                "Alekseev",
                "+7(953)555-35-35",
                "Testirovshik");

        for (int i = 0; i < workers.length; i++){
            if (workers[i].getAge() >= 40){
                System.out.println(workers[i].getThirdName() + " "
                        + workers[i].getFirstName() + " "
                        + workers[i].getSecondName() + " "
                        + "vozrast " + workers[i].getAge() + " "
                        + workers[i].getPost() + " "
                        + workers[i].getTelephone() + " " +
                        workers[i].getSalary());
            }

            if (workers[i].getSalary() >= 45){
                workers[i].addSalary(5000);
            }
        }

        System.out.println();

        for (int i = 0; i < workers.length; i++){
            System.out.println(workers[i].getThirdName() + " "
                    + workers[i].getFirstName() + " "
                    + workers[i].getSecondName() + " "
                    + "vozrast " + workers[i].getAge() + " "
                    + workers[i].getPost() + " "
                    + workers[i].getTelephone() + " " +
                    workers[i].getSalary() + " " +
                    workers[i].getId());
        }

    }
}
