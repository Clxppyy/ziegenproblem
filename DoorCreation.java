import java.util.ArrayList;
import java.util.Objects;

public class DoorCreation{

    public DoorCreation(String label) {
        super();
    }

    //Declarations
    int carCounter;
    double goatCounter;
    int counter = 0;

    //List-Declarations
    ArrayList<DoorCreation> objectList = new ArrayList<>();

    //Getter
    public Boolean getLabel(String label, int iterator){
        if (Objects.equals(label, objectList.get(iterator))){
            return true;
        }
        else {
            return false;
        }
    }

    //Creating 3 Objects to determine the one with the car
    void creation(){
        DoorCreation goat = new DoorCreation("Ziege");
        DoorCreation car = new DoorCreation("Auto");
        for (int i = 1; i <= 3; i++){
            if(getRandomObj()){
                objectList.add(goat); //Problem: objectList bleibt size 0, bzw. goat und Auto werden nt hinzugefügt
                messenger(i);
            }
            else {
                objectList.add(car);
                messenger(i);
            }
        }
    }

    //Messenger
    Boolean messenger(int i){ //eventueller fix
        if (counter == 0 && i == 0){
            counter++;
        }
        else {
            System.out.println(i + ". Tür");
        }
        return true;
    }

    //Section, where the sorting is taking place
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public Boolean getRandomObj(){
        if (getRandomNumber(1, 4) == 1 && carCounter == 0 && goatCounter < 1){
            goatCounter = goatCounter + 0.5;
            return true;
        }
        else if (carCounter != 1){
            carCounter++;
            return false;
        }
        goatCounter++;
        return true;
    }
}