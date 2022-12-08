package org.example.controller;

import org.example.model.arena.Arena;

public abstract class GameController extends Controller<Arena>{
    public GameController(Arena arena) {
        super(arena);
    }

}
