public class Main extends DoorSelection{
    public Main(String label) {
        super(label);
    }

    public static void main(String[] args){
        //Object starter with exclusive string "Starter" is just there to activate that shit via polymorphism.
        DoorCreation starter = new Main("Starter");
        starter.creation();
        if (starter.messenger(0)){
            ((DoorSelection) (starter)).selection();
        }
    }
}