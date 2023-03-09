package Calculator;

import java.util.Scanner;

public class CalculateMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        StringUtil util = new StringUtil();
        String[] result = util.split(value);
    }
}
