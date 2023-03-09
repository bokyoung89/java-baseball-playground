package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    // * 요구사항1
    // "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
    // "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
    // * 힌트
    // 배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
    // 배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.


    @DisplayName("split 분리 테스트_01")
    @Test
    void splitTest_01() {
        String words ="1,2";
        assertThat(words.split(",")).containsExactly("1","2");
    }
    @DisplayName("split 분리 테스트_02")
    @Test
    void splitTest_02() {
        String words ="1";
        assertThat(words.split(",")).contains("1");
    }

    @DisplayName("substring 문자열 자르기 테스트")
    @Test
    void substringTest() {
        String word = "(1,2)";
        assertThat(word.substring(1,4)).isEqualTo("1,2");
    }

    @DisplayName("charAt 특정 위치의 문자 반환 테스트")
    @Test
    void charAtTest() {
        String words = "abc";
        assertThat(words.charAt(0)).isEqualTo('a');
        assertThat(words.charAt(1)).isEqualTo('b');
        assertThat(words.charAt(2)).isEqualTo('c');
    }

    @DisplayName("문자열 범위 벗어났을 때 예외 테스트")
    @Test
    void charAtExceptionTest() {
        String words = "abc";
        assertThatThrownBy(() -> {
            words.charAt(words.length());
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
