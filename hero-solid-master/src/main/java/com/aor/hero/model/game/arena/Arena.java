package com.aor.hero.model.game.arena;

import com.aor.hero.model.Position;
import com.aor.hero.model.game.elements.Hero;
import com.aor.hero.model.game.elements.Wall;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Hero hero;


    private List<Wall> walls;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }
}
