### extracting 메서드

- 특정 객체의 값이 잘 들어갔는지 확인하기 위해 getter 메서드를 사용해야 되는지 고민해본 적이 있다. 🧐

---
> 📝 getter를 사용하지 않고 테스트를 진행하려면 어떻게 해야될까?

이를 쉽게 해결하기 위한 방법으로 `extracting` 메서드를 이용할 수 있다.
그 이유는 `extracting` 메서드가 Reflection을 사용하기 때문이다.

---
```java
// 사용 예시
class User {
    private final String name;
    private final int age;

    public User(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
}
```
다음과 같이 User 클래스가 존재하고, 이를 생성했다고 가정해보자.

```java
User user = new User("gyungchan", 30);
```

위에서 생성한 객체의 이름이 올바르게 생성되었는지 확인하려면 쉽게 getter 메서드를 사용할 수 있다.

```java
//getter 메서드 예시
@Test
@DisplayName("extracting 메서드로 특정 필드를 추출할 수 있다.")
void extractingV1() {
    User user = new User("gyungchan", 30);

    assertThat(user.getName()).isEqualTo("gyungchan");
}
```

하지만, 무분별한 getter 메서드 사용은 지양하는 것이 좋기 때문에 extracting 메서드를 이용해볼 수 있다.

```java
//extracting 메서드 예시
@Test
@DisplayName("extracting 메서드로 특정 필드를 추출할 수 있다.")
void extractingV1() {
    User user = new User("gyungchan", 30);

    assertThat(user).extracting("name")
            .isEqualTo("gyungchan");    
}
```
