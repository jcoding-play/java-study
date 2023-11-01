package stream.collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class ToListTest {
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = List.of(1, 2, 3, 1);
    }

    @Test
    void toList() {
        List<String> result = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        assertThat(result).containsExactly("1", "2", "3", "1");
    }

    @Test
    void toUnmodifiableList() {
        List<Integer> result = numbers.stream()
                .collect(Collectors.toUnmodifiableList());

        assertThatThrownBy(() -> result.add(10))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toCollection() {
        LinkedList<String> result = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toCollection(LinkedList::new));

        assertThat(result).containsExactly("1", "2", "3", "1");
    }

    @Test
    void collectingAndThen() {
        List<String> source = List.of("1", "2", "3", "4");

        Score score = source.stream()
                .map(Integer::parseInt)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Score::new));

        assertThat(score.getNumbers()).containsExactly(1, 2, 3, 4);
    }

    private static class Score {
        private final List<Integer> numbers;

        public Score(List<Integer> numbers) {
            this.numbers = numbers;
        }

        public List<Integer> getNumbers() {
            return numbers;
        }
    }

    @Test
    void joiningV1() {
        String result = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        assertThat(result).isEqualTo("1,2,3,1");
    }

    @Test
    void joiningV2() {
        String result = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",", "start -> " ," end"));

        assertThat(result).isEqualTo("start -> 1,2,3,1 end");
    }
}
