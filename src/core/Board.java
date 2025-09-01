package core;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Cell> cells = new ArrayList<>();

    public Board(int size) {
        for (int i = 0; i < size; i++) cells.add(new Cell(i));
    }

    public int size() { return cells.size(); }
    public Cell getCell(int index) { return cells.get(index); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Board{");
        for (Cell c : cells) sb.append("\n  ").append(c);
        return sb.append("\n}").toString();
    }
}