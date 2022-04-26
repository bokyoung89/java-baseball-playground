## String 클래스에 대한 학습 테스트
---
### 요구사항 1
* "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
* "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.

**힌트**
* 배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
* 배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.
  
<br />

### 요구사항 2
* "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
  
<br />

### 요구사항 3
* "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
* String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
* JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.

<br />

* 자주 발생하는 Exception의 경우 Exception별 메서드 제공하고 있음
    * assertThatIllegalArgumentException()
    * assertThatIllegalStateException()
    * assertThatIOException()
    * assertThatNullPointerException()

---
<br/>

## Set Collection에 대한 학습 테스트
* 다음과 같은 Set 데이터가 주어졌을 때 요구사항을 만족해야 한다.

```java
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    
    // Test Case 구현
}
```
### 요구사항 1
* Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.
  
<br />

### 요구사항 2
* Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현하려한다.
* 구현하고 보니 다음과 같이 중복 코드가 계속해서 발생한다.
* JUnit의 ParameterizedTest를 활용해 중복 코드를 제거해 본다.

```java
    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }
```

<br />

### 요구사항 3
* 요구사항 2는 contains 메소드 결과 값이 true인 경우만 테스트 가능하다. 입력 값에 따라 결과 값이 다른 경우에 대한 테스트도 가능하도록 구현한다.
* 예를 들어 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.

**힌트**
* Guide to JUnit 5 Parameterized Tests 문서에서 @CsvSource를 활용한다.
```java
@ParameterizedTest
@CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
void toLowerCase_ShouldGenerateTheExpectedLowercaseValue(String input, String expected) {
    String actualValue = input.toLowerCase();
    assertEquals(expected, actualValue);
}
```


<br />

# 문자열 계산기 - 단위 테스트 실습 
* 다음 요구사항을 JUnit을 활용해 단위 테스트 코드를 추가해 구현한다.
  
### 요구사항
* 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
* 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
* 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### 힌트
* 문자열을 입력 받은 후(scanner의 nextLine() 메소드 활용) 빈 공백 문자열을 기준으로 문자들을 분리해야 한다.

```java
String value = scanner.nextLine();
String[] values = value.split(" ");
```

* 문자열을 숫자로 변경하는 방법
```java
int number = Integer.parseInt("문자열");
```

## 구현 기능 목록
1. 사칙연산 구현
2. 계산할 값 입력 및 사칙연산
3. 숫자 값, 연산기호 입력 및 사칙연산