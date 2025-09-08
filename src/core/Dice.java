package core;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Interface représentant un dé de jeu.
 * <p>
 * Un {@code Dice} est une abstraction qui définit comment produire
 * une valeur aléatoire (ou fixée, pondérée...) comprise entre 1 et
 * un nombre de faces donné. Cela permet de remplacer facilement
 * l'implémentation (ex. {@code RandomDice}, {@code WeightedDice})
 * sans changer le reste du code.
 *
 * <h2>Méthodes utilitaires</h2>
 * Fournit par défaut deux méthodes pratiques :
 * <ul>
 *   <li>{@link #d6()} pour lancer un dé à 6 faces (valeur 1..6)</li>
 *   <li>{@link #d20()} pour lancer un dé à 20 faces (valeur 1..20)</li>
 * </ul>
 *
 * Exemple d'utilisation :
 * <pre>{@code
 * Dice dice = new RandomDice();
 * int result = dice.d6(); // valeur aléatoire entre 1 et 6
 * }</pre>
 */
public interface Dice {
    /**
     * Lance un dé avec le nombre de faces indiqué.
     *
     * @param faces nombre de faces (doit être ≥ 1)
     * @return un entier compris entre 1 et {@code faces}
     */
    int roll(int faces);

    /**
     * Lance un dé à 6 faces.
     *
     * @return entier entre 1 et 6
     */
    default int d6() { return roll(6); }

    /**
     * Lance un dé à 20 faces.
     *
     * @return entier entre 1 et 20
     */
    default int d20() { return roll(20); }
}

/*
 Ancienne version statique, remplacée par une interface polymorphe :

 public final class Dice {
     private Dice() {}
     public static int d6() { return ThreadLocalRandom.current().nextInt(1,7); }
     public static int d20(){ return ThreadLocalRandom.current().nextInt(1, 21); }
 }
*/
