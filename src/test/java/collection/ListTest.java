package collection;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ListTest {

    @Test
    @DisplayName("List.of()를 이용하여 불변 객체를 생성할 수 있다.")
    void of() {
        List<Integer> numbers = List.of(1, 2, 3);
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("불변 객체에 내부 데이터를 변경하려고 하면 예외가 발생한다.")
    void throwsUnsupportedOperationException() {
        List<Integer> numbers = List.of(1, 2, 3);

        test(() -> numbers.add(4));
        test(() -> numbers.remove(0));
        test(() -> numbers.sort(Comparator.reverseOrder()));
        test(() -> numbers.set(0, 0));
    }

    private void test(ThrowableAssert.ThrowingCallable t) {
        assertThatThrownBy(t)
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("불변 객체에 대해 재할당은 가능하다.")
    void list() {
        List<Integer> source = List.of(1, 2, 3);
        List<Integer> numbers = new ArrayList<>(source);

        numbers.add(4);

        assertThat(numbers).containsExactly(1, 2, 3, 4);
    }

    @Test
    @DisplayName("emptyList()를 통해 리스트의 값이 비어있는 불변 컬렉션을 반환해준다.")
    void emptyList() {
        List<Integer> numbers = Collections.emptyList();

        assertThat(numbers.isEmpty()).isTrue();
        assertThatThrownBy(() -> numbers.add(4))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
