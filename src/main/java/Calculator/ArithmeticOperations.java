package Calculator;

public class ArithmeticOperations {

    public static int calculate(int operand1, String operator, int operand2) {
        if(operator == "+"){
            return operand1 + operand2;
        }
        if(operator == "-"){
            return operand1 - operand2;
        }
        if(operator == "*"){
            return operand1 * operand2;
        }
        if(operator == "/"){
            return operand1 / operand2;
        }
        return 0;
    }
}
