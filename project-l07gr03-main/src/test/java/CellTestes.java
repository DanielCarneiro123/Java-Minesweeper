import org.example.model.elements.Cell;
import org.example.view.Arena;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CellTestes {

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

    @Test
    void isRevealedTeste(){
        assertEquals(false, cell.getRevealed());
        cell.isRevealed();
        assertEquals(true, cell.getRevealed());

    }

    @Test
    void isBombTeste(){
        assertEquals(false, cell.isBomb());
        cell.arm();
        assertEquals(true, cell.isBomb());

    }


}
