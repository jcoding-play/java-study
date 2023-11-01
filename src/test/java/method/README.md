## split() 기능

---
### limit 파라미터??

```java
public String[] split(String regex, int limit)
```
split 메서드에서 limit 값을 파라미터로 전달 받을 수 있다는 것을 알게 되었다.

차이가 있을까??

내가 일반적으로 사용했던 split 메서드는 `split(String regex)`였고, 이것은 limit 값에 0이 생략된 것이였다.    
> 다음과 같이 사용했을때 발생했던 문제를 하나 코드를 통해 봐보자!

```java
@Test
void splitTest(){
    String input="길동,,";
    String[]result=input.split(",");

    assertThat(result).containsExactly("길동");
}
```
내가 기대했던 결과는 {"길동", "", ""}과 같이 값을 가지는 것이었다.   
하지만 기대했던 결과와 다르게 {"길동"}만 포함하는 것을 볼 수 있다.   
   
이유는 limit 값이 0일 때, 맨 뒤의 값들이 빈 값이라면 이를 제거하기 때문이다.

---
### 이를 해결하려면?
limit 파라미터에 음수값을 전달하여 맨 뒤의 값들을 전부 가져올 수 있다.

```java
@Test
void splitTest(){
    String input = "길동,,";
    String[] result = input.split(",", -1);

    assertThat(result).containsExactly("길동", "", "");
}
```

또한 만약 limit 파라미터에 0보다 큰 값을 전달하면, 전달한 크기만큼 문자를 나눈다.

```java
@Test
void splitTest(){
    String input = "길동,순신,현수";
    String[] result = input.split(",", 2);

    assertThat(result).containsExactly("길동", "순신,현수");
}
```