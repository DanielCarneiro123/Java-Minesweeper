package org.example.model.elements;

public class Cell extends Element{
    private boolean bomb;
    private boolean revealed;
    private int beep;

    private boolean flag;

    public Cell(int x, int y){
        super(x,y);
        bomb = false;
        revealed = false;
        beep = 0;
        flag = false;

    }


    public void arm(){
        bomb = true;
    }

    public boolean isBomb(){
        return bomb;
    }

    public boolean isThatRevealed(){
        return revealed;
    }


    public void reveal(){
        revealed = true;
    }

    public void setBeep(int beep){
        this.beep = beep;
    }
    public int getBeep(){
        return beep;
    }

    public void toggleFlag(){

        flag = !flag;

    }

    public boolean getFlag() {
        return flag;
    }


   /* public void draw(TextGraphics screen){
        screen.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        screen.enableModifiers(SGR.BOLD);
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "C");


        if (revealed) {

            if(isBomb()){
                screen.setForegroundColor(TextColor.ANSI.RED);
                screen.enableModifiers(SGR.BOLD);
                screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "B");
                return;

            }

            switch (beep) {
                case 0:
                    screen.setForegroundColor(TextColor.ANSI.GREEN);
                    screen.enableModifiers(SGR.BOLD);
                    screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "A");
                    break;
                case 1:
                    screen.setForegroundColor(TextColor.ANSI.GREEN);
                    screen.enableModifiers(SGR.BOLD);
                    screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "1");
                    break;
                case 2:
                    screen.setForegroundColor(TextColor.ANSI.GREEN);
                    screen.enableModifiers(SGR.BOLD);
                    screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "2");
                    break;
                case 3:
                    screen.setForegroundColor(TextColor.ANSI.GREEN);
                    screen.enableModifiers(SGR.BOLD);
                    screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "3");
                    break;
                case 4:
                    screen.setForegroundColor(TextColor.ANSI.GREEN);
                    screen.enableModifiers(SGR.BOLD);
                    screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "4");
                    break;
                case 5:
                    screen.setForegroundColor(TextColor.ANSI.GREEN);
                    screen.enableModifiers(SGR.BOLD);
                    screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "5");
                    break;
                case 6:
                    screen.setForegroundColor(TextColor.ANSI.GREEN);
                    screen.enableModifiers(SGR.BOLD);
                    screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "6");
                    break;
                case 7:
                    screen.setForegroundColor(TextColor.ANSI.GREEN);
                    screen.enableModifiers(SGR.BOLD);
                    screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "7");
                    break;
                case 8:
                    screen.setForegroundColor(TextColor.ANSI.GREEN);
                    screen.enableModifiers(SGR.BOLD);
                    screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "8");
                    break;
            }
        }
        else {
            if(flag) {
                screen.setForegroundColor(TextColor.ANSI.RED);
                screen.enableModifiers(SGR.BOLD);
                screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "F");
            }
        }

    }*/
}
