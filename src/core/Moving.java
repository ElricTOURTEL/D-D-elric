package core;

import entity.gamecharacter.GameCharacter;
import message.Output;

public class Moving {
    private final Board board;
    private final Output out;
    private int position = 0;
    private GameCharacter hero;

    public Moving(Board board, Output out) {
        this.board = board;
        this.out = out;
    }

    public void placeAtStart(GameCharacter c) {
        this.hero = c;
        this.position = 0;
        board.getCell(0).add(c);
    }

    public int getPosition() {
        return position;
    }
    //todo Changer la logique de moveByDice pour se servir du return et garder les test logiques en dehors
    public int moveByDice() {
        int roll = Dice.d6();
        int oldPos = position;
        int newPos = Math.min(oldPos + roll, board.size() - 1);


        if(!board.getCell(oldPos).onLand(hero, out)){
            return oldPos;
        }

        board.getCell(oldPos).remove(hero);
        position = newPos;
        board.getCell(newPos).add(hero);

        out.moveMessage(hero.getName(), roll, oldPos, newPos);
        board.getCell(newPos).onLand(hero, out);

        return newPos;
    }
}
