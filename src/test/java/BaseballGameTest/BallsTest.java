package BaseballGameTest;

import BaseballGame.Ball;
import BaseballGame.Balls;
import BaseballGame.Ballstatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    @Test
    @DisplayName("strike_구현")
    void strike_구현(){
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Ballstatus status = answer.play(new Ball(1,1));
        assertThat(status).isEqualTo(Ballstatus.STRIKE);
    }

    @Test
    @DisplayName("ball_구현")
    void ball_구현(){
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Ballstatus status = answer.play(new Ball(1,2));
        assertThat(status).isEqualTo(Ballstatus.BALL);
    }

    @Test
    @DisplayName("nothing_구현")
    void nothing_구현(){
        Balls answer = new Balls(Arrays.asList(1, 2, 3));
        Ballstatus status = answer.play(new Ball(1,4));
        assertThat(status).isEqualTo(Ballstatus.NOTHING);
    }
}
