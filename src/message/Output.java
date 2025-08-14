package message;

import java.util.Scanner;

public class Output {
    public static void diceMessage(int dice, boolean finish){
        if(!finish){
            System.out.println("Résultat du dès : " + dice);
        }
    }
    public static void endMessage(){
        System.out.println("Arrivée à la fin!");
    }
    public static String chooseCharacter(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Veuillez choisir votre personnage entre Guerrier et Magicien :");
        String myCharacter = sc.nextLine();
        return myCharacter;
    }
    public static String nameCharacter(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Veuillez choisir votre nom :");
        String myName = sc.nextLine();
        return myName;
    }
}
