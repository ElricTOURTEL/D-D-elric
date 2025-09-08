package core;

import entity.*;
import entity.gamecharacter.GameCharacter;
import entity.gamecharacter.Warrior;
import entity.gamecharacter.Wizard;
import entity.item.potion.Potion;
import entity.item.spell.Spell;
import entity.item.weapon.Weapon;
import entity.monster.Monster;
import message.InvalidChoiceException;
import message.Output;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente une case (cellule) du plateau de jeu.
 * <p>
 * Une {@code Cell} conserve :
 * <ul>
 *   <li>son index sur le plateau ({@link #index}) ;</li>
 *   <li>la liste des entités présentes sur la case ({@link #entities}) ;</li>
 *   <li>un état de combat en cours ({@link #currentFight}) pour savoir si
 *       un affrontement a déjà commencé sur cette case.</li>
 * </ul>
 *
 * <h2>Rôle principal</h2>
 * La méthode {@link #onLand(GameCharacter, Output)} applique les effets
 * d'« arrivée sur la case » pour un personnage :
 * <ul>
 *   <li>ramassage d'objets (armes, sorts) avec restriction par classe
 *       (Guerrier/Magicien) ;</li>
 *   <li>consommation de potions ;</li>
 *   <li>gestion d'un round de combat contre un {@link Monster} :
 *       dégâts infligés au monstre, puis choix joueur (combattre/fuir).
 *       Le drapeau {@link #currentFight} sert à signaler une rencontre déjà en cours.</li>
 * </ul>
 *
 * <p><strong>Note :</strong> un refactoring est envisagé (voir le TODO dans le code)
 * pour déléguer cette logique aux entités via polymorphisme, afin d'alléger
 * {@code onLand}.</p>
 */
public class Cell {
    /** Index (position) de la case sur le plateau. */
    private final int index;
    /** Entités présentes sur la case (monstres, objets, etc.). */
    private final List<EntityBase> entities = new ArrayList<>();
    /** Indique si un combat est en cours sur cette case. */
    private boolean currentFight;

    /**
     * Crée une case identifiée par son index.
     *
     * @param index position de la case sur le plateau (0..N-1)
     */
    public Cell(int index) { this.index = index; this.currentFight = false; }

    /**
     * Retourne l'index (position) de cette case.
     *
     * @return l'index 0-based de la case
     */
    public int getIndex() { return index; }

    /**
     * Ajoute une entité sur la case.
     *
     * @param e entité à ajouter (non {@code null})
     */
    public void add(EntityBase e) { entities.add(e); }

    /**
     * Retire une entité de la case (si présente).
     *
     * @param e entité à retirer
     */
    public void remove(EntityBase e) { entities.remove(e); }

    //todo refacto onLand voir les principes de polymorphisme déplacé toute la méthode dans une interface entitybase et modification des classes enfants avec override

    /**
     * Applique les effets d'arrivée d'un personnage {@code c} sur cette case.
     * <p>
     * La logique actuelle comprend :
     * <ol>
     *   <li><strong>Armes</strong> : si {@code c} est un {@link Warrior}, il peut
     *       ramasser une {@link Weapon} (bonus de force). Sinon, affichage d'un refus.</li>
     *   <li><strong>Sorts</strong> : si {@code c} est un {@link Wizard}, il peut
     *       ramasser un {@link Spell}. Sinon, affichage d'un refus.</li>
     *   <li><strong>Potions</strong> : tentative de soin ({@link Potion}) puis
     *       messages associés ; la potion est retirée de la case.</li>
     *   <li><strong>Monstres</strong> : résolution d'un round de combat :
     *     <ul>
     *       <li>Annonce de la rencontre au premier tour, ou message « monstre sur la case » si combat en cours ;</li>
     *       <li>Le personnage inflige des dégâts au monstre ;</li>
     *       <li>Si le monstre meurt : retrait de la case, {@code currentFight=false}, et la méthode renvoie {@code false} ;</li>
     *       <li>Sinon, demande au joueur : « combattre » → le monstre riposte et {@code currentFight=true}, la méthode renvoie {@code false} ;</li>
     *       <li>Si le joueur choisit de ne pas combattre : {@code currentFight=false} et la méthode continue.</li>
     *     </ul>
     *   </li>
     * </ol>
     *
     * @param c   le personnage qui arrive sur la case
     * @param out la sortie/affichage des messages
     * @return {@code true} si aucun blocage n'empêche de poursuivre (ex. pas de combat à poursuivre),
     *         {@code false} lorsqu'un combat vient d'être engagé ou résolu durant ce tour
     */
    public boolean onLand(GameCharacter c, Output out) {
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
        // Logique Potion

        snapshot = new ArrayList<>(entities);
        for (EntityBase e : snapshot) {
            if (e instanceof Potion p) {
                out.pickupPotion(c.getName(), c.getLife(), p.getHealAmount());
                if(c.healthUrself(p.getHealAmount()) > c.getMaxLife()){
                    out.cannotDrinkPotion(c.getName(), p.getName());
                }
                else{
                    c.healthUrself(p.getHealAmount());
                    out.drinkPotion(c.getName(), c.getLife());
                }
                entities.remove(e);
            }
        }
        // logique monster

        snapshot = new ArrayList<>(entities);
        for (EntityBase e : snapshot) {
            if (e instanceof Monster m) {
                if(!currentFight){
                    out.encounterMonster(c.getName() + " (force " + c.getStrength() + ")", m.getName(), m.getStrength(), m.getLife());
                }
                else{
                    out.monsterOnCurrentCase(c.getName());
                }
                m.takeDamage(Math.max(1, c.getStrength()));
                out.damageTaken(m.getName(), c.getStrength(), m.getLife());

                if(!m.isAlive())
                {
                    entities.remove(e);
                    currentFight = false;
                    return false;
                }
                else{
                    String choice = out.fightOrRun();
                    if (choice.equalsIgnoreCase("Combattre")) {
                        c.takeDamage(Math.max(1, m.getStrength()));
                        out.damageTaken(c.getName(), m.getStrength(), c.getLife());
                        currentFight=true;
                        return false;
                    }
                    else{
                        currentFight=false;
                    }


                }

            }
        }
        return true;
    }

    /**
     * Chaîne de debug listant l'index et les entités présentes.
     *
     * @return représentation textuelle sous la forme {@code "Cell[index] [entities]"}
     */
    @Override
    public String toString() {
        return "Cell[" + index + "] " + entities;
    }
}
