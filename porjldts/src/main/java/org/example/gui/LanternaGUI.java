package org.example.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import org.example.model.Position;
import org.example.model.elements.Cell;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI{
    private final Screen screen;


    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.BOLD, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'f') return ACTION.FLAG;

        return ACTION.NONE;
    }

    @Override
    public void drawHero(Position position) {
        drawCharacter(position.getX(), position.getY(), 'X', "#FFD700");
    }

    @Override
    public void drawWall(Position position) {
        drawCharacter(position.getX(), position.getY(), '#', "#3333FF");
    }
    //Position position, int beep, boolean canReveal, boolean flag, boolean bomb
    @Override
    public void drawCell(Cell cell){
        if (cell.isThatRevealed()) {

            if(cell.isBomb()){
                drawCharacter(cell.getPosition().getX(), cell.getPosition().getY(), 'B', "#FF0000");
                return;
            }

            switch (cell.getBeep()) {
                case 0:
                    drawCharacter(cell.getPosition().getX(), cell.getPosition().getY(), '0', "#90EE90");
                    return;
                case 1:
                    drawCharacter(cell.getPosition().getX(), cell.getPosition().getY(), '1', "#90EE90");
                    return;
                case 2:
                    drawCharacter(cell.getPosition().getX(), cell.getPosition().getY(), '2', "#90EE90");
                    return;
                case 3:
                    drawCharacter(cell.getPosition().getX(), cell.getPosition().getY(), '3', "#90EE90");
                    return;
                case 4:
                    drawCharacter(cell.getPosition().getX(), cell.getPosition().getY(), '4', "#90EE90");
                    return;
                case 5:
                    drawCharacter(cell.getPosition().getX(), cell.getPosition().getY(), '5', "#90EE90");
                    return;
                case 6:
                    drawCharacter(cell.getPosition().getX(), cell.getPosition().getY(), '6', "#90EE90");
                    return;
                case 7:
                    drawCharacter(cell.getPosition().getX(), cell.getPosition().getY(), '7', "#90EE90");
                    return;
                case 8:
                    drawCharacter(cell.getPosition().getX(), cell.getPosition().getY(), '8', "#90EE90");
                    return;
            }
        }
        else if (cell.getFlag()) {
                drawCharacter(cell.getPosition().getX(), cell.getPosition().getY(), 'F', "#FF0000");
                return;
            }
        else
        drawCharacter(cell.getPosition().getX(), cell.getPosition().getY(), 'C', "#FFFFFF");
    }


    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}
