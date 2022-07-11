package BaseballGameTest;

import BaseballGame.Ball;
import BaseballGame.Ballstatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    private Ball com;

    @BeforeEach
    void setUp() {
        com = new Ball(1, 4);
    }

    @Test
    @DisplayName("strike_구현")
    void strike_구현(){
        Ballstatus status = com.play(new Ball(1, 4));
        assertThat(status).isEqualTo(Ballstatus.STRIKE);
    }

    @Test
    @DisplayName("ball_구현")
    void ball_구현(){
        Ballstatus status = com.play(new Ball(2, 4));
        assertThat(status).isEqualTo(Ballstatus.BALL);
    }

    @Test
    @DisplayName("nothing_구현")
    void nothing_구현(){
        Ballstatus status = com.play(new Ball(2, 5));
        assertThat(status).isEqualTo(Ballstatus.NOTHING);
    }
}
