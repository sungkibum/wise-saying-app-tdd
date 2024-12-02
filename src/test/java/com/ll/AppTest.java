package com.ll;

import com.ll.standard.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    @DisplayName("== 명언 앱 ==")
    public void t1() {
        String output = AppTest.run("");

        assertThat(output).contains("== 명언 앱 ==");
    }

    public static String run(String input) {
        input = input.stripIndent().trim() + "\n종료";
        Scanner scanner = TestUtil.getScanner(input);
        ByteArrayOutputStream outputStream = TestUtil.setOutToByteArray();

        App app = new App(scanner);
        app.run();

        String output = outputStream.toString();

        TestUtil.clearSetOutToByteArray(outputStream);

        return output;
    }
}
