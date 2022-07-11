package BaseballGame;

import java.util.Objects;

public class Ball {
    private final int position;
    private final int ballNo;

    public Ball(int position, int ballNo) {
        this.position = position;
        this.ballNo = ballNo;
    }

    public Ballstatus play(Ball ball) {
        if(this.equals(ball)){
            return Ballstatus.STRIKE;
        }
        if(ball.matchBallNo(ballNo)){
            return Ballstatus.BALL;
        }
        return Ballstatus.NOTHING;
    }

    private boolean matchBallNo(int ballNo) {
        return this.ballNo == ballNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && ballNo == ball.ballNo;
    }
}
