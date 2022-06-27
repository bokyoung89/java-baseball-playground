package TextCalculatorTest;

import TextCalculator.Calculate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTest {

    Calculate cal = new Calculate();

    @Test
    @DisplayName("사칙연산 구현 테스트_덧셈")
    void addTest(){
        assertThat(cal.add(3,4)).isEqualTo(7);
    }

    @Test
    @DisplayName("사칙연산 구현 테스트_뺄셈")
    void minusTest(){
        assertThat(cal.minus(5,2)).isEqualTo(3);
    }

    @Test
    @DisplayName("사칙연산 구현 테스트_곱셈")
    void multiplyTest(){
        assertThat(cal.multiply(4,5)).isEqualTo(20);
    }

    @Test
    @DisplayName("사칙연산 구현 테스트_나눗셈")
    void divideTest(){
        assertThat(cal.divide(6,2)).isEqualTo(3);
    }

    @Test
    @DisplayName("계산 구현 테스트")
    void calculate(){
        int first = 2;
        String symbol = "*";
        int second = 4;

        assertThat(cal.calculate(first, symbol, second)).isEqualTo(8);
    }
}
