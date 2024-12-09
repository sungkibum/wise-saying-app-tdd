package com.ll.domain.wiseSaying.repository;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public boolean delete(int id) {
        return wiseSayings.removeIf(e -> e.getId() == id);  //wiseSayings 리스트에서 값 검색해서 조건에 만족한다면 remove
    }

    public Optional<WiseSaying> findById(int id) {
        return wiseSayings.stream().filter(e -> e.getId() == id).findFirst();
    }

}
