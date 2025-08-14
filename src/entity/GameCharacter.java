package entity;

public class GameCharacter {
    String type;
    String name;
    public int life;
    public int strength;

    public GameCharacter(String playerName, String type) {
        this.type = type;
        this.name = playerName;
        life = 0;
        strength = 0;
    }
}
