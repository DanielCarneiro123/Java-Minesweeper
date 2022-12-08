package org.example.controller;

import org.example.Application;
import org.example.gui.GUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(Application game, GUI.ACTION action, long time) throws IOException, InterruptedException, URISyntaxException, FontFormatException;
}
