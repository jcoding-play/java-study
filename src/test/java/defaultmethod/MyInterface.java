package defaultmethod;

public interface MyInterface {

    void printMessage();

    default String getMessage() {
        return privateMethod();
    }

    default String getMessage(String input) {
        return String.format("%s: %s", input, privateMethod());
    }

    private String privateMethod() {
        return "디폴트 메서드를 이용한 메시지입니다.";
    }
}
