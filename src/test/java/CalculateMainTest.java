import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateMainTest {

    StringUtil util = new StringUtil();

    @Test
    @DisplayName("문자열 분리 테스트")
    void split_test(){

        String str = "1 + 2";

        assertThat(util.stringSplit(str)).containsExactly("1", "+", "2");
    }

    @Test
    @DisplayName("문자열을 숫자로 출력")
    void input_test(){

        String str = "1";

        assertThat(Integer.parseInt(str)).isEqualTo(1);
    }
}
