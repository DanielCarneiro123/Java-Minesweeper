package com.aor.hero.controller.game;

import com.aor.hero.Game;
import com.aor.hero.gui.GUI;
import com.aor.hero.model.Position;
import com.aor.hero.model.game.arena.Arena;
import com.aor.hero.model.game.elements.Wall;

public class HeroController extends GameController {

    private Arena arena;

    public HeroController(Arena arena) {
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

    public boolean canHeroMove(Position pos, Arena arena){

        return (pos.getX() >= 10 && pos.getX() < 30) &&
                (pos.getY() >= 5 && pos.getY() < 5+10) &&
                !arena.getWalls().contains(new Wall(pos.getX(), pos.getY()));
    }
    private void moveHero(Position position) {
        if (getModel().isEmpty(position)){
            getModel().getHero().setPosition(position);
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) moveHeroUp();
        if (action == GUI.ACTION.RIGHT) moveHeroRight();
        if (action == GUI.ACTION.DOWN) moveHeroDown();
        if (action == GUI.ACTION.LEFT) moveHeroLeft();
    }
}
