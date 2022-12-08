package org.example;

import org.example.gui.LanternaGUI;
import org.example.state.MenuState;
import org.example.state.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    private final LanternaGUI gui;
    private State state;

    public Application() throws FontFormatException, IOException, URISyntaxException, HeadlessException {
        this.gui = new LanternaGUI(40, 20);
        this.state = new MenuState(new Menu());
    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException, InterruptedException {
        new Application().start();
    }

    public void setState(State state) {
        this.state = state;
    }
    private void start() throws IOException, InterruptedException, URISyntaxException, FontFormatException {
        int FPS = 10;
        int frameTime = 1000 / FPS;


        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
        gui.close();
    }
}