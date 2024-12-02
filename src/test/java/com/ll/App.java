package com.ll;

import com.ll.domain.system.controller.SystemController;

import java.util.Scanner;

public class App {
    private final Scanner sc;
    private final SystemController systemController;
    public App(Scanner sc) {
        this.sc = sc;
        this.systemController = new SystemController();
    }

    public void run() {

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if ("종료".equals(cmd)) {
                systemController.actionExit();
                break;
            }
        }
        System.out.print("명령) ");
    }
}
