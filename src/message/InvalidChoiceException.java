package message;

/**
 * Exception utilisée pour signaler un choix utilisateur invalide dans les menus du jeu.
 */
public class InvalidChoiceException extends Exception {
    /**
     * Construit une nouvelle exception pour un choix invalide.
     * @param message description de l'erreur à afficher
     */
    public InvalidChoiceException(String message) {
        super(message);
    }
}
