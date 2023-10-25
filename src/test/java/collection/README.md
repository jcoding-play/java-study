## Collection Factory Method 기능

📝 List, Set, Map 에서 immutable(불변) 컬렉션을 생성하는 기능이 추가되었다.<br>
- **불변 객체: 한번 할당하면 내부 데이터를 수정할 수 없음**

**of()** -> 불변 컬렉션을 생성할 수 있다.<br>
**emptyList(), emptyMap(), emptySet()** -> 비어있는 불변 컬렉션을 생성한다.

``` java
// 불변 컬렉션을 생성함
List<Integer> result = List.of(1, 2, 3);

// 비어있는 불변 컬렉션을 생성함
List<Integer> result = Collections.emptyList();
```
