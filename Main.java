public class Main{

    public static void main(String[] args){
        DoorCreation starter = new DoorCreation("Starter");
        starter.creation();
        if (starter.messenger(0)){
            DoorSelection starterSelection = new DoorSelection("Starter", starter);
            starterSelection.selection();
        }
    }
}