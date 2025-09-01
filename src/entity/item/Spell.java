package entity.item;
import entity.GameCharacter;
import entity.Wizard;

import entity.EntityBase;

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
