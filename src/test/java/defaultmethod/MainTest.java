package defaultmethod;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("인터페이스에서 default method를 이용해 미리 구현할 수 있다.")
    void default_method() {
        Main main = new Main();
        String message = main.getMessage();

        assertThat(message).isEqualTo("디폴트 메서드를 이용한 메시지입니다.");
    }

    @Test
    @DisplayName("인터페이스에서 default와 private method를 이용해 미리 구현할 수 있다.")
    void defaultAndPrivateMethod() {
        Main main = new Main();
        String message = main.getMessage("안녕");

        assertThat(message).isEqualTo("안녕: 디폴트 메서드를 이용한 메시지입니다.");
    }
}