package Ziegen;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class ReadingInput {
    static int readingInt(){
        try{
            Scanner scannerObj = new Scanner(System.in);
            return Integer.parseInt(scannerObj.nextLine());
        }
        catch (InputMismatchException | NumberFormatException e){
            System.out.println("Entschuldigung, leider können Sie nur Zahlen eintippen.");
            readingInt();
        }
        return -1;
    }

    static String readingAnswer(){
        try{
            Scanner scannerObj = new Scanner(System.in);
            String input = scannerObj.nextLine();
            if (Objects.equals(input, "Ja")){
                return input;
            }
            else if (Objects.equals(input, "Nein")){
                return input;
            }
            else {
                System.out.println("Entschuldigung, das ist kein möglicher Operator.\nVersuchen Sie es bitte erneut mit 'Ja' oder 'Nein'.");
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