package message;

import java.util.Scanner;

public class Output {
    private final Scanner sc;

    /**
     * Initialise la classe Output avec un scanner d'entrée utilisateur.
     *
     * @param sc instance de Scanner à utiliser pour la saisie
     */
    public Output(Scanner sc) {
        this.sc = sc;
    }

    /**
     * Affiche le menu principal du jeu à l'utilisateur.
     */
    public void gameMenu(){
        System.out.println("Bienvenue sur le menu du jeu Dungeon & Dragons :");
        System.out.println(" - Commencer une partie");
        System.out.println(" - Quitter le jeu");
        System.out.print("Votre choix ? ");
    }

    /**
     * Affiche un message de fin de partie.
     */
    public void endMessage(){
        System.out.println("Arrivée à la fin !");
    }

    /**
     * Demande à l'utilisateur de choisir le type de personnage.
     * Répète la question jusqu'à ce qu'un choix valide soit saisi (« Guerrier » ou « Magicien »).
     * @return le nom du personnage choisi, première lettre en majuscule
     */
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

    /**
     * Demande à l'utilisateur de saisir un nom de personnage.
     * Répète la question jusqu'à ce qu'un nom non vide soit saisi.
     * @return le nom saisi, première lettre en majuscule
     */
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

    /**
     * Demande à l'utilisateur s'il souhaite combattre ou fuir face à un monstre.
     * Répète la question jusqu'à l'obtention d'une saisie valide.
     * @return "Combattre" ou "Fuir" (première lettre en majuscule)
     */
    public String fightOrRun() {
        String choice;
        while(true){
            try {
                System.out.println("Le monstre étant toujours présent que voulez-vous faire ?");
                System.out.println("1- Combattre");
                System.out.println("2- Fuir");
                System.out.print("Votre choix ?");
                choice = sc.nextLine().trim();
                if (!choice.equalsIgnoreCase("Combattre") && !choice.equalsIgnoreCase("Fuir")) {
                    throw new InvalidChoiceException("Entrée invalide ! Veuillez taper 'Combattre' ou 'Fuir'.");
                }
                return choice.substring(0, 1).toUpperCase() + choice.substring(1).toLowerCase();
            } catch (InvalidChoiceException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /*public String chooseDifficulty() {
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
    }*/
    /**
     * Affiche un résumé des choix configuration du joueur.
     * @param who nom du joueur
     * @param charType type de personnage
     * @param difficulty niveau de difficulté
     */
    public void resume(String who, String charType, String difficulty) {
        System.out.printf("OK %s le %s joue en %s%n", who, charType, difficulty);
    }

    /**
     * Demande à l'utilisateur de lancer le dé ou de quitter la partie.
     * @return {@code true} si l'utilisateur souhaite continuer, {@code false} s'il entre 'q'
     */
    public boolean askRoll(){
        System.out.print("[Entrée] pour lancer le dé, ou 'q' pour quitter : ");
        String s = sc.nextLine().trim().toLowerCase();
        return !s.startsWith("q");
    }

    /**
     * Affiche le message de déplacement du personnage suite au lancer de dé.
     * @param who nom du personnage
     * @param steps nombre de cases parcourues
     * @param from position de départ
     * @param to position d'arrivée
     */
    public void moveMessage(String who, int steps, int from, int to){
        System.out.printf("🎲 %s avance de %d cases (de %d à %d)%n", who, steps, from, to);
    }

    /**
     * Affiche un message lorsqu'un personnage ramasse une arme.
     * @param who nom du personnage
     * @param weaponName nom de l'arme
     * @param bonus bonus de force
     */
    public void pickupWeapon(String who, String weaponName, int bonus){
        System.out.printf("🗡 %s ramasse %s (force +%d)%n", who, weaponName, bonus);
    }

    /**
     * Affiche un message lorsqu'un personnage apprend un sort.
     * @param who nom du personnage
     * @param spellName nom du sort
     * @param power puissance du sort
     */
    public void pickupSpell(String who, String spellName, int power){
        System.out.printf("✨ %s apprend %s (puissance %d)%n", who, spellName, power);
    }

    /**
     * Affiche les détails de la rencontre avec un monstre.
     * @param who nom du personnage
     * @param monsterName nom du monstre
     * @param monsterStr force du monstre
     * @param monsterLife points de vie du monstre
     */
    public void encounterMonster(String who, String monsterName, int monsterStr, int monsterLife){
        System.out.printf("👹 Rencontre : %s affronte %s (force %d) et (Points de vie %d)%n", who, monsterName, monsterStr, monsterLife);
    }

    /**
     * Affiche un message de dégâts reçus.
     * @param who cible des dégâts
     * @param amount quantité de dégâts
     * @param remaining points de vie restants
     */
    public void damageTaken(String who, int amount, int remaining){
        System.out.printf("💥 %s subit %d dégâts (PV restants : %d)%n", who, amount, remaining);
    }
    /**
     * Affiche un message lorsque le personnage ne peut pas ramasser un objet.
     * @param who nom du personnage
     * @param itemName nom de l'objet
     */
    public void cannotPickup(String who, String itemName) {
        System.out.printf("🚫 %s ne peut pas ramasser %s.%n", who, itemName);
    }
    /**
     * Affiche un message lorsque le personnage est K.O.
     * @param who nom du personnage
     */
    public void characterKO(String who) {
        System.out.printf("💀 %s est K.O.%n", who);
        System.out.println("Game Over");
    }
    /**
     * Affiche un message lorsqu'il y a déjà un monstre non vaincu sur la case.
     * @param who nom du personnage
     */
    public void monsterOnCurrentCase(String who){
        System.out.printf("%s n'avait pas battu le monstre précédent, un nouveau combat se lance%n", who);
    }
    /**
     * Affiche un message lorsqu'un personnage trouve une potion.
     * @param who nom du personnage
     * @param characterLife vie actuelle
     * @param bonus points de vie soignés
     */
    public void pickupPotion(String who, int characterLife, int bonus){
        System.out.printf("%s a trouvé une potion, vie actuelle (%d) celle ci rendra (%d)%n", who, characterLife, bonus);
    }
    /**
     * Affiche un message lorsque le personnage boit une potion.
     * @param who nom du personnage
     * @param characterLife vie après soin
     */
    public void drinkPotion(String who, int characterLife){
        System.out.printf("%s s'est soigné, il a désormais (%d) points de vie%n", who, characterLife);
    }
    /**
     * Affiche un message si la potion est sans effet (car vie déjà maximale).
     * @param who nom du personnage
     * @param potion nom de la potion
     */
    public void cannotDrinkPotion(String who, String potion){
        System.out.printf("%s a tous ses points de vie, %s sans effet%n", who, potion);
    }
}