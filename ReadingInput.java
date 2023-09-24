import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public interface ReadingInput {
    default int readingInt(){
        try{
            Scanner scannerObj = new Scanner(System.in);
            return scannerObj.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Entschuldigung, leider können Sie nur Zahlen eintippen.");
            readingInt();
        }
        return -1;
    }

    default String readingAnswer(){
        try{
            Scanner scannerObj = new Scanner(System.in);
            if (Objects.equals(scannerObj.nextLine(), "Ja")){
                return scannerObj.nextLine();
            }
            else if (Objects.equals(scannerObj.nextLine(), "Nein")){
                return scannerObj.nextLine();
            }
            else {
                System.out.println("Entschuldigung, aber das ist kein möglicher Operator.");
                readingAnswer();
            }
        }
        catch (IllegalStateException e){
            System.out.println("Fehler.");
            readingAnswer();
        }
        return "Return-Fehler";
    }
}
