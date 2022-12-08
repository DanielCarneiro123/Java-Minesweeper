package org.example.controller;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.example.Application;
import org.example.gui.GUI;
import org.example.gui.LanternaGUI;
import org.example.model.Menu;
import org.example.model.arena.Arena;
import org.example.model.Position;
import org.example.model.elements.Cell;
import org.example.model.elements.Hero;
import org.example.state.GameState;
import org.example.state.MenuState;
import org.example.view.Viewer;
import org.example.view.game.GameViewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HeroController extends GameController{


    public HeroController(Arena arena) throws IOException, URISyntaxException, FontFormatException {
        super(arena);

    }

    public void moveHeroLeft() {
        moveHero(getModel().getHero().getPosition().getLeft());
    }

    public void moveHeroRight() {
        moveHero(getModel().getHero().getPosition().getRight());
    }

    public void moveHeroUp() {
        moveHero(getModel().getHero().getPosition().getUp());
    }

    public void moveHeroDown() {
        moveHero(getModel().getHero().getPosition().getDown());
    }

    private void moveHero(Position position) {
        if (getModel().isEmpty(position)){
            getModel().getHero().setPosition(position);
        }
    }


    @Override
    public void step(Application game, GUI.ACTION action, long time) throws InterruptedException, IOException, URISyntaxException, FontFormatException {
        Position position = getModel().getHero().getPosition();
        List<Integer> visited = new ArrayList<>();
        if (action == GUI.ACTION.UP) moveHeroUp();
        if (action == GUI.ACTION.RIGHT) moveHeroRight();
        if (action == GUI.ACTION.DOWN) moveHeroDown();
        if (action == GUI.ACTION.LEFT) moveHeroLeft();
        if (action == GUI.ACTION.SELECT) {
            if (getModel().lose(position)) {
                System.out.println("You lost!");
                getModel().revealBombs();

                game.setState(new MenuState(new Menu()));

            }
            getModel().expandir(position, visited);

            if (getModel().win()) {
                System.out.println("YOU WIN!");
                game.setState(new MenuState(new Menu()));
            }
        }
        if (action == GUI.ACTION.FLAG) getModel().flagCell(position);
    }
}
