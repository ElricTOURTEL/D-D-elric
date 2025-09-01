package entity;

public class Monster extends EntityBase {
    private int life;
    private final int strength;

    public Monster(String name, int life, int strength) {
        super(name);
        this.life = life;
        this.strength = strength;
    }

    public int getLife() { return life; }
    public int getStrength() { return strength; }
    public void takeDamage(int amount) { this.life -= amount; }

    @Override
    public String toString() {
        return String.format("Monster{name='%s', life=%d, strength=%d}", name, life, strength);
    }
}
