package entity;

/**
 * Classe de base abstraite pour toutes les entités du jeu (personnages, monstres, objets...).
 * <p>
 * Gère le nom de l'entité et fournit une méthode {@link #toString()} commune.
 */
public abstract class EntityBase {
    protected final String name;

    protected EntityBase(String name) { this.name = name; }

    public String getName() { return name; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{name='" + name + "'}";
    }
}