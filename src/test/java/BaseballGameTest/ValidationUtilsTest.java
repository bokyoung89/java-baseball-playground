package BaseballGameTest;

import BaseballGame.ValidationUtils;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationUtilsTest {

    @Test
    @DisplayName("야구게임_숫자_1부터_9까지_검증")
    public void 야구게임_숫자_1부터_9까지_검증(){

/*      //리팩토링 전
        //input
        boolean result = ValidationUtils.validNo(9);
        //output
        assertThat(result).isTrue();*/

        //리팩토링 후
        assertThat(ValidationUtils.validNo(9)).isTrue();
        assertThat(ValidationUtils.validNo(1)).isTrue();
        assertThat(ValidationUtils.validNo(10)).isFalse();
        assertThat(ValidationUtils.validNo(0)).isFalse();
    }
}
