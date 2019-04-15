import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Manager {
    // 클래스 변수 or 상수
    private List<Car> carList;
    private Integer tryCount;

    // 인스턴스 변수
    private User user;
    private Util util;
    private InputError inputError;

    Manager(){
        user = new User();
        util = new Util();
        inputError = new InputError();
        carList = new ArrayList<>();
    }

    public void startGame(){
        while(!firstQuery());
        while(!secondQuery());
        printExecution();
        disposeWinning();
    }

    public int getMaxPosition(){
        int ret = 0;
        for(int i=0; i<carList.size(); i++) {
            ret = Math.max(ret, carList.get(i).getPosition());
        }
        return ret;
    }

    public WinningCar getWinningCar(Car car, int maxPostion){
        if(car.getPosition() == maxPostion){
            return new WinningCar(car.getName());
        }
        return null;
    }

    public void printWinning(List<WinningCar> winningCarList){
        for(int i=0; i<winningCarList.size()-1; i++){
            System.out.print(winningCarList.get(i).getName() + ", ");
        }
        System.out.println(winningCarList.get(winningCarList.size()-1).getName() + "가 최종 우승했습니다.");
    }

    public void disposeWinning(){
        List<WinningCar> winningCarsList = new ArrayList<>();
        int maxPostion = getMaxPosition();
        WinningCar winningCar;
        for(int i=0; i<carList.size(); i++){
            winningCar = getWinningCar(carList.get(i), maxPostion);
            if(winningCar != null) winningCarsList.add(winningCar);
        }
        printWinning(winningCarsList);
    }

    public void printExecution(){
        System.out.println("실행 결과");
        for(int i=0; i<tryCount; i++){
            exeForward();
            printIthTurn();
        }
    }

    public void printPole(int position){
        for(int i=0; i<position; i++){
            System.out.print('-');
        }
        System.out.println();
    }

    public void printIthTurn(){
        for(int i=0; i<carList.size(); i++){
            System.out.print(carList.get(i).getName() + " : ");
            printPole(carList.get(i).getPosition());
        }
        System.out.println();
    }

    public void exeForward(){
        for(int i=0; i<carList.size(); i++){
            if(4 <= util.getRandomNumber()){
                carList.get(i).forward();
            }
        }
    }


    public boolean secondQuery(){
        System.out.println("시도할 회수는 몇회인가요?");
        String ret = user.inputTryCount();
        if(!inputError.CheckFormatError(ret) || !inputError.CheckMinusError(Integer.parseInt(ret))){
            return false;
        }
        tryCount = Integer.parseInt(ret);
        return true;
    }

    public boolean firstQuery(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carList = util.tokenize(user.inputCarNames());
        for(int i=0; i<carList.size(); i++){
            if(!inputError.checkLengthError(carList.get(i).getName().length())){
                return false;
            }
        }
        return true;
    }

}
