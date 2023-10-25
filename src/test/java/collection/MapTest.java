package collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class MapTest {

    @Test
    @DisplayName("Map.of()를 이용하여 불변 객체를 만들 수 있다.")
    void of() {
        Map<String, Integer> result = Map.of(
                "1", 1,
                "2", 2,
                "3", 3
        );

        assertThat(result).contains(
                entry("1", 1), entry("2", 2), entry("3", 3)
        );
    }

    @Test
    @DisplayName("불변 객체에 내부 데이터를 변경하려고 하면 예외가 발생한다.")
    void throwsUnsupportedOperationException() {
        Map<String, Integer> result = Map.of(
                "1", 1,
                "2", 2,
                "3", 3
        );

        assertThatThrownBy(() -> result.put("4", 4))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("emptyMap()를 통해 비어있는 불변 컬렉션을 반환해준다.")
    void emptyMap() {
        Map<String, Integer> result = Collections.emptyMap();

        assertThat(result.isEmpty()).isTrue();
        assertThatThrownBy(() -> result.put("4", 4))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
