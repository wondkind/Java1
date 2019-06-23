package ru.geekbrains.lesson_b;

public class HomeWork {
    //Задание 1
    private static void invertArr(int... a){

        for (int i = 0; i < a.length; i++){
            a[i] = a[i] == 0 ? 1 : 0;
        }

    }
    //Задание 2
    private static void initArr(int... a){

        for(int i = 0; i < a.length; i++){

            if(i != 0){
                a[i] = a[i-1] + 3;
            } else {
                a[i] = 1;
            }
        }

    }
    //Задание 3
    private static void multiArr(int... a){

        for(int i = 0; i < a.length; i++)
        {
            if (a[i] < 6){
                a[i] *= 2;
            }
        }

    }
    //Задание 4
    private static int minVal(int... a){

        int min = a[0];

        for (int i = 1; i < a.length; i++){
            if (min > a[i]){
                min = a[i];
            }
        }

        return min;

    }
    private static int maxVal(int... a){

        int max = a[0];

        for (int i = 1; i < a.length; i++){
            if (max < a[i]){
                max = a[i];
            }
        }

        return max;

    }
    //Задание 5
    private static void diagArr(int[][] a){

        for (int i = 0; i < a.length; i++){

            for (int k = 0; k < a[i].length; k++){
                if (i == k || (k == a.length - 1 - i)) {
                    a[i][k] = 1;
                } else {
                    a[i][k] = 0;
                }
            }
        }

    }
    //Задание 6
    private static boolean checkBalance(int... a){

        int sumLeft = 0;
        int sumRight = 0;

        for (int k = 0; k < a.length; k++){
            sumRight += a[k];
        }

        for(int i = 0; i < a.length; i++){

            sumLeft += a[i];
            sumRight -= a[i];

            if(sumLeft == sumRight){
                return true;
            }

        }

        return false;

    }
    private static void moveArr(int move, int... a){

        int reserveVal;
        int multi;
        int indx;
        int indxRes;

        if (move > 0){
            multi = -1;
            indxRes = a.length - 1;
            indx = 0;
        } else {
            multi = 1;
            indxRes = 0;
            indx = a.length - 1;
        }

        for (int i = move; i != 0;){

            reserveVal = a[indxRes];

            for (int k = indxRes; k != indx; k += multi){
                a[k] = a[k + multi];
            }

            a[indx] = reserveVal;
            i += multi;

        }

    }
    public static void main(String[] args) {
//Задание 1
//        int[] arr = new int[5];
//        for (int i = 0; i < arr.length; i++){
//            if(i % 2 == 0){
//                arr[i] = 1;
//            } else {
//                arr[i] = 0;
//            }
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//        invertArr(arr);
//Задание 2
//        int[] arr2 = new int[8];
//        initArr(arr2);
//Задание 3
//        multiArr(1,5,3,2,11,4,5,2,4,8,9,1);
//Задание 4
//        System.out.println(minVal(3,7,3,2,9,13,8,7));
//        System.out.println(maxVal(1,7,3,2,9,13,8,7));
//Задание 5
//        int[][] arr5 = new int[7][7];
//        diagArr(arr5);
//Задание 6
//        System.out.print(checkBalance(2,1,1,2,15));
//Задание 7-8
//        int[] arr8 = new int[5];
//        for (int i = 0; i < arr8.length; i++){
//            arr8[i] = i;
//        }
//        for (int cnt:
//                arr8) {
//            System.out.print(cnt + " ");
//        }
//        System.out.println();
//        moveArr(-2, arr8);
//        for (int cnt:
//                arr8) {
//            System.out.print(cnt + " ");
//        }
    }
}