package entity.gamecharacter;

/**
 * Représente un personnage de type Guerrier dans le jeu.
 * <p>
 * Dispose de points de vie et de force plus élevés que d'autres personnages.
 * Les warriors bénéficient de bonus spécifiques sur certaines interactions (armes).
 */
public class Warrior extends GameCharacter {
    public Warrior(String playerName) { super(playerName, 40, 5); }


    @Override
    public String toString() {
        return String.format("Personnage : %s (Warrior), Vie : %d, Force : %d",
                name, life, strength);
    }
}