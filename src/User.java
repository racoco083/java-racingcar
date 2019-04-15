import java.util.Scanner;

public class User {
    private Scanner scanner;

    User(){
        scanner = new Scanner(System.in);
    }

    public String inputCarNames(){
        String input = scanner.nextLine();
        return input;
    }

    public String inputTryCount(){
        String input = scanner.nextLine();
        return input;
    }
}
