package core;

import message.Output;

public class Moving {
    private Map map;
    private int playerPosition;

    public Moving(Map map){
        this.map = map;
        this.playerPosition = 0;
    }
    public void movePlayer(){
        int steps = Dice.throwDice();
        playerPosition += steps;
        boolean finish=false;
        if(playerPosition >= 64){
            playerPosition = 63;
            Output.endMessage();
            finish=true;
        }
        Output.diceMessage(Dice.throwDice(), finish);
    }
    public int getPlayerPosition(){
        return playerPosition;
    }
}
