import java.util.Objects;

public class DoorSelection extends DoorCreation implements ReadingInput{

    public DoorSelection(String label) {
        super(label);
    }

    void selection() {
        int iterator = 0;
        int markCarAt = 0;
        int input = readingInt();
        if (input > 0 && input <= 3) {
            System.out.println("Wollen Sie weiterhin bei Ihrer Wahl: " + messenger(input) + " bleiben?");
            for (DoorCreation door : objectList) {
                if (door.getLabel("Auto", iterator)) {
                    iterator = markCarAt;
                    System.out.println(markCarAt);
                } else {
                    iterator++;
                }
            }
            if (readingAnswer().equals("Ja") && input == markCarAt + 1) {
                System.out.println("SIE HABEN EIN AUTO GEWONNEN!");
            } else if (readingAnswer().equals("Nein")){
                //Hier ein weiterer Versuch mit Hinweis auf Schaf
                selection();
            }
        }
    }
}