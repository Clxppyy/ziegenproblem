import java.util.ArrayList;
import java.util.Objects;

public class DoorCreation implements ReadingInput{

    public DoorCreation(String label) {
    }

    //Declarations
    int carCounter;
    double goatCounter;
    int counter = 0;

    //List-Declarations
    ArrayList<DoorCreation> objectList = new ArrayList<>();

    //Getter
    public Boolean getLabel(String label, int iterator, DoorCreation starter){
        if (Objects.equals(label, starter.objectList.get(iterator))){
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
                objectList.add(goat);
                messenger(i);
            }
            else {
                objectList.add(car);
                messenger(i);
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

    void selection(DoorCreation starter) {
        int iterator = 0;
        int markCarAt = 0;
        int markGoatAt = 0;
        int input = readingInt();
        if (input > 0 && input <= 3) {
            for (DoorCreation door : starter.objectList) {
                if (getLabel("Auto", iterator, starter)) {
                    markCarAt = iterator;
                    System.out.println("AUTO BEI:" + markCarAt);
                } else {
                    iterator++;
                    markGoatAt = iterator;
                    System.out.println("ZIEGE BEI:" + markGoatAt);
                }
            }
            System.out.println("Wollen Sie weiterhin bei Ihrer Wahl bleiben:");
            messenger(input);
            System.out.println("Eine Ziege befindet sich in:");
            messenger(markGoatAt);
            if (readingAnswer().equals("Ja")) {
                if (input == markCarAt + 1){
                    System.out.println("SIE HABEN EIN AUTO GEWONNEN!");
                }
                else {
                    System.out.println("Schade... Dahinter befindet sich nur eine Ziege!");
                }
            } else if (readingAnswer().equals("Nein")){
                System.out.println("Welche Tür wollen Sie stattdessen öffnen?");
                readingInt();
                if (input == markCarAt + 1){
                    System.out.println("SIE HABEN EIN AUTO GEWONNEN!");
                }
                else {
                    System.out.println("Schade... Dahinter befindet sich nur eine Ziege!");
                }
            }
        }
    }
}