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

    @Test
    @DisplayName("등록 완료 시 명언 번호 출력")
    public void t5() {
        String output = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                """);
        assertThat(output).contains("1번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("등록될 때마다 명언 번호 증가")
    public void t6() {
        String output = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                현재를 미워하라.
                작자미상
                """);
        assertThat(output).contains("1번 명언이 등록되었습니다.")
                .contains("2번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("목록")
    public void t7() {
        String output = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                현재를 미워하라.
                작자미상
                목록
                """);
        assertThat(output).contains("번호 / 작가 / 명언")
                .contains("------------")
                .contains("2 / 작자미상 / 과거에 집착하지 마라.")
                .contains("1 / 작자미상 / 현재를 사랑하라.");
    }
}
