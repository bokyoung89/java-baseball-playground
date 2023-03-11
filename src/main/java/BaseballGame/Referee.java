package BaseballGame;

import java.util.List;

public class Referee {

    public String Compare(List<Integer> computer, List<Integer> player){
        // 몇 개의 숫자가 같은지 알아낸 뒤
        // 스트라이크의 개수를 구한 뒤 뺀다.
        // 남은 수는 볼의 갯수이다.

        Judgement judgement = new Judgement();
        int correctCount = judgement.correctCount(computer,player);

        int strike = 0;
        for(int playerIndex = 0; playerIndex < player.size(); playerIndex++) {
            if (judgement.hasPlace(computer, playerIndex, player.get(playerIndex))){
                strike++;
            }
        }
        int ball = correctCount - strike;
        if(ball == 0 && strike != 0) {
            return strike + "스트라이크";
        }
        if(strike == 0 && ball !=0) {
            return ball + "볼";
        }

        if(strike == 0) {
            return "낫싱";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
}
