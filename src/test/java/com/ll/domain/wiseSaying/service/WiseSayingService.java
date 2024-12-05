package com.ll.domain.wiseSaying.service;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    private int lastId;
    List<WiseSaying> wiseSayings;
    public WiseSayingService() {
        this.lastId = 0;
        this.wiseSayings = new ArrayList<>();
    }

    public WiseSaying add(String content, String author) {
        int id = ++lastId;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);
        return wiseSaying;
    }

    public List<WiseSaying> list() {
        return wiseSayings;
    }
}
