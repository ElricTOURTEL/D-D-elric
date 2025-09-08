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

/**
 * Représente le plateau de jeu, constitué d'une liste ordonnée de {@link Cell}.
 * <p>
 * Responsabilités :
 * <ul>
 *   <li>Créer et stocker les cellules du plateau ({@link #cells})</li>
 *   <li>Générer un « sac » (bag) d'entités ({@link EntityBase}) et le répartir
 *       sur des positions prédéfinies</li>
 *   <li>Fournir des accès utilitaires à la taille du plateau et aux cellules</li>
 * </ul>
 *
 * <h2>Population du plateau</h2>
 * Le constructeur crée un sac d'entités (monstres, armes, sorts, potions),
 * mélange ce sac, puis dépose les entités tirées du sac sur une liste
 * prédéfinie d'index (variable {@code position}). Chaque index correspond
 * à une {@link Cell} existante du plateau.
 *
 * <p><strong>Remarque :</strong> les indices présents dans {@code position}
 * doivent être compatibles avec la taille passée au constructeur (ex. chaque
 * index est &lt; {@code size}).
 */
public class Board {
    /** Liste des cellules du plateau dans l'ordre (index = position). */
    private final List<Cell> cells = new ArrayList<>();

    /**
     * Construit un plateau de la taille demandée et le peuple avec un ensemble
     * d'entités préconfiguré (dragons, sorciers, gobelins, armes, sorts, potions)
     * réparties sur des positions prédéfinies.
     *
     * @param size nombre de cases du plateau (doit être &gt; 0 et couvrir les indices
     *             utilisés dans la liste {@code position})
     */
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

    /**
     * Retourne le nombre de cases du plateau.
     *
     * @return la taille de la liste des cellules
     */
    public int size() { return cells.size(); }

    /**
     * Accède à la cellule située à l'index fourni.
     *
     * @param index position de la cellule (0 &le; index &lt; {@link #size()})
     * @return la cellule correspondante
     * @throws IndexOutOfBoundsException si l'index est hors bornes
     */
    public Cell getCell(int index) { return cells.get(index); }

    /**
     * Représentation textuelle multi-lignes du plateau et de ses cellules.
     *
     * @return une chaîne formatée listant chaque cellule
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Board{");
        for (Cell c : cells) sb.append("\n  ").append(c);
        return sb.append("\n}").toString();
    }
}
