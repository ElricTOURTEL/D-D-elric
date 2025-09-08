package entity.item;
import entity.EntityBase;
import entity.gamecharacter.GameCharacter;

/**
 * Classe abstraite pour tous les objets du jeu (armes, sorts, potions...).
 * Définit l'API permettant de savoir si une entité {@link GameCharacter} peut utiliser l'objet.
 */
public abstract class Item extends EntityBase {
    protected Item(String name) { super(name); }
    public abstract boolean canBeUsedBy(GameCharacter c);
}
