package org.example.view.game;

import org.example.gui.GUI;
import org.example.model.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
