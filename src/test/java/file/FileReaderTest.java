package file;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class FileReaderTest {

    @Test
    @DisplayName("텍스트 파일을 읽을 수 있다.")
    void read() {
        FileReader fileReader = FileReader.getInstance();
        List<String> result = fileReader.read("study.txt");

        assertThat(result.size()).isEqualTo(4);
    }
}