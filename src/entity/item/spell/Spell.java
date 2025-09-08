package entity.item.spell;
import entity.gamecharacter.GameCharacter;
import entity.gamecharacter.Wizard;

import entity.item.Item;

/**
 * Représente un sort que seul un {@link entity.gamecharacter.Wizard} peut utiliser.
 * Contient la notion de puissance et hérite du nom depuis {@link Item}.
 */
public class Spell extends Item {
    private final int power;

    public Spell(String name, int power) {
        super(name);
        this.power = power;
    }

    public int getPower() {
        return power;
    }
    @Override
    public boolean canBeUsedBy(GameCharacter c) {
        return c instanceof Wizard;
    }
    @Override
    public String toString() {
        return "Spell{name='" + name + "', power=" + power + "}";
    }
}
