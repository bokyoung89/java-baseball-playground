package Calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {

    StringUtil util = new StringUtil();
    String str = "2 * 5 / 2 + 5";

    @DisplayName("문자열 분리 메소드 테스트")
    @Test
    void splitTest() {
        assertThat(util.split(str)).containsExactly("2", "+", "3");
    }

    @DisplayName("문자열 계산 메소드 테스트")
    @Test
    void calculateStringTest() {
        String[] splitValue = util.split(str);
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        assertThat(arithmeticOperations.calcuateString(splitValue)).isEqualTo(10);
    }
}
