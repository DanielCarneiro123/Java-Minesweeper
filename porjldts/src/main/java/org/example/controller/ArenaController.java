package org.example.controller;

import org.example.Application;
import org.example.model.Menu;
import org.example.gui.GUI;
import org.example.model.Position;
import org.example.model.arena.Arena;
import org.example.state.MenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class ArenaController extends GameController{
    private final HeroController heroController;
    public ArenaController(Arena arena) throws IOException, URISyntaxException, FontFormatException {
        super(arena);
        this.heroController = new HeroController(arena);
    }
    public void step(Application game, GUI.ACTION action, long time) throws InterruptedException, IOException, URISyntaxException, FontFormatException {
        if (action == GUI.ACTION.QUIT)
            game.setState(new MenuState(new Menu()));
        else {
            heroController.step(game, action, time);
        }
    }
}

