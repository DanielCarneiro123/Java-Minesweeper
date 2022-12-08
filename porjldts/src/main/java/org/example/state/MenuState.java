package org.example.state;

import org.example.model.Menu;
import org.example.controller.Controller;
import org.example.controller.MenuController;
import org.example.view.MenuViewer;
import org.example.view.Viewer;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuState extends State<Menu>{

    public MenuState(Menu model) throws IOException, URISyntaxException, FontFormatException {
        super(model);
    }

    public MenuState(java.awt.Menu menu) throws IOException, URISyntaxException, FontFormatException {
        super(new Menu());
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
