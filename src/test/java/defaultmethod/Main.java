package defaultmethod;

public class Main implements MyInterface {

    @Override
    public void printMessage() {
        System.out.println("일반적인 인터페이스 활용");
    }
}
