import java.text.NumberFormat;

public class InputError {
    private String NUMBER_FORMAT_ERROR = "숫자가 아닌 값이 입력되었습니다. 다시 입력해주세요.";
    private String MINUS_ERROR = "양이 아닌 정수가 입력되었습니다.  다시 입력해주세요.";
    private String LENGTH_ERROR = "자동차 이름이 6자 이상입니다. 다시 입력해주세요.";

    public boolean checkLengthError(int length){
        if(length > 5){
            System.out.println(LENGTH_ERROR);
            return false;
        }
        return true;
    }

    public boolean CheckFormatError(String input){
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            System.out.println(NUMBER_FORMAT_ERROR);
            return false;
        }
        return true;
    }

    public boolean CheckMinusError(int input){
        if(input < 0) {
            System.out.println(MINUS_ERROR);
            return false;
        }
        return true;
    }

}
