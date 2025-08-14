package entity;

public class Warrior extends GameCharacter {
    public Warrior(String playerName) {
        super(playerName, "entity.Warrior");
        this.life=10;
        this.strength=5;
    }
}
