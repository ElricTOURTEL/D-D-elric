package core;

import entity.*;
import entity.item.*;
import message.Output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cell {
    private final int index;
    private final List<EntityBase> entities = new ArrayList<>();

    public Cell(int index) { this.index = index; }
    public int getIndex() { return index; }

    public void add(EntityBase e) { entities.add(e); }
    public void remove(EntityBase e) { entities.remove(e); }


    public void onLand(GameCharacter c, Output out) {
        List<EntityBase> snapshot = new ArrayList<>(entities);
        for (EntityBase e : snapshot) {
            if (e instanceof Weapon w) {
                if(c instanceof Warrior){
                    out.pickupWeapon(c.getName(), w.getName(), w.getDamageBonus());
                    c.addStrength(w.getDamageBonus());
                    entities.remove(e);
                }
                else{
                    out.cannotPickup(c.getName(), w.getName());
                }
            } else if (e instanceof Spell s) {
                if(c instanceof Wizard){
                    out.pickupSpell(c.getName(), s.getName(), s.getPower());
                    entities.remove(e);
                }
                else{
                    out.cannotPickup(c.getName(), s.getName());
                }
            }
        }
        // logique monster

        snapshot = new ArrayList<>(entities);
        for (EntityBase e : snapshot) {
            if (e instanceof Monster m) {
                out.encounterMonster(c.getName() + " (force " + c.getStrength() + ")", m.getName(), m.getStrength(), m.getLife());
                c.takeDamage(Math.max(1, m.getStrength()));
                m.takeDamage(Math.max(1, m.getLife()));
                out.damageTaken(m.getName(), c.getStrength(), m.getLife());
                out.damageTaken(c.getName(), m.getStrength(), c.getLife());
            }
        }
    }

    @Override
    public String toString() {
        return "Cell[" + index + "] " + entities;
    }
}
