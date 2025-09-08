package core;

import entity.gamecharacter.GameCharacter;
import message.Output;
import core.*;

/**
 * Gère le déplacement d'un personnage sur le plateau de jeu.
 * <p>
 * Encapsule la position du héros, le lien avec le plateau, l'affichage des messages,
 * ainsi que la logique de déplacement via les dés.
 */
public class Moving {
    private final Board board;
    private final Output out;
    private int position = 0;
    private GameCharacter hero;
    private final Dice dice;

    public Moving(Board board, Output out, Dice dice) {
        this.board = board;
        this.out = out;
        this.dice = dice;
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
        int roll = dice.d6();
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
