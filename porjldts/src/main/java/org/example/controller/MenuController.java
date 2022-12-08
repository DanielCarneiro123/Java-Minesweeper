package org.example.controller;

import org.example.Application;
import org.example.gui.GUI;
import org.example.model.Menu;
import org.example.model.arena.Arena;
import org.example.state.GameState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuController  extends Controller<Menu>{
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Application game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) game.setState(new GameState(new Arena(40, 20)));
            {
                ;
            }
        }


    }

}
