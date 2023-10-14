public class DoorSelection extends DoorCreation implements ReadingInput{

    DoorCreation doorCreation;

    public DoorSelection(String label, DoorCreation doorCreation) {
        super(label);
        this.doorCreation = doorCreation;
    }

    void selection() {
        int iterator = 0;
        int markCarAt = 0;
        int markGoatAt = 0;
        int input = readingInt();
        if (input > 0 && input <= 3) {
            for (DoorCreation door : doorCreation.objectList) {
                if (door.getLabel("Auto", iterator)) {
                    markCarAt = iterator;
                    System.out.println(markCarAt);
                    System.out.println(doorCreation.objectList.get(iterator));
                } else {
                    iterator++;
                    markGoatAt = iterator;
                    System.out.println(markGoatAt);
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