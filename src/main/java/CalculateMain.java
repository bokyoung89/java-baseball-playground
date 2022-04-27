import javax.swing.plaf.synth.SynthStyle;
import java.util.Scanner;

public class CalculateMain {

    public static void main(String[] args) {

        //1.사용자 문자열 입력
        Scanner scanner = new Scanner(System.in);
        System.out.println("계산할 값과 사칙연산 기호를 입력하세요. 예) 2 + 3 * 5");
        String value = scanner.nextLine();

        //2.문자열 분리
        StringUtil util = new StringUtil();
        String[] values;
        values = util.stringSplit(value);

    }
}
