package entity;

public class Wizard extends GameCharacter {
    public Wizard(String playerName) {
        super(playerName, "entity.Wizard");
        this.life=6;
        this.strength=8;
    }
}
