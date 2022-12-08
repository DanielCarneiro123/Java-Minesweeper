package org.example.view.game;

import org.example.gui.GUI;
import org.example.model.elements.Wall;
import org.example.view.game.ElementViewer;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
