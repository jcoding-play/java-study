## Record

Java 14 버전에서 새롭게 추가된 ```Record```를 이용하여 불필요한 코드를 제거하고, 
깔끔한 코드를 만들 수 있다.

아래 코드들을 대충 봐도 확연히 Record 클래스가 깔끔하다는 것을 알 수 있다. (심지어 더 많은 기능을 제공하고 있음) 

```java
// 아래 User 클래스보다 실제로 더 많은 기능을 제공한다.
public record User(String name, int age) {
    
    //equals, hashcode, toString 자동 생성
}
```
```java
public class User {
    private final String name;
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
```
📌 Record 구조
- 레코드명(헤더) {바디} 구조를 이루고 있다.

📝 Record 특징은?
- 멤버변수는 private final
- 필드별 getter가 자동으로 생성
  - **단, 필드명으로 접근한다.**
```java
// 일반적인 getter 메서드
String name = user.getName();

// Record 클래스에서는 필드명으로 접근
String name = user.name();
```
- equals, hashcode, toString이 자동으로 생성
- 기본적으로 불변 객체이기 때문에 한번 값이 정해지면 값을 변경할 수 없다. 
- 다른 클래스를 상속하거나 상속시킬 수 없다.