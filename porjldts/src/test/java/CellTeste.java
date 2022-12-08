import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static com.googlecode.lanterna.input.KeyType.ArrowUp;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CellTeste {

    private Cell cell;

    private Arena arena;

    private List<Cell> cells = new ArrayList<>();


    @BeforeEach
    void setUp() {
        cell = new Cell(20, 10);
        arena = new Arena(40, 20);
        cells.clear();
    }

    @Test
    void getBeepTeste() {
        assertEquals(0, cell.getBeep());
    }

    @Test
    void setBeepTeste() {
        cell.setBeep(6);
        assertEquals(false, cell.getBeep() == 0);
        assertEquals(true, cell.getBeep() == 6);
    }
    /*
    @Test
    void isRevealedTeste(){
        assertEquals(false, cell.getRevealed());
        cell.isRevealed();
        assertEquals(true, cell.getRevealed());

    }
    */


    @Test
    void isBombTest(){
        assertEquals(false, cell.isBomb());
        cell.arm();
        assertEquals(true, cell.isBomb());

    }


}
