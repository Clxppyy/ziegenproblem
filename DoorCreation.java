import java.util.ArrayList;
import java.util.Objects;

public class DoorCreation implements ReadingInput{

    public DoorCreation(DoorCreation label) {
        this.label = label;
    }

    //Declarations
    public DoorCreation label;
    int carCounter;
    double goatCounter;
    int counter = 0;

    //List-Declarations
    ArrayList<DoorCreation> objectList = new ArrayList<>();

    //Getter
    public Boolean getLabel(DoorCreation label, DoorCreation starter){
        if (label == starter){
            return true;
        }
        else {
            return false;
        }
    }

    //Creating 3 Objects to determine the one with the car
    void creation(DoorCreation starter){
        DoorCreation goat = new DoorCreation(null);
        DoorCreation car = new DoorCreation(null);
        for (int i = 1; i <= 3; i++){
            if(getRandomObj()){
                objectList.add(goat);
                messenger(i);
            }
            else {
                objectList.add(car);
                messenger(i);
            }
        }
        if (starter.messenger(0)){
            starter.selection(starter, car);
        }
    }

    //The actual game, selecting one object
    void selection(DoorCreation starter, DoorCreation car) {
        int iterator = 0;
        int markCarAt = 0;
        int markGoatAt;
        ArrayList<Integer> goatMarker =  new ArrayList<>();
        int input = readingInt();
        if (input > 0 && input <= 3) {
            for (DoorCreation door : starter.objectList) {
                if (getLabel(car, door)) {
                    markCarAt = iterator;
                } else {
                    markGoatAt = iterator;
                    goatMarker.add(markGoatAt);
                }
                iterator++;
            }
            System.out.println("Eine Ziege befindet sich in:");
            //So that another door is opened excluding the one the user chose
            for (Integer Element: goatMarker) {
                if (Element.equals(input - 1)) {
                    goatMarker.remove(0);
                    messenger(goatMarker.get(0) + 1);
                }
                else{
                    messenger(goatMarker.get(0) + 1);
                    break;
                }
            }
            System.out.println("Wollen Sie weiterhin bei Ihrer Wahl bleiben:");
            messenger(input);
            if (readingAnswer().equals("Ja")) {
                checker(input, markCarAt);
            } else {
                System.out.println("Welche Tür wollen Sie stattdessen öffnen?");
                int inputForChecker = readingInt();
                checker(inputForChecker, markCarAt);
            }
        }
        else{
            System.out.println("Bitte einer der Türen auswählen!");
            selection(starter, car);
        }
    }

    //Checking for results
    void checker(int input,int markCarAt){
        if (input == markCarAt + 1){
            System.out.println("SIE HABEN EIN AUTO GEWONNEN!");
            System.out.println("Neuer Versuch?");
            if (Objects.equals(readingAnswer(), "Ja")){
                Main.main(null);

            }
            else {
                System.exit(0);
            }
        }
        else {
            System.out.println("Schade... Dahinter befindet sich nur eine Ziege!");
            System.out.println("Neuer Versuch?");
            if (Objects.equals(readingAnswer(), "Ja")){
                Main.main(null);
                objectList = null; //pathetic attempt to eventuell clear the memory so the doors aren't always sorted the same
            }
            else {
                System.exit(0);
            }
        }
    }

    //Messenger
    Boolean messenger(int i){
        if (counter == 0 && i == 0){ //Needs to be here so that I can start selection in Main Class without worrying about any unwanted outputs, i --> 0 for irrelevant outputs
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