package entity.gamecharacter;

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
