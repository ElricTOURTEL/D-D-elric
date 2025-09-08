package core;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Implémentation d'un dé classique reposant sur l'aléatoire standard.
 * Utilise {@link ThreadLocalRandom} pour générer les valeurs.
 */
public class RandomDice implements Dice{
    @Override
    public int roll(int faces){
        return ThreadLocalRandom.current().nextInt(1, faces +1);
    }
}
