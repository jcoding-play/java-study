package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MainTest {

    @Test
    void test() {
        Main main = new Main();
        String result = main.test();

        assertThat(result).isEqualTo("TEST");
    }
}