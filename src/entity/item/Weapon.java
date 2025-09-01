package entity.item;
import entity.GameCharacter;
import entity.Warrior;

public class Weapon extends Item {
    private final int damageBonus;

    public Weapon(String name, int damageBonus) {
        super(name);
        this.damageBonus = damageBonus;
    }
    public int getDamageBonus() { return damageBonus; }

    @Override
    public boolean canBeUsedBy(GameCharacter c) {
        return c instanceof Warrior; // <- sans enum, on vérifie le type
    }

    @Override
    public String toString() {
        return "Weapon{name='" + name + "', damageBonus=" + damageBonus + "}";
    }
}
