package org.example.ll;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        lab1();
//        lab2();
//        lab3();
        lab4();
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
    private static void lab3() {
        System.out.println("안녕하세요.");
    }
    private static void lab4() {
        System.out.println("== 시작 ==");

        //출력이 모니터로 안되도록 설정
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        System.out.println("안녕하세요.");   //안녕하세요는 output안에 쌓임

        //다시 모니터로 출력되도록 설정
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

        System.out.println("== 끝 ==");

        System.out.println("출력 : " + output.toString());

        //output 자원 해제
        try {
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}