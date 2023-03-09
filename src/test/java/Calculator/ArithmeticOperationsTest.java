package Calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArithmeticOperationsTest {

    //문자열 계산기
    //사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
    //문자열 계산기는 입력 값에 따라 계산 순서가 결정된다.

    /*
    * 1. 도메인을 구성하는 객체 : 입력받은 문자열, 사칙연산기
    * 2. 객체들 간의 관계 : 입력받은 문자열(1+2/3) --> 계산요청 -->  사칙연산기
    * 3. 동적인 객체를 정적인 타입으로 추상화해서 모델링
    * */

    @DisplayName("덧셈 테스트")
    @Test
    void addition() {
        assertThat(ArithmeticOperations.calculate(1,"+", 3)).isEqualTo(4);
    }

    @DisplayName("뺄셈 테스트")
    @Test
    void subtraction() {
        assertThat(ArithmeticOperations.calculate(1,"-", 3)).isEqualTo(-2);
    }

    @DisplayName("곱셈 테스트")
    @Test
    void multiplication() {
        assertThat(ArithmeticOperations.calculate(1,"*", 3)).isEqualTo(3);
    }

    @DisplayName("나눗셈 테스트")
    @Test
    void division() {
        assertThat(ArithmeticOperations.calculate(4,"/", 2)).isEqualTo(2);
    }
}
