package core;

import entity.monster.Dragon;
import entity.EntityBase;
import entity.monster.Goblin;
import entity.monster.Sorcerer;
import entity.item.potion.RegularPotion;
import entity.item.potion.SmallPotion;
import entity.item.spell.Fireball;
import entity.item.spell.Lightning;
import entity.item.weapon.Mace;
import entity.item.weapon.Sword;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private final List<Cell> cells = new ArrayList<>();

    public Board(int size) {
        int maxDragons = 4;
        int maxSorcerer = 10;
        int maxGoblins = 10;
        int maxMace = 5;
        int maxSword = 4;
        int maxLightning = 5;
        int maxFireball = 2;
        int maxSmallPotion = 6;
        int maxBigPotion = 2;
        List<Integer> position = new ArrayList<>();
        Collections.addAll(position, 45, 52, 56, 62, 10, 20, 25, 32, 35, 36, 37, 40, 44, 47, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 2, 11, 5, 22, 38, 19, 26, 42, 53, 1, 4, 8, 17, 23, 48, 49, 7, 13, 31, 33, 39, 43, 28, 41);
        for (int i = 0; i < size; i++) {
            cells.add(new Cell(i));
        }
        List<EntityBase> bag = new ArrayList<>();
        for (int i = 0; i < maxDragons; i++) bag.add(new Dragon());
        for (int i = 0; i < maxSorcerer; i++) bag.add(new Sorcerer());
        for (int i = 0; i < maxGoblins; i++) bag.add(new Goblin());
        for (int i = 0; i < maxMace; i++) bag.add(new Mace());
        for (int i = 0; i < maxSword; i++) bag.add(new Sword());
        for (int i = 0; i < maxLightning; i++) bag.add(new Lightning());
        for (int i = 0; i < maxFireball; i++) bag.add(new Fireball());
        for (int i = 0; i < maxSmallPotion; i++) bag.add(new SmallPotion());
        for (int i = 0; i < maxBigPotion; i++) bag.add(new RegularPotion());

        Collections.shuffle(bag);
        for (int j = 0; j < position.size(); j++) {
            int idx = position.get(j);
            getCell(idx).add(bag.get(j));
        }
    }
    public int size() { return cells.size(); }
    public Cell getCell(int index) { return cells.get(index); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Board{");
        for (Cell c : cells) sb.append("\n  ").append(c);
        return sb.append("\n}").toString();
    }
}