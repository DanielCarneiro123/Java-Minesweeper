package org.example.model.arena;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.example.model.Position;
import org.example.model.elements.Cell;
import org.example.model.elements.Hero;
import org.example.model.elements.Wall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Arena {
    private Hero hero;
    private List<Wall> walls;
    private int height;
    private int width;

    public Arena(int width, int height){
        this.height = height;
        this.width = width;
        hero = new Hero(10, 5);
        walls = createWalls();
        generateCells();
        generateBombs(numBombs);
        generateBeeps();
    }
    private List<Cell> cells = new ArrayList<>();
    public List<Wall> getWalls() {
        return walls;
    }
    public Hero getHero() { return hero;}

    public int getCounterFlags() {return counterFlags;}

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    final int numBombs = 20;
    private int counterFlags = numBombs;

    public int getCellByPosition(Position position){
        for (int i=0;i<cells.size();i++){
            if (cells.get(i).getPosition().equals(position))return i;
        }

        return -1;
    }
    public void generateCells(){
        for (int i=5;i<15;i++){
            for (int j=10;j<30;j++){
                Cell cell = new Cell(j,i);
                cells.add(cell);
            }
        }
    }
    public List getCells(){
        return cells;
    }

    public List<Wall> createWalls(){
        List<Wall> walls = new ArrayList<>();

        for(int c=4; c < width; c++){
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height-1));
        }

        for(int r=0; r < height; r++){
            walls.add(new Wall(0, r));
            walls.add(new Wall(width-1, r));
        }

        return walls;
    }



    public void generateBombs(int numBombs){
        //podem haver menos bombas do que o esperado
        for (int i=0;i<numBombs;i++){
            Random random = new Random();
            int rand1 = random.nextInt(20);
            rand1 = rand1+ 10;
            int rand2 = random.nextInt(10);
            rand2 = rand2 + 5;
            Position pos = new Position(rand1,rand2);


            int bomb_in = getCellByPosition(pos);

            cells.get(bomb_in).arm();
        }
    }
    public void generateBeeps(){
        for(Cell cell: cells){

            int beep = 0;

            Position origPos = cell.getPosition();
            int orig_index = getCellByPosition(origPos);

            //posicaoDireita
            Position pos1= new Position(origPos.getX()+1,origPos.getY());
            //posicaoDireitaCima
            Position pos2= new Position(origPos.getX()+1,origPos.getY()+1);
            //posicaoCIma
            Position pos3= new Position(origPos.getX(),origPos.getY()+1);
            //posicaoCImaEsquerda
            Position pos4= new Position(origPos.getX()-1,origPos.getY()+1);
            //posicaoEsquerda
            Position pos5= new Position(origPos.getX()-1,origPos.getY());
            //posicaoBaixoEsquerda
            Position pos6= new Position(origPos.getX()-1,origPos.getY()-1);
            //posicaoBaixo
            Position pos7= new Position(origPos.getX(),origPos.getY()-1);
            //posicaoBaixoDIreita
            Position pos8= new Position(origPos.getX()+1,origPos.getY()-1);

            //checks

            int i_pos1 = getCellByPosition(pos1);
            if (i_pos1==-1){
                //nothing
            }
            else if (cells.get(i_pos1).isBomb()) {
                beep++;
            }
            int i_pos2 = getCellByPosition(pos2);
            if (i_pos2==-1){}
            else if (cells.get(i_pos2).isBomb()) {
                beep++;
            }
            int i_pos3 = getCellByPosition(pos3);
            if (i_pos3==-1){}
            else if (cells.get(i_pos3).isBomb()) {
                beep++;
            }
            int i_pos4 = getCellByPosition(pos4);
            if(i_pos4==-1){}
            else if (cells.get(i_pos4).isBomb()) {
                beep++;
            }
            int i_pos5 = getCellByPosition(pos5);
            if(i_pos5==-1){}
            else if (cells.get(i_pos5).isBomb()) {
                beep++;
            }
            int i_pos6 = getCellByPosition(pos6);
            if (i_pos6==-1){}
            else if (cells.get(i_pos6).isBomb()) {
                beep++;
            }
            int i_pos7 = getCellByPosition(pos7);
            if (i_pos7==-1){}
            else if(cells.get(i_pos7).isBomb()) {
                beep++;
            }
            int i_pos8 = getCellByPosition(pos8);
            if (i_pos8==-1){}
            else if (cells.get(i_pos8).isBomb()) {
                beep++;
            }

            cells.get(orig_index).setBeep(beep);
        }
    }

    public boolean lose(Position position){

        int i = getCellByPosition(position);

        Cell cell = cells.get(i);

        if (cell.isBomb()) {
            return true;
        }
        return false;
    }
    public void revealBombs() {
        for(Cell cell : cells){
            if(cell.isBomb()) revealCell(cell.getPosition());

        }

    }
    public boolean win(){
        for(Cell cell : cells){
            if(!(!cell.isBomb() && cell.isThatRevealed()))  return false;
        }
        return true;
    }
    public void flagCell(Position position){

        int i = getCellByPosition(position);
        Cell cell = cells.get(i);

        if(!cell.getFlag() && counterFlags > 0) {
            cells.get(i).toggleFlag();
            counterFlags--;
        }
        else if (cell.getFlag()) {
            counterFlags++;
            cells.get(i).toggleFlag();
        }

    }

    public void revealCell(Position position){
        int i = getCellByPosition(position);
        cells.get(i).reveal();
    }

    public boolean canHeroMove(Position pos){
        return (pos.getX() >= 10 && pos.getX() < 30) &&
                (pos.getY() >= 5 && pos.getY() < 5+10) &&
                !walls.contains(new Wall(pos.getX(), pos.getY()));
    }
    public Position heroPosition(){
        return hero.getPosition();
    }

    public void expandir(Position position, List<Integer> visited) {

        int i = getCellByPosition(position);

        if (i == -1) return;

        for (int check : visited){
            if(check == i) return;
        }
        visited.add(i);
        Cell cell = cells.get(i);
        revealCell(position);
        System.out.println("here");

        if (cell.getBeep() > 0) {
            return;
        }

        Position n_cell1 = new Position(cell.getPosition().getX() + 1, cell.getPosition().getY());
        revealCell(n_cell1);
        Position n_cell2 = new Position(cell.getPosition().getX() - 1, cell.getPosition().getY());
        Position n_cell3 = new Position(cell.getPosition().getX(), cell.getPosition().getY() + 1);
        Position n_cell4 = new Position(cell.getPosition().getX(), cell.getPosition().getY() - 1);

        expandir(n_cell1, visited);
        expandir(n_cell2, visited);
        expandir(n_cell3, visited);
        expandir(n_cell4, visited);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}