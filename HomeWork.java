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
            a[i] = i == 0 ? 1 : a[i - 1] + 3;
        }

    }
    //Задание 3
    private static void multiArr(int... a){

        for(int i = 0; i < a.length; i++)
        {
            a[i] *= a[i] < 6 ? 2 : 1;
        }

    }
    //Задание 4
    private static int minVal(int... a){

        int min = a[0];

        for (int i = 0; i < a.length; i++){
            min = min > a[i] ? a[i] : min;
        }

        return min;

    }
    private static int maxVal(int... a){

        int max = a[0];

        for (int i = 0; i < a.length; i++){
            max = max < a[i] ? a[i] : max;
        }

        return max;

    }
    //Задание 5
    private static void diagArr(int[][] a){

        for (int i = 0; i < a.length; i++){

            for (int k = 0; k < a[i].length; k++){
                a[i][k] = i == k ? 1 : 0;
            }

        }

    }
    //Задание 6
    private static boolean checkBalance(int... a){

        int sumLeft;
        int sumRight;

        for(int i = 0; i < a.length; i++){

            sumLeft = 0;
            sumRight = 0;

            for(int k = 0; k <= i; k++){
                sumLeft += a[k];
            }

            for(int l = i + 1; l < a.length; l++){
                sumRight += a[l];
            }

            if(sumLeft == sumRight){
                return true;
            }

        }

        return false;

    }
    private static void moveArr(int move, int... a){

        int reserveVal;

        for (int i = move; i != 0;){

            if (i > 0){

                reserveVal = a[a.length-1];

                for (int k = a.length-1; k > 0; k--){
                    a[k] = a[k-1];
                }

                a[0] = reserveVal;
                i--;

            } else {

                reserveVal = a[0];

                for (int k = 0; k < a.length-1; k++){
                    a[k] = a[k+1];
                }

                a[a.length-1] = reserveVal;
                i++;

            }
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
//        int[][] arr5 = new int[5][5];
//        diagArr(arr5);
//Задание 6
//        System.out.print(checkBalance(2,1,1,2,7));
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
