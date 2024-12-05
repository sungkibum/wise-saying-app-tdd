package com.ll.domain.wiseSaying.controller;

import com.ll.domain.wiseSaying.entity.WiseSaying;
import com.ll.domain.wiseSaying.service.WiseSayingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private final Scanner sc;
    private final WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        this.wiseSayingService = new WiseSayingService();
    }

    public void actionAdd() {
        System.out.println("명언 : ");
        String content = sc.nextLine();
        System.out.println("작가 : ");
        String author = sc.nextLine();
        WiseSaying wiseSaying = wiseSayingService.add(content, author);

        System.out.println(wiseSaying.getId() + "번 명언이 등록되었습니다.");
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------");

        List<WiseSaying> wiseSayingList = wiseSayingService.list();

        for (WiseSaying wiseSaying : wiseSayingList) {
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());
        }
    }

    public void actionDelete(String cmd) {
        String[] cmdBits;
        int id;
        try {
            cmdBits = cmd.split("\\?");    //cmd 파라미터를 받아와서 ?를 기준으로 양옆으로 나눈 배열 생성
            id = Integer.parseInt(cmdBits[1].split("=")[1]);    // 양옆으로 나눈 배열 중 오른쪽 값을 =를 기준으로 다시 나누고 오른쪽 값을 받아옴(id 값)
        } catch (Exception e) {
            System.out.println("명령어를 잘못 입력하셨습니다.");
            return;
        }

        boolean remove = wiseSayingService.delete(id);
        if (remove) {
            System.out.println(id + "번 명언이 삭제되었습니다.");
            return;
        }
        System.out.println(id + "번 명언은 존재하지 않습니다.");
    }
}
