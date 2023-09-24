import java.util.List;
import java.util.Objects;

public class DoorSelection extends DoorCreation implements ReadingInput{

    private final String label;

    boolean activator;

    public DoorSelection(String label) {
        super(label);
        this.label = label;
    }

    void startingCreation(){
        //Polymorphism
        DoorCreation starterCreator = new DoorSelection("Starter");
        starterCreator.creation();
        if (starterCreator.messenger(false)){
            activator = true;
        }
    }

    void selection(){
        if(iList.contains(readingInt())){
            messenger(firstSelect);
            if(i == 1){
                System.out.println("Wollen Sie weiterhin bei Ihrer Wahl: " + i + " bleiben?");
                if (readingAnswer().equals("Ja")){
                    if(originalList.contains(label) && Objects.equals(label, car)){
                        System.out.println("SIE HABEN EIN AUTO GEWONNEN!");
                    }
                    else {
                        System.out.println("Schade, nur ein Schaf!");
                    }
                }
                else {
                    if(clonedList.contains(label) && Objects.equals(label, car)){
                        System.out.println("SIE HABEN EIN AUTO GEWONNEN!");
                    }
                    else {
                        System.out.println("Schade, nur ein Schaf!");
                    }
                }
            }
            else {
                System.out.println("Wollen Sie weiterhin bei Ihrer Wahl: " + i + " bleiben?");
                if (readingAnswer().equals("Ja")){
                    if(clonedList.contains(label) && Objects.equals(label, car)){
                        System.out.println("SIE HABEN EIN AUTO GEWONNEN!");
                    }
                    else {
                        System.out.println("Schade, nur ein Schaf!");
                    }
                }
                else {
                    if(clonedList.contains(label) && Objects.equals(label, car)){
                        System.out.println("SIE HABEN EIN AUTO GEWONNEN!");
                    }
                    else {
                        System.out.println("Schade, nur ein Schaf!");
                    }
                }
                }
            }
        else{
            System.out.println("Entschuldigung, aber diese Auswahl gibt es nicht.");
            selection();
        }

        }
    }