package org.example.model.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.model.Position;

public abstract class Element {
    private Position position;

    public Element(int x, int y){
        position = new Position(x,y);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract void draw(TextGraphics screen);
}