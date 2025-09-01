package entity;

public abstract class GameCharacter extends EntityBase {
    protected int life;
    protected int strength;

    protected GameCharacter(String playerName, int life, int strength) {
        super(playerName);
        this.life = life;
        this.strength = strength;
    }
    public int getLife() { return life; }
    public int getStrength() { return strength; }
    public void addStrength(int bonus) { this.strength += bonus; }
    public boolean takeDamage(int amount) {
        this.life -= amount;
        if (this.life <= 0) {
            this.life = 0;
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s{name='%s', life=%d, strength=%d}", getClass().getSimpleName(), name, life, strength);
    }
}
