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

        //3.입력한 문자열을 숫자와 기호로 출력
        int first = Integer.parseInt(values[0]);

        for(int i = 1; i < values.length; i += 2){
            String symbol = values[i];

            int second = Integer.parseInt(values[i+1]);
        }
    }
}
