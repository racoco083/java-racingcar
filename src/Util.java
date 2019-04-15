import java.util.*;

public class Util {
    public List<Integer> numberToList(Integer number){
        List<Integer> numberList = new ArrayList<>();
        int size = number.toString().length();
        for(int i=0; i<size; i++){
            numberList.add(number%10);
            number/=10;
        }
        Collections.reverse(numberList);
        return numberList;
    }

    public List<Car> tokenize(String input){
        List<Car> names = new ArrayList<>();
        StringTokenizer token = new StringTokenizer(input, ",");
        while(token.hasMoreTokens()){
            names.add(new Car(token.nextToken()));
        }
        return names;
    }

    /*
    public Vector<Car> tokenize(String input){
        Vector<Car> carList = new Vector<Car>();
        StringTokenizer token = new StringTokenizer(input, ",");
        while(token.hasMoreTokens()){
            carList.add(new Car(token.nextToken()));
        }
        return carList;
    }
    */

    public Integer getRandomNumber(){
        Random random = new Random();
        return random.nextInt(10); //0~9
    }
}
