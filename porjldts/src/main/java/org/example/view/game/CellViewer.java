package org.example.view.game;

import org.example.controller.HeroController;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.elements.Cell;
import org.example.model.elements.Wall;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class CellViewer implements ElementViewer<Cell> {

    @Override
    public void draw(Cell cell, GUI gui) {
        gui.drawCell(cell);
    }
}
