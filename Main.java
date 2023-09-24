public class Main extends DoorSelection{

    public Main(String label) {
        super(label);
    }

    public static void main(String[] args){
        //Object starter with exclusive number -1 is just there to activate that shit via polymorphism.
        DoorSelection starterSelector = new Main("Starter");
        starterSelector.startingCreation();
        if (starterSelector.activator){
            starterSelector.selection();
        }
    }
}