package entity.gamecharacter;

/**
 * Représente un personnage de type Magicien dans le jeu.
 * <p>
 * Possède moins de points de vie mais une force initiale supérieure.
 * Les magiciens peuvent interagir avec les sorts.
 */
public class Wizard extends GameCharacter {
    public Wizard(String playerName) {
        super(playerName, 6, 8);
    }
    @Override
    public String toString() {
        return String.format("Personnage : %s (Wizard), Vie : %d, Force : %d",
                name, life, strength);
    }
}
