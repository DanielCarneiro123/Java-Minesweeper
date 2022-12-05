package com.aor.hero.controller.game;

import com.aor.hero.Game;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.menu.Menu;
import com.aor.hero.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final HeroController heroController;

    public ArenaController(Arena arena) {
        super(arena);

        this.heroController = new HeroController(arena);

    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT)
            game.setState(new MenuState(new Menu()));
        else {
            heroController.step(game, action, time);

        }
    }
}