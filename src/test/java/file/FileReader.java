package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {
    private static final String PATH_PREFIX = "java-study/src/test/java/file/";

    private static FileReader instance = null;

    private FileReader() {
    }

    public static FileReader getInstance() {
        if (instance == null) {
            instance = new FileReader();
        }
        return instance;
    }

    public List<String> read(String path) {
        try {
            return Files.readAllLines(Paths.get(PATH_PREFIX + path));
        } catch (IOException e) {
            throw new IllegalArgumentException("파일을 읽을 수 없습니다.");
        }
    }
}
