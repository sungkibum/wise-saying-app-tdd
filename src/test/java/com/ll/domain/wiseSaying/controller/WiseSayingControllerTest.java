package com.ll.domain.wiseSaying.controller;

import com.ll.App;
import com.ll.AppTest;
import com.ll.standard.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;


public class WiseSayingControllerTest {

    @Test
    @DisplayName("명령) ")
    public void t2() {
        String output = AppTest.run("""
                목록
                """);

        assertThat(output).contains("명령) ");
    }

    @Test
    @DisplayName("명령을 2번 이상 입력할 수 있습니다. ")
    public void t3() {
        String output = AppTest.run("""
                목록
                목록
                """);

        String[] split = output.split("명령\\)");
        assertThat(split).contains("명령) ");
    }

    @Test
    @DisplayName("등록")
    public void t4() {
        String output = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                """);
        assertThat(output).contains("명언 : ")
        .contains("작가 : ");
    }
}
