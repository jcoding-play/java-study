package method;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class splitTest {

    @Test
    @DisplayName("split(String regex) 이용")
    void split_V1() {
        String input = "길동,순신,현수";
        String[] result = input.split(",");

        assertThat(result).containsExactly("길동", "순신", "현수");
    }

    @Test
    @DisplayName("split(String regex) 이용")
    void split_V2() {
        String input = "길동,,";
        String[] result = input.split(",");

        assertThat(result).containsExactly("길동");
    }

    @Test
    @DisplayName("split(String regex, int limit) 이용")
    void split_V3() {
        String input = "길동,,";
        String[] result = input.split(",", -1);

        assertThat(result).containsExactly("길동", "", "");
    }

    @Test
    @DisplayName("split(String regex, int limit) 이용")
    void split_V4() {
        String input = "길동,순신,현수";
        String[] result = input.split(",", 2);

        assertThat(result).containsExactly("길동", "순신,현수");
    }
}
