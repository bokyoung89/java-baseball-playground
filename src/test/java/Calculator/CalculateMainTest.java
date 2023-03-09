package Calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateMainTest {

    @DisplayName("문자열 분리 메소드 테스트")
    @Test
    void splitTest() {
        StringUtil util = new StringUtil();
        String str = "2 + 3";
        assertThat(util.split(str)).containsExactly("2", "+", "3");
    }
}
