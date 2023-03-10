package BaseBallGame;

/*
        * 1. 도메인을 구성하는 객체에는 어떤 것들이 있는지 고민
        * 2. 객체들 간의 관계를 고민
        * 3. 동적인 객체를 정적인 타입으로 추상화해서 도메인 모델링 하기
        * 4. 협력을 설계
        * 5. 객체들을 포괄하는 타입에 적절한 책임을 할당
        * 6. 구현하기
        *
        * 1. 숫자 생성기, 숫자 입력기, 숫자 계산기, 숫자 출력기
*/

import BaseballGame.BallGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallGeneratorTest {

    @DisplayName("숫자 1부터 9까지 중복되지 않는 임의의 수 3자리 추출 테스트")
    @Test
    void random3BallTest() {
        BallGenerator ball = new BallGenerator();
        assertThat(ball.createRandomNumbers()).containsExactly(2,3,4);
    }
}
