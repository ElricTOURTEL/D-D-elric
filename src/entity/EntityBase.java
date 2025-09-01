package entity;

public abstract class EntityBase {
    protected final String name;

    protected EntityBase(String name) { this.name = name; }

    public String getName() { return name; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{name='" + name + "'}";
    }
}