package BaseballGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 객체 지향 프로그래밍
// 1. 기능을 가지고 있는 클래스를 인스턴스화(객체)한다.
// 2. 필요한 기능을 (역할에 맞는) 인스턴스가 수행하게 한다.(의인화)
// 3. 각 결과를 종합한다.
public class BaseballMain {
    /*
    *   숫자를 입력해 주세요 : 123
  1볼 1스트라이크
  숫자를 입력해 주세요 : 145
  1볼
  숫자를 입력해 주세요 : 671
  2볼
  숫자를 입력해 주세요 : 216
  1스트라이크
  숫자를 입력해 주세요 : 713
  3스트라이크
  3개의 숫자를 모두 맞히셨습니다! 게임 종료
  게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
  1
  숫자를 입력해 주세요 : 123
  1볼 1스트라이크
  …
    * */
    public static void main(String[] args) {

        do {
            BallGenerator ball = new BallGenerator();
            List<Integer> computer = ball.createRandomNumbers();
            System.out.println(computer);

            Referee referee = new Referee();

            String result = "";
            while (!result.equals("3스트라이크")) {
                result = referee.Compare(computer, askNumbers());
                System.out.println(result);
            }
        } while(playagain());

    }

    public static List<Integer> askNumbers() {
        System.out.println("숫자를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split("")) {
            numbers.add(Integer.valueOf(number));
        }
        return numbers;
    }

    public static boolean playagain() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        char choice = scanner.next().charAt(0);
        if(choice == '1'){
            return true;
        }
        return false;
    }
}