package com.ll.domain.wiseSaying.controller;

import com.ll.domain.wiseSaying.entity.WiseSaying;
import com.ll.domain.wiseSaying.service.WiseSayingService;
import org.example.ll.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public void actionDelete(Command cmd) {
        int id = cmd.getParamAsInt("id", 0);
        if (id == 0) {
            System.out.println("id(숫자)를 입력해주세요.");
            return;
        }

        boolean remove = wiseSayingService.delete(id);
        if (remove) {
            System.out.println(id + "번 명언이 삭제되었습니다.");
            return;
        }
        System.out.println(id + "번 명언은 존재하지 않습니다.");
    }

    public void actionModify(Command cmd) {
        int id = cmd.getParamAsInt("id", 0);
        if (id == 0) {
            System.out.println("id(숫자)를 입력해주세요.");
            return;
        }

        Optional<WiseSaying> opWiseSaying = wiseSayingService.findById(id);
        if (opWiseSaying.isEmpty()) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        WiseSaying wiseSaying = opWiseSaying.get();
        System.out.println("명언(기존) : " + wiseSaying.getContent());
        String content = sc.nextLine();
        System.out.println("작가(기존) : " + wiseSaying.getAuthor());
        String author = sc.nextLine();
        wiseSayingService.modify(wiseSaying, content, author);
    }
}
