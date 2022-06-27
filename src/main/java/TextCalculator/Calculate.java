package TextCalculator;

public class Calculate {

    public int add(int i, int j) {
        return i + j;
    }

    public int minus(int i, int j) {
        return i - j;
    }

    public int multiply(int i, int j) {
        return i * j;
    }

    public int divide(int i, int j) {
        return i / j;
    }

    public static int calculate(int first, String symbol, int second) {
        int result = 0;
        if (symbol.equals("+")) {
            result = first + second;
        } else if (symbol.equals("-")) {
            result = first - second;
        } else if (symbol.equals("*")) {
            result = first * second;
        } else if (symbol.equals("/")) {
            result = first / second;
        } else {
            System.out.println("사칙연산 기호가 아닙니다.");
        }
        return result;
    }
}
