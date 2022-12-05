package com.aor.hero.model.game.arena;

import com.aor.hero.model.game.elements.Hero;
import com.aor.hero.model.game.elements.Wall;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setHero(createHero());
        arena.setWalls(createWalls());

        return arena;
    }
    
    protected abstract int getWidth();

    protected abstract int getHeight();


    protected abstract List<Wall> createWalls();

    protected abstract Hero createHero();
}
