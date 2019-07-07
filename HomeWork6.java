package ru.geekbrains.lesson_f;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.*;

import java.util.Scanner;

public class HomeWork6 {

    public static void main(String[] args) {

        String fileName1 = "file1.txt";
        String fileName2 = "file2.txt";
        String finFileName = "final.txt";
        String catalogName = "C:\\Users\\Алексей\\IdeaProjects\\Stream190617";
        String[] arr = new String[1];
        String word = "Hello";

        try{
            createFile(fileName1, "Hello, my name is Jack. I'm a doctor. My last pacient said: wupupupu.\nИ просто текст для примера");
            createFile(fileName2, "Hi! My name is Jack too. But i'm a woodman. I cut trees. And they don't talking with me.\nИ еще немного текста");
            concatFiles(fileName1, fileName2, finFileName);

            if(findWordInFile(fileName1, "просто")){
                System.out.println("В файле найдено слово!");
            } else {
                System.out.println("В файле не найдено слово!");
            }

            if (findWordInCatalog(catalogName, word, arr)){
                System.out.println("Найдено слово " + word + " в файле " + arr[0]);
            } else {
                System.out.println("Слово не найдено в каталоге!");
            }


        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public static boolean findWordInCatalog(String catalogName, String word, String[] arr) throws IOException{

        File dir = new File(catalogName);
        if(dir.isDirectory()){

            for (File item:
                 dir.listFiles()) {
                if (item.isDirectory()){
                    if (findWordInCatalog(item.getAbsolutePath(), word, arr)) return true;
                } else if (item.canRead()){
                    if (findWordInFile(item.getAbsolutePath(), word)){
                        arr[0] = item.getAbsolutePath();
                        return true;
                    }
                }
            }

        } else if(dir.canRead()){
            if(findWordInFile(dir.getAbsolutePath(), word)){
                arr[0] = dir.getAbsolutePath();
                return true;
            }
        }

        return false;

    }

    public static boolean findWordInFile(String fileName, String word) throws IOException{
        Scanner topScan = new Scanner(new FileInputStream(fileName));
        String find = new String();

        while (topScan.hasNext()){
            find = topScan.findInLine(word);
            topScan.nextLine();
            if (find != null) return true;
        }

        topScan.close();
        return false;
    }

    public static void createFile(String fileName, String text) throws IOException{
        PrintStream ps1 = new PrintStream(new FileOutputStream(fileName));
        ps1.println(text);
    }

    public static void concatFiles(String fileName1, String fileName2, String outputFileName) throws IOException{

        PrintStream fin = new PrintStream(new FileOutputStream(outputFileName));

        String outStr = new String();
        Scanner topScan1 = new Scanner(new FileInputStream(fileName1));
        Scanner topScan2 = new Scanner(new FileInputStream(fileName2));

        while (topScan1.hasNext()){
            outStr = outStr + topScan1.nextLine() + "\n";
        }

        while (topScan2.hasNext()){
            outStr = outStr + topScan2.nextLine() + "\n";
        }

        fin.println(outStr);

        topScan1.close();
        topScan2.close();

    }

}
