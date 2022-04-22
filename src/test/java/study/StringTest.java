package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("split() 배열 분리 테스트")
    void splitTest_01(){
        //given
        String numbers = "1,2";

        //when
        String[] inputSplit = numbers.split(",");

        //then
        assertThat(inputSplit).containsExactly("1","2");
    }

    @Test
    @DisplayName("split() 배열 반환 테스트")
    void splitTest_02(){
        //given
        String number = "1";

        //when
        String[] inputSplit = number.split(",");

        //then
        assertThat(inputSplit).containsExactly("1");
    }

    @Test
    @DisplayName("substring() 메소드로 소괄호 제거 후 반환 테스트")
    void splitTest_03(){
        //given
        String numbers = "(1,2)";

        //when
        String inputSubstring = numbers.substring(1,4);

        //then
        assertThat(inputSubstring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chatAt() 메소드로 특정 위치의 문자 반환 테스트 ")
    void charAtTest_04(){
        //given
        String word = "abc";

        //when
        char ch1 = word.charAt(0);
        char ch2 = word.charAt(1);
        char ch3 = word.charAt(2);

        //then
        assertThat(ch1).isEqualTo('a');
        assertThat(ch2).isEqualTo('b');
        assertThat(ch3).isEqualTo('c');
    }

    @Test
    @DisplayName("위치 값 벗어났을 경우, IndexOutOfBoundsException 예외 발생 테스트")
    void exceptionTest_05(){
        //given
        String word = "abc";

        //when, then
        assertThatThrownBy(() -> word.charAt(word.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("size: " + word.length());
    }
}
