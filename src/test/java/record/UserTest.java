package record;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("클래스를 이용한 객체 생성")
    void createUserByClass() {
        User user = new User("Gildong", 10);
        System.out.println("user = " + user);

        assertThat(user.getName()).isEqualTo("Gildong");
        assertThat(user.getAge()).isEqualTo(10);
    }

    @Test
    @DisplayName("Record 클래스를 이용한 객체 생성")
    void createUserByRecord() {
        UserRecord user = new UserRecord("Gildong", 10);
        System.out.println("user = " + user);

        assertThat(user.name()).isEqualTo("Gildong");
        assertThat(user.age()).isEqualTo(10);
    }

    @Test
    @DisplayName("클래스를 이용한 객체 생성")
    void createUserByClass_equals() {
        User user = new User("Gildong", 10);

        assertThat(user).isNotEqualTo(new User("Gildong", 10));
    }

    @Test
    @DisplayName("Record 클래스를 이용한 객체 생성")
    void createUserByRecord_equals() {
        UserRecord user = new UserRecord("Gildong", 10);

        assertThat(user).isEqualTo(new UserRecord("Gildong", 10));
    }
}