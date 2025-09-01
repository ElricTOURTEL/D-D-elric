package entity;

public class Warrior extends GameCharacter {
    public Warrior(String playerName) { super(playerName, 10, 5); }


    @Override
    public String toString() {
        return String.format("Personnage : %s (Warrior), Vie : %d, Force : %d",
                name, life, strength);
    }
}