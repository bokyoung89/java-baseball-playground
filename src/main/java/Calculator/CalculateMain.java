package Calculator;

import java.util.Scanner;

public class CalculateMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();

        StringUtil util = new StringUtil();
        String[] splitValue = util.split(value);
        for(int i=0; i<splitValue.length; i++){
            System.out.println(splitValue[i]);
        }

        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        int result = arithmeticOperations.calcuateString(splitValue);
        System.out.println(result);
    }
}
