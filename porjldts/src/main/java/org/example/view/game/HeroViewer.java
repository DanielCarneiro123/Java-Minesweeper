package org.example.view.game;

import org.example.gui.GUI;
import org.example.model.elements.Hero;
import org.example.view.game.ElementViewer;

public class HeroViewer implements ElementViewer<Hero> {
    @Override
    public void draw(Hero hero, GUI gui) {
        gui.drawHero(hero.getPosition());
    }
}
