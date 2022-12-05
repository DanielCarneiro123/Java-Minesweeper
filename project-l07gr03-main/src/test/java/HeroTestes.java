import org.example.model.Position;
import org.example.model.elements.Cell;
import org.example.view.Arena;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeroTestes {
    private Cell cell;
    private Arena arena;

    private List<Cell> cells = new ArrayList<>();

    @BeforeEach
    void setUp(){
        arena = new Arena(40,20);
        cells.clear();
        cell = new Cell(20,10);
    }

    @Test
    void canHeroMoveTest(){
        Position pos = new Position(9,5);
        assertEquals(false,arena.canHeroMove(pos));
    }

}