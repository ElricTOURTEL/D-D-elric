package entity.monster;

import entity.EntityBase;

/**
 * Représente un monstre générique sur le plateau.
 * Dispose de points de vie et de force, ainsi que d'une gestion du statut vivant/mort.
 */
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
    public boolean takeDamage(int amount) {
        this.life -= amount;
        if (this.life <= 0) {
            this.life = 0;
            return false;
        }
        return true;}
    public boolean isAlive(){
        if(this.life == 0)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("Monster{name='%s', life=%d, strength=%d}", name, life, strength);
    }
}
