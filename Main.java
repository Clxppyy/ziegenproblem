public class Main extends DoorSelection{
    public Main(String label) {
        super(label);
    }

    public static void main(String[] args){
        //Object starter with exclusive string "Starter" is just there to activate that shit via polymorphism.
        DoorSelection starterSelector = new Main("Starter");
        starterSelector.creation();
        if (starterSelector.messenger(0)){
            starterSelector.selection();
        }
    }
}