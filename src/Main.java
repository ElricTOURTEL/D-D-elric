import menu.Menu;
import db.DbQuery;

public class Main {
    public static void main(String[] args) {
        new DbQuery().getHeroes();
        // new Menu().startMenu();   // rien d’autre ici
    }
}