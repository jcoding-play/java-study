package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCode {

    @Test
    @DisplayName("extracting 메서드로 특정 필드를 추출할 수 있다.")
    void extractingV1() {
        User user = new User("gyungchan", 30);

        assertThat(user).extracting("name")
                .isEqualTo("gyungchan");
    }

    @Test
    @DisplayName("extracting 메서드로 Collection에 포함된 객체들 중 특정 필드를 추출할 수 있다.")
    void extractingV2() {
        List<User> users = List.of(new User("gyungchan", 30), new User("gildong", 10));

        assertThat(users).extracting("name")
                .containsExactly("gyungchan", "gildong");
    }

    static class User {
        private final String name;
        private final int age;

        public User(final String name, final int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }
    }
}
