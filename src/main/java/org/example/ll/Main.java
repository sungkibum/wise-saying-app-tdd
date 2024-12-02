package org.example.ll;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        lab1();
        lab2();
    }



    private static void lab1() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("명령) ");
        String cmd = scanner.nextLine().trim();

        System.out.println("입력한 명령: " + cmd);
    }

    private static void lab2() {
        InputStream inputStream = new ByteArrayInputStream("명령".getBytes());    //선입력 '명령' 받아옴
        Scanner scanner = new Scanner(inputStream); //선입력 '명령' 바로 대입
        System.out.print("명령) ");
        String cmd = scanner.nextLine().trim();

        System.out.println("입력한 명령: " + cmd);
    }
}