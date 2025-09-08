import menu.Menu;
import db.DbQuery;

/**
 * Point d'entrée principale de l'application D-D-elric.
 */
public class Main {
    public static void main(String[] args) {
        // new DbQuery().getHeroes();
        new Menu().startMenu();
    }
}