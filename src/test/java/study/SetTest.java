package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현

    @Test
    @DisplayName("size() 메스도로 Set의 크기를 확인한다.")
    void setTest_01(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("contains() 메소드로 1,2,3 값이 존재하는지 확인한다.")
    void setTest_02(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("ParameterizedTest를 활용해 중복 코드를 제거한다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void setTest_03(int num){
        assertThat(numbers.contains(num)).isTrue();
    }

    @DisplayName("ParameterizedTest를 활용해 결과 값이 있으면 true를, 다른 경우 false를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false", "5:false"}, delimiter = ':')
    void setTest_04(int num, boolean expected){
        assertThat(numbers.contains(num)).isEqualTo(expected);
    }
}