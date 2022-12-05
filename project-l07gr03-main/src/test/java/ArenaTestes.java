import org.example.model.Position;
import org.example.model.elements.Cell;
import org.example.view.Arena;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArenaTestes {
    private Cell cell;

    private Arena arena;

    private List<Cell> cells = new ArrayList<>();

    private Position position;

    @BeforeEach
    void setUp() {
        cell = new Cell(20, 10);
        arena = new Arena(40, 20);
        position = new Position(20,10);
        cells.clear();
    }
    @Test
    void getCellByPositionTest(){
        assertEquals(110, arena.getCellByPosition(position));
        position.setX(41);
        position.setY(21);
        assertEquals(-1, arena.getCellByPosition(position));
    }
    @Test
    void numberOfCells(){
        assertEquals(200,arena.getCells().size());

    }
    
}
