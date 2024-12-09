package com.ll.domain.wiseSaying.service;

import com.ll.domain.wiseSaying.entity.WiseSaying;
import com.ll.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WiseSayingService {

    private final WiseSayingRepository wiseSayingRepository;
    public WiseSayingService() {
        this.wiseSayingRepository = new WiseSayingRepository();
    }

    public WiseSaying add(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(0, content, author);
        wiseSayingRepository.add(wiseSaying);

        return wiseSaying;
    }

    public List<WiseSaying> list() {
        return wiseSayingRepository.list();
    }

    public boolean delete(int id) {
        return wiseSayingRepository.delete(id);
    }

    public Optional<WiseSaying> findById(int id) {
        return wiseSayingRepository.findById(id);
    }

}
