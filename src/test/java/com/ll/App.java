package com.ll;

import com.ll.domain.system.controller.SystemController;
import com.ll.domain.wiseSaying.controller.WiseSayingController;
import org.example.ll.Command;

import java.util.Scanner;

public class App {
    private final Scanner sc;
    private final SystemController systemController;
    private final WiseSayingController wiseSayingController;
    public App(Scanner sc) {
        this.sc = sc;
        this.systemController = new SystemController();
        this.wiseSayingController = new WiseSayingController(sc);
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            Command command = new Command(cmd);     //양 옆으로 나눈 배열 중 왼쪽(배열에서 0번 인덱스) actionName에 대입(삭제)
            if ("종료".equals(command.getActionName())) {
                systemController.actionExit();
                break;
            } else if ("등록".equals(command.getActionName())) {
                wiseSayingController.actionAdd();
            } else if ("목록".equals(command.getActionName())) {
                wiseSayingController.actionList();
            } else if("삭제".equals(command.getActionName())) {
                wiseSayingController.actionDelete(cmd);
            }
        }
        System.out.print("명령) ");
    }
}
