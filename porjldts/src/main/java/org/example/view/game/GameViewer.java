package org.example.view.game;

import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.arena.Arena;
import org.example.model.elements.Element;
import org.example.view.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class GameViewer extends Viewer<Arena> {

    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) throws IOException, URISyntaxException, FontFormatException {
        gui.drawText(new Position(15, 2), "MINESWEEPER", "#FFFF33");
        gui.drawText(new Position(20, 4), "FLAGS: " + getModel().getCounterFlags(), "#FFFF33");
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getCells(), new CellViewer());
        drawElement(gui, getModel().getHero(), new HeroViewer());
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

}
