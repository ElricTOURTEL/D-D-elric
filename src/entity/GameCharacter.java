package entity;

public abstract class GameCharacter extends EntityBase {
    protected int life;
    protected int strength;
    protected int maxLife;

    protected GameCharacter(String playerName, int life, int strength) {
        super(playerName);
        this.life = life;
        this.strength = strength;
        this.maxLife = life;
    }
    public int getLife() { return life; }
    public int getMaxLife() { return maxLife; }
    public int getStrength() { return strength; }
    public void addStrength(int bonus) { this.strength += bonus; }
    public int healthUrself(int bonus){
        this.life += bonus;
        int supposedAmount=this.life;
        if(this.life > maxLife){
            this.life = maxLife;
        }
        return supposedAmount;
    }
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
