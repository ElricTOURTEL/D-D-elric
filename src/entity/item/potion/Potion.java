package entity.item.potion;

import entity.gamecharacter.GameCharacter;
import entity.item.Item;

public class Potion extends Item {
    private final int healAmount;

    public Potion(String name, int healAmount) {
        super(name);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }

    @Override
    public boolean canBeUsedBy(GameCharacter c) {
        return true;
    }

    @Override
    public String toString() {
        return "Potion{name='" + name + "', healAmount=" + healAmount + "}";
    }
}