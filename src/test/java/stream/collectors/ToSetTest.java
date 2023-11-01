package stream.collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class ToSetTest {
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = List.of(1, 2, 3, 1);
    }

    @Test
    void toSet() {
        Set<Integer> result = numbers.stream()
                .collect(Collectors.toSet());

        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    void toLinkedHashSet() {
        LinkedHashSet<Integer> result = numbers.stream()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        assertThat(result).containsExactly(1, 2, 3);
    }

    @Test
    void toUnmodifiableSet() {
        Set<Integer> result = numbers.stream()
                .collect(Collectors.toUnmodifiableSet());

        assertThatThrownBy(() -> result.add(4))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
