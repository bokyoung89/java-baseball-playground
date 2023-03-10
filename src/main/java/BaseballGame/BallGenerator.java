package BaseballGame;

import java.util.ArrayList;
import java.util.List;

public class BallGenerator {

    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;


    private static boolean exists(List<Integer> num, int index){
        for(int i=0; i < num.size(); i++) {
            if(num.contains(index)){
                return true;
            }
        }
        return false;
    }
    public List<Integer> createRandomNumbers() {  //List란 자바에서 제공하는 컬렉션

        List<Integer> value = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < 3; i++) {
            do{
                index  = (int)((Math.random() * MAX_NUMBER) + MIN_NUMBER);
            }while(exists(value,index)); // true인 경우 계속해서 괄호 안의 내용을 반복 수행한다.
            value.add(index);
        }
        return value;
    }
}
