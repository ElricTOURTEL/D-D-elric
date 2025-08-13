
public class Main {
    public static void main(String[] args) {
        Map gameMap = new Map();
        String character = Output.chooseCharacter();
        String name = Output.nameCharacter();
        Moving moving = new Moving(gameMap);
        while(moving.getPlayerPosition() < 63){
            moving.movePlayer();
        }
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        }
}