package com.aor.hero.viewer.game;

import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.elements.Cell;
import com.aor.hero.model.game.elements.Hero;

public class CellViewer implements ElementViewer<Cell>{
    @Override
    public void draw(Cell cell, GUI gui) {
        gui.drawCell(cell.getPosition());
    }

}
