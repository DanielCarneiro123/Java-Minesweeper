package org.example.gui;

import org.example.model.Position;
import org.example.model.elements.Cell;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;
    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    void drawText(Position position, String text, String color);

    void drawHero(Position position);

    void drawWall(Position position);

    void drawCell(Cell cell);

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT, FLAG}


}
