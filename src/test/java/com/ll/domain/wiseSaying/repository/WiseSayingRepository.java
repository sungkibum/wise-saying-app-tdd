package com.ll.domain.wiseSaying.repository;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private int lastId;
    List<WiseSaying> wiseSayings;

    public WiseSayingRepository() {
        this.lastId = 0;
        this.wiseSayings = new ArrayList<>();
    }

    public WiseSaying add(WiseSaying wiseSaying) {
        wiseSaying.setId(++lastId);
        wiseSayings.add(wiseSaying);
        return wiseSaying;
    }

    public List<WiseSaying> list() {
        return wiseSayings;
    }
}
