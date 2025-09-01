package message;

import java.util.Scanner;

public class Output {
    private final Scanner sc;

    public Output(Scanner sc) {
        this.sc = sc;
    }

    public void gameMenu(){
        System.out.println("Bienvenue sur le menu du jeu Dungeon & Dragons :");
        System.out.println(" - Commencer une partie");
        System.out.println(" - Quitter le jeu");
        System.out.print("Votre choix ? ");
    }

    public void endMessage(){
        System.out.println("Arrivée à la fin !");
    }

    public String chooseCharacter() {
        String choice;
        while (true) {
            try {
                System.out.print("Choisissez votre personnage (Guerrier / Magicien) : ");
                choice = sc.nextLine().trim();

                // Vérifie si le choix est valide
                if (!choice.equalsIgnoreCase("Guerrier") && !choice.equalsIgnoreCase("Magicien")) {
                    throw new InvalidChoiceException("Entrée invalide ! Veuillez taper 'Guerrier' ou 'Magicien'.");
                }

                // Retourne un format propre (Première lettre majuscule)
                return choice.substring(0, 1).toUpperCase() + choice.substring(1).toLowerCase();

            }catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String nameCharacter() {
        String choice;
        while (true) {
            try {
                System.out.print("Choisissez votre nom : ");
                choice = sc.nextLine().trim();
                if (choice.isEmpty()) {
                    throw new InvalidChoiceException("Votre entrée est vide veuillez saisir un nom");
                }
                return choice.substring(0, 1).toUpperCase() + choice.substring(1).toLowerCase();

            } catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String chooseDifficulty() {
        String difficulty;
        while (true) {
            try {
                System.out.println("Difficulté : Facile / Moyen / Difficile");
                System.out.print("Votre choix ? ");
                difficulty = sc.nextLine().trim();

                // Vérifie si l'entrée est valide
                if (!difficulty.equalsIgnoreCase("Facile") &&
                        !difficulty.equalsIgnoreCase("Moyen") &&
                        !difficulty.equalsIgnoreCase("Difficile")) {
                    throw new InvalidChoiceException(
                            "Entrée invalide ! Veuillez taper 'Facile', 'Moyen' ou 'Difficile'."
                    );
                }

                // Retourne le mot formaté proprement (Première lettre majuscule)
                return difficulty.substring(0, 1).toUpperCase() + difficulty.substring(1).toLowerCase();

            } catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void resume(String who, String charType, String difficulty) {
        System.out.printf("OK %s le %s joue en %s%n", who, charType, difficulty);
    }
    public boolean askRoll(){
        System.out.print("[Entrée] pour lancer le dé, ou 'q' pour quitter : ");
        String s = sc.nextLine().trim().toLowerCase();
        return !s.startsWith("q");
    }

    public void moveMessage(String who, int steps, int from, int to){
        System.out.printf("🎲 %s avance de %d cases (de %d à %d)%n", who, steps, from, to);
    }

    public void pickupWeapon(String who, String weaponName, int bonus){
        System.out.printf("🗡 %s ramasse %s (force +%d)%n", who, weaponName, bonus);
    }

    public void pickupSpell(String who, String spellName, int power){
        System.out.printf("✨ %s apprend %s (puissance %d)%n", who, spellName, power);
    }

    public void encounterMonster(String who, String monsterName, int monsterStr, int monsterLife){
        System.out.printf("👹 Rencontre : %s affronte %s (force %d) et (Points de vie %d)%n", who, monsterName, monsterStr, monsterLife);
    }

    public void damageTaken(String who, int amount, int remaining){
        System.out.printf("💥 %s subit %d dégâts (PV restants : %d)%n", who, amount, remaining);
    }
    public void cannotPickup(String who, String itemName) {
        System.out.printf("🚫 %s ne peut pas ramasser %s.%n", who, itemName);
    }
    public void characterKO(String who) {
        System.out.printf("💀 %s est K.O.%n", who);
        System.out.println("Game Over");
    }
}