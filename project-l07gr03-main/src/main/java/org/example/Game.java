package org.example;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.example.view.Arena;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public Game(){
        try {
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();

        } catch (IOException e){
            e.printStackTrace();
        }

        arena = new Arena(40, 20);
    }

    private void draw() throws IOException{
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }
    private int processKey(com.googlecode.lanterna.input.KeyStroke key) throws IOException {
        System.out.println(key);
        List<Integer> visited = new ArrayList<>();
        switch (key.getKeyType()) {
            case ArrowUp    -> arena.moveHero(arena.moveUp());
            case ArrowDown  -> arena.moveHero(arena.moveDown());
            case ArrowLeft  -> arena.moveHero(arena.moveLeft());
            case ArrowRight -> arena.moveHero(arena.moveRight());
            case Character  -> {
                if(key.getCharacter() == ('f')) arena.flagCell(arena.heroPosition());
            }
            case Enter -> {
                if(arena.lose(arena.heroPosition())) {
                    System.out.println("You lost!");
                    return 2;
                }
                if(arena.win()){
                    System.out.println("YOU WIN!");
                    return 3;}
                arena.expandir(arena.heroPosition(),visited);
            }
        }
        return 1;
    }




    public void run() {
        try {
            while(true) {
                draw();
                com.googlecode.lanterna.input.KeyStroke key = screen.readInput();
                int i = processKey(key);
                if(i==2) {
                    arena.revealBombs();
                    draw();
                    Thread.sleep(3000);
                    screen.close();
                    return;
                }
                else if(i==3){
                   Thread.sleep(5000);
                   screen.close();
                   return;
                }


                if (key.getKeyType() == KeyType.Character && key.getCharacter() == ('q'))
                    screen.close();
                if (key.getKeyType() == KeyType.EOF)
                    break;


            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private Screen screen;
    private Arena arena;

}