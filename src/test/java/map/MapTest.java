package map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class MapTest {

    @Test
    @DisplayName("이미 존재하는 key 값이라면 value 값을 저장하지 않는다.")
    void putIfAbsent_v1() {
        Map<String, Integer> map = new HashMap<>();
        map.put("gyungchan", 26);

        int result = map.putIfAbsent("gyungchan", 30);
        assertThat(result).isEqualTo(26);
        assertThat(map.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("존재하지 않는 key 값이라면 value 값을 저장한다. (반환은 null을 반환하다.)")
    void putIfAbsent_v2() {
        Map<String, Integer> map = new HashMap<>();

        Integer result = map.putIfAbsent("gyungchan", 30);
        assertThat(result).isNull();

        Integer value = map.get("gyungchan");
        assertThat(value).isEqualTo(30);
    }
}
