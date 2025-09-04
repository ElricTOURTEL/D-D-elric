package menu;

import core.Board;
import core.Moving;
import entity.gamecharacter.GameCharacter;
import entity.gamecharacter.Warrior;
import entity.gamecharacter.Wizard;
import message.Output;

import java.util.Scanner;

public class Menu {
    private final Scanner sc = new Scanner(System.in);
    private final Output output = new Output(sc);

    public void startMenu() {
        boolean replay;
        do {
            output.gameMenu();
            String choix = sc.nextLine().trim().toLowerCase();

            if (choix.startsWith("q")) {
                System.out.println("À bientôt !");
                return; // quitter le jeu
            }

            start(); // lance une partie
            System.out.print("Voulez-vous rejouer ? (o/n) : ");
            replay = sc.nextLine().trim().equalsIgnoreCase("o");

        } while (replay);
    }

    public void start() {
        // --- Board de 10 cases ---
        Board board = new Board(64);


        // System.out.println(board); // outil de debug pour visualiser le board post generation

        // --- Choix du perso ---
        String characterType = output.chooseCharacter();  // Guerrier/Magicien
        String name = output.nameCharacter();
        // String difficulty = output.chooseDifficulty();
        output.resume(name, characterType, "Facile");

        GameCharacter hero = characterType.equalsIgnoreCase("Guerrier")
                ? new Warrior(name)
                : new Wizard(name);

        // --- Déplacements ---
        Moving moving = new Moving(board, output);
        moving.placeAtStart(hero);

        final int lastIndex = board.size() - 1;
        while (moving.getPosition() < lastIndex) {
            if (!output.askRoll()) {
                System.out.println("Partie quittée.");
                return;
            }
            moving.moveByDice();
            if (hero.getLife() <= 0) {
                output.characterKO(name);
                return;
            }
        }

        output.endMessage();
    }
}
