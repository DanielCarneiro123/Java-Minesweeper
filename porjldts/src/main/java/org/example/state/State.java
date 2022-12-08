package org.example.state;

import org.example.Application;
import org.example.controller.Controller;
import org.example.gui.GUI;
import org.example.view.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;
    private final Viewer<T> viewer;

    public State(T model) throws IOException, URISyntaxException, FontFormatException {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    protected abstract Viewer<T> getViewer();

    protected abstract Controller<T> getController() throws IOException, URISyntaxException, FontFormatException;

    public T getModel() {
        return model;
    }

    public void step(Application game, GUI gui, long time) throws IOException, InterruptedException, URISyntaxException, FontFormatException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(game, action, time);
        viewer.draw(gui);
    }
}
