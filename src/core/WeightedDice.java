package core;

/**
 * Implémentation de {@link Dice} qui renvoie toujours une valeur fixe.
 * <p>
 * Utile pour les tests, simulations ou situations où le hasard doit être contrôlé.
 *
 * @see Dice
 */
public class WeightedDice implements Dice{
    private final int fixedValue;

    public WeightedDice(int value){
        this.fixedValue = value;
    }

    @Override
    public int roll(int faces){
        return fixedValue;
    }
}
