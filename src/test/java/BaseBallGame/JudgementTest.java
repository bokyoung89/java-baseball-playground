package BaseBallGame;

import BaseballGame.Judgement;
import BaseballGame.Referee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class JudgementTest {

    Judgement judgement = new Judgement();

    @DisplayName("컴퓨터와 플레이어의 3자리 수 중, 같은 숫자 카운트 테스트")
    @Test
    void correctCountTest() {
        int count = judgement.correctCount(Arrays.asList(1,2,3), Arrays.asList(1,2,3));
        assertThat(count).isEqualTo(3);
    }

    @DisplayName("특정 자리에 특정 숫자 존재 테스트")
    @Test
    void hasPlaceTest( ) {
        boolean place = judgement.hasPlace(Arrays.asList(3,2,6),0,3);
        assertThat(place).isEqualTo(true);
    }

    @DisplayName("컴퓨터의 3자리 수와 플레이어와 3자리 수 비교 테스트")
    @Test
    void compareTest() {
        Referee referee = new Referee();
        String result = referee.Compare(Arrays.asList(3,6,2), Arrays.asList(3,2,6));
        assertThat(result).isEqualTo("2볼 1스트라이크");
    }
}



