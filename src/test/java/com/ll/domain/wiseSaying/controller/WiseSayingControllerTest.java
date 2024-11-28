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
    @DisplayName("== 명언 앱 ==")
    public void t1() {
        String output = AppTest.run("종료");

        assertThat(output).contains("== 명언 앱 ==");
    }

    @Test
    @DisplayName("명령) ")
    public void t2() {
        String output = AppTest.run("""
                목록
                종료
                """);

        assertThat(output).contains("명령) ");
    }

    @Test
    @DisplayName("명령을 2번 이상 입력할 수 있습니다. ")
    public void t3() {
        String output = AppTest.run("""
                목록
                목록
                종료
                """);


        assertThat(output).contains("명령) ");
    }
}
