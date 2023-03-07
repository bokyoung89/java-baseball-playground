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
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @DisplayName("Set의 크기 확인 테스트")
    @Test
    void sizeCheckTest() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("값 존재 여부 테스트, ParameterizedTest 활용하여 여러 개의 파리미터 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void containsTest(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName("입력 값에 따라 결과 값이 다른 경우 테스트, CsvSource 활용")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void CsvSourceTest(int number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}