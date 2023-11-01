package stream.collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class ToMapTest {
    private List<String> source;

    @BeforeEach
    void setUp() {
        source = List.of("aa", "bbb", "ccc", "dd");
    }

    @Test
    void toMapV1() {
        Map<Integer, String> result = source.stream()
                .collect(Collectors.toMap(String::length, Function.identity(), (oldStr, newStr) -> oldStr));

        assertThat(result).containsExactly(entry(2, "aa"), entry(3, "bbb"));
    }

    @Test
    void toMapV2() {
        Map<Integer, String> result = source.stream()
                .collect(Collectors.toMap(String::length, Function.identity(), (oldStr, newStr) -> newStr));

        assertThat(result).containsExactly(entry(2, "dd"), entry(3, "ccc"));
    }

    @Test
    void toMapV3() {
        Map<Integer, String> result = source.stream()
                .collect(Collectors.toMap(String::length, Function.identity(), (oldStr, newStr) -> "새로운 값"));

        assertThat(result).containsExactly(entry(2, "새로운 값"), entry(3, "새로운 값"));
    }

    @Test
    void groupingBy() {
        Map<Integer, List<String>> result = source.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toList()));

        assertThat(result.get(2)).containsExactly("aa", "dd");
        assertThat(result.get(3)).containsExactly("bbb", "ccc");
    }
}
