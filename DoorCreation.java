import java.util.ArrayList;
import java.util.Objects;

public class DoorCreation implements Cloneable{
    int i;

    //Empty constructor needed for submitting the objects (goat or car)

    public DoorCreation(String label){
    }

    //Declarations

    final String goat = "Ziege";
    final String car = "Auto";
    int carCounter;
    double goatCounter;
    int number = 1;

    //List-Declarations

    ArrayList<Integer> iList = new ArrayList<>();
    ArrayList<DoorCreation> originalList = new ArrayList<>();
    ArrayList<DoorCreation> clonedList = new ArrayList<>();

    //Messenger-Switches (also Declarations (i have no fcking clue how event listeners work in java and nor I have
    //the nerves to try them out now...))

    boolean originListSwitch;
    boolean cloneListSwitch;
    boolean firstSelect;


    //Creating 3 Objects to determine the one with the car

    void creation(){

        for (int i = 1; i < 3; i++){
            this.i = i;
            iList.add(i);

            String obj = getRandomObj(goat, car);
            //System.out.println(obj);                <---              //FOR SHOWING RESULTS OUT-COMMENT!

            if(i == 1){
                DoorCreation door = new DoorCreation(obj);
                originalList.add(door);
                messenger(originListSwitch = true);
            }

            for (DoorCreation originalObject : originalList) {
                DoorCreation clonedObject = originalObject.clone();
                clonedList.add(clonedObject);
                number++;
                if(number == 2){
                    iList.add(3);
                }
                messenger(cloneListSwitch = true);
            }
        }
    }

    //Messenger

    Boolean messenger(boolean bool){
        if(!firstSelect){

            if (originListSwitch){
                System.out.println(i + ". Tür");
                originListSwitch = false;
            }
            if (cloneListSwitch){
                System.out.println(number + ". Tür");
                cloneListSwitch = false;
            }
        }
        else{
            if(originalList.contains(goat) || clonedList.contains(goat)){
                System.out.println(i + ". Tür: Ziege");
            }
        }
        return true;
    }

    //Section, where the sorting is taking place

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public String getRandomObj(String goat, String car){
        if (getRandomNumber(1, 3) == 1 && carCounter == 0 && goatCounter < 1){
            goatCounter = goatCounter + 0.5;
            return goat;
        }
        else if (carCounter != 1){
            carCounter++;
            return car;
        }
        goatCounter++;
        return goat;
    }

    //Object-Cloning via Mother-Child relation

    public DoorCreation clone() {
        try {
            return (DoorCreation) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}