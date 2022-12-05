
package com.aor.hero.model.game.arena;

import com.aor.hero.model.game.arena.ArenaBuilder;
import com.aor.hero.model.game.elements.Hero;
import com.aor.hero.model.game.elements.Wall;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderArenaBuilder extends ArenaBuilder {
    private int width;
    private int height;

   // private final List<String> lines;

    public LoaderArenaBuilder(int width, int height) throws IOException {
        this.width = width;
        this.height = height;
    }

    @Override
    protected int getWidth() {
        return width;
    }

    @Override
    protected int getHeight() {
        return height;
    }


    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        //
        for (int c = 0; c < 18; c++) {
            walls.add(new Wall(c, -1));
            walls.add(new Wall(c, 18));
        }

        for (int r = 0; r < 19; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(17, r));
        }

        return walls;
    }
    @Override
    protected Hero createHero() {
        Hero hero = new Hero(10, 5);
        return hero;

    }
}

