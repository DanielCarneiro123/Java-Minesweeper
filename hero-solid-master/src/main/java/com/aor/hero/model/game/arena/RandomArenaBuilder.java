
/*
package com.aor.hero.model.game.arena;


import com.aor.hero.model.game.arena.ArenaBuilder;
import com.aor.hero.model.game.elements.Hero;
import com.aor.hero.model.game.elements.Wall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomArenaBuilder extends ArenaBuilder {
    private final Random rng;

    private final int width;
    private final int height;

    public RandomArenaBuilder(int width, int height) {
        this.rng = new Random();

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

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int x = 0; x < width; x++) {
            walls.add(new Wall(x, 0));
            walls.add(new Wall(x, height - 1));
        }

        for (int y = 1; y < height - 1; y++) {
            walls.add(new Wall(0, y));
            walls.add(new Wall(width - 1, y));
        }

        return walls;
    }


    @Override
    protected Hero createHero() {
        return new Hero(width / 2, height / 2);
    }
}

 */