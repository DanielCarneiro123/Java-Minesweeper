package org.example.state;

import org.example.controller.ArenaController;
import org.example.controller.Controller;
import org.example.model.arena.Arena;
import org.example.view.game.GameViewer;
import org.example.view.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameState extends State<Arena>{
    public GameState(Arena arena) throws IOException, URISyntaxException, FontFormatException {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() throws IOException, URISyntaxException, FontFormatException {
        return new ArenaController(getModel());
    }
}
