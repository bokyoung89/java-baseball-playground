package Calculator;

public class ArithmeticOperations {

    public int calcuateString(String[] splitValue) {
        int operand1 = Integer.parseInt(splitValue[0]);

        int temp = operand1;
        for (int i = 1; i < splitValue.length; i += 2) {
            String operator = splitValue[i];

            int operand2 = Integer.parseInt(splitValue[i + 1]);

            temp = calculate(temp, operator, operand2);
        }
        return temp;
    }

    public static int calculate(int operand1, String operator, int operand2) {
        int result = 0;
        if(operator.equals("+"))
            result = operand1 + operand2;
        if(operator.equals("-"))
            result = operand1 - operand2;
        if(operator.equals("*"))
            result = operand1 * operand2;
        if(operator.equals("/"))
            result = operand1 / operand2;
        return result;
    }
}
