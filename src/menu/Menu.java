package menu;

import core.Board;
import core.Moving;
import entity.GameCharacter;
import entity.Monster;
import entity.Warrior;
import entity.Wizard;
import entity.item.Spell;
import entity.item.Weapon;
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
        Board board = new Board(10);

        // --- Cases "surprise" & monstre que TU veux ---
        board.getCell(3).add(new Weapon("Épée en fer", 3));
        board.getCell(5).add(new Spell("Boule de feu", 5));
        board.getCell(6).add(new Monster("Gobelin", 6, 2));
        board.getCell(7).add(new Monster("Gobelin", 6, 2));
        board.getCell(8).add(new Monster("Gobelin", 6, 2));
        // System.out.println(board);

        // --- Choix du perso ---
        String characterType = output.chooseCharacter();  // Guerrier/Magicien
        String name = output.nameCharacter();
        String difficulty = output.chooseDifficulty();
        output.resume(name, characterType, difficulty);

        GameCharacter hero = characterType.equalsIgnoreCase("Guerrier")
                ? new Warrior(name)
                : new Wizard(name);

        // --- Déplacements ---
        Moving moving = new Moving(board, output);
        moving.placeAtStart(hero);
        // de 0 à 9
        final int lastIndex = board.size() - 1; // ici 9
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
