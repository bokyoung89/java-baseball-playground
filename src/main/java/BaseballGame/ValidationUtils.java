package BaseballGame;

public class ValidationUtils {

    private static final int MIN_NO = 1;
    private static final int MAX_NO = 9;

    public static boolean validNo(int no) {

/*      //리팩토링 전
        if(no >= 1 && no <= 9){
            return true;
        }
        return false;*/

        //리팩토링 후
        return no >= MIN_NO && no <= MAX_NO;
    }
}
