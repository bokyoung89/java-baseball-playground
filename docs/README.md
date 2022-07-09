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


<br />

# 숫자야구게임 구현

## 기능요구 사항
* 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
* 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
* e.g. 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1스트라이크, 456을 제시한 경우 : 1볼 1스트라이크, 789를 제시한 경우 : 낫싱
위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게 임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
## 기능구현 목록
- [x] 맞출 숫자는 1부터 9까지
- [ ] 3자리 수 맞추기
  * 같은 수가 같은 자리에 있으면 스트라이크
  * 같은 수가 다른 자리에 있으면 볼
  * 전혀 없으면 포볼 또는 낫싱
- [ ] 3개의 숫자를 모두 맞히면 게임 종료
- [ ] 게임 종료 후 다시 시작 또는 완전히 종료 선택

```html
숫자를 입력해 주세요 : 123
1볼 1스트라이크
숫자를 입력해 주세요 : 145
1볼
숫자를 입력해 주세요 : 671
2볼
숫자를 입력해 주세요 : 216
1스트라이크
숫자를 입력해 주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해 주세요 : 123
1볼 1스트라이크
…
```