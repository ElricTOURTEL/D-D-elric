package entity.item;
import entity.EntityBase;
import entity.GameCharacter;

public abstract class Item extends EntityBase {
    protected Item(String name) { super(name); }
    public abstract boolean canBeUsedBy(GameCharacter c);
}
