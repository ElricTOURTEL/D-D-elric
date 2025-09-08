package entity.item.weapon;
import entity.gamecharacter.GameCharacter;
import entity.gamecharacter.Warrior;
import entity.item.Item;

/**
 * Représente une arme pouvant être équipée uniquement par un {@link entity.gamecharacter.Warrior}.
 * Gère le nom et le bonus de dégâts associé à l'arme.
 */
public class Weapon extends Item {
    private final int damageBonus;

    public Weapon(String name, int damageBonus) {
        super(name);
        this.damageBonus = damageBonus;
    }
    public int getDamageBonus() { return damageBonus; }

    @Override
    public boolean canBeUsedBy(GameCharacter c) {
        return c instanceof Warrior;
    }

    @Override
    public String toString() {
        return "Weapon{name='" + name + "', damageBonus=" + damageBonus + "}";
    }
}
