package entity.item.potion;

import entity.gamecharacter.GameCharacter;
import entity.item.Item;

/**
 * Représente une potion de soin utilisable par tous les personnages.
 * Stocke le nom de la potion et la quantité de points de vie rendus.
 */
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