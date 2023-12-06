package date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LocalDateTest {
    private LocalDate localDate;

    @BeforeEach
    void setUp() {
        localDate = LocalDate.of(2023, 12, 6);
    }

    @Test
    @DisplayName("날짜를 생성할 수 있다.")
    void createLocalDate() {
        assertThat(localDate).isEqualTo("2023-12-06");
    }

    @Test
    @DisplayName("입력된 날짜에 일을 더할 수 있다.")
    void plusDays() {
        LocalDate result = localDate.plusDays(4);
        assertThat(result).isEqualTo(LocalDate.of(2023, 12, 10));
    }

    @Test
    @DisplayName("입력된 날짜에 주를 더할 수 있다.")
    void plusWeeks() {
        LocalDate result = localDate.plusWeeks(1);
        assertThat(result).isEqualTo(LocalDate.of(2023, 12, 13));
    }

    @Test
    @DisplayName("입력된 날짜에 월을 더할 수 있다.")
    void plusMonths() {
        LocalDate result = localDate.plusMonths(2);
        assertThat(result).isEqualTo(LocalDate.of(2024, 2, 6));
    }

    @Test
    @DisplayName("입력된 날짜에 년을 더할 수 있다.")
    void plusYears() {
        LocalDate result = localDate.plusYears(1);
        assertThat(result).isEqualTo(LocalDate.of(2024, 12, 6));
    }

    @Test
    @DisplayName("두 날짜 사이의 날짜들을 알 수 있다.")
    void datesUntil() {
        LocalDate from = LocalDate.of(2023, 12, 1);
        LocalDate to = LocalDate.of(2023, 12, 4);
        Stream<LocalDate> result = from.datesUntil(to);

        assertThat(result).containsExactly(
                LocalDate.of(2023, 12, 1),
                LocalDate.of(2023, 12, 2),
                LocalDate.of(2023, 12, 3)
        );
    }

    @Test
    @DisplayName("두 날짜 간 과거를 판단할 수 있다.")
    void isBefore() {
        LocalDate from = LocalDate.of(2023, 12, 1);
        LocalDate to = LocalDate.of(2023, 12, 4);

        assertThat(from.isBefore(to)).isTrue();
        assertThat(to.isBefore(from)).isFalse();
    }

    @Test
    @DisplayName("두 날짜 간 미래를 판단할 수 있다.")
    void isAfter() {
        LocalDate from = LocalDate.of(2023, 12, 1);
        LocalDate to = LocalDate.of(2023, 12, 4);

        assertThat(from.isAfter(to)).isFalse();
        assertThat(to.isAfter(from)).isTrue();
    }

    @Test
    @DisplayName("두 날짜가 동일한지 판단할 수 있다.")
    void equals() {
        LocalDate first = LocalDate.of(2023, 12, 1);
        LocalDate second = LocalDate.of(2023, 12, 1);

        assertThat(first.equals(second)).isTrue();
    }
}
