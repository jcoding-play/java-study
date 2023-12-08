package date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalTimeTest {
    private LocalTime localTime;

    @BeforeEach
    void setUp() {
        localTime = LocalTime.of(12, 30, 30);
    }

    @Test
    @DisplayName("시간을 생성할 수 있다.")
    void createLocalTime() {
        assertThat(localTime).isEqualTo("12:30:30");
    }

    @Test
    @DisplayName("입력된 시간에 시를 더할 수 있다.")
    void plusHours() {
        LocalTime result = localTime.plusHours(4);
        assertThat(result).isEqualTo(LocalTime.of(16, 30, 30));
    }

    @Test
    @DisplayName("입력된 시간에 분을 더할 수 있다.")
    void plusMinutes() {
        LocalTime result = localTime.plusMinutes(30);
        assertThat(result).isEqualTo(LocalTime.of(13, 0, 30));
    }

    @Test
    @DisplayName("입력된 시간에 초를 더할 수 있다.")
    void plusSeconds() {
        LocalTime result = localTime.plusSeconds(30);
        assertThat(result).isEqualTo(LocalTime.of(12, 31, 0));
    }

    @Test
    @DisplayName("두 시간 간 과거를 판단할 수 있다.")
    void isBefore() {
        LocalTime from = LocalTime.of(12, 30, 30);
        LocalTime to = LocalTime.of(12, 40, 0);

        assertThat(from.isBefore(to)).isTrue();
        assertThat(to.isBefore(from)).isFalse();
    }

    @Test
    @DisplayName("두 시간 간 미래를 판단할 수 있다.")
    void isAfter() {
        LocalTime from = LocalTime.of(12, 30);
        LocalTime to = LocalTime.of(12, 40);

        assertThat(from.isAfter(to)).isFalse();
        assertThat(to.isAfter(from)).isTrue();
    }

    @Test
    @DisplayName("두 시간이 동일한지 판단할 수 있다.")
    void equals() {
        LocalTime first = LocalTime.of(12, 30);
        LocalTime second = LocalTime.of(12, 30);

        assertThat(first.equals(second)).isTrue();
    }
}
