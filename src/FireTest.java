import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FireTest {
    @Test
    public void testTimeToBurnExample() {
        char[][] forest = {
            {'t','.','.','t','t','t','t','.','t'},
            {'.','.','t','t','.','.','.','.','t'},
            {'.','.','t','t','t','t','t','t','t'},
            {'t','t','t','t','.','.','.','.','.'}
        };

        int matchR = 2;
        int matchC = 6;

        int expected = 8;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testMatchOnEmptyGround() {
        char[][] forest = {
            {'.','t','t'},
            {'t','t','.'},
            {'.','.','t'}
        };
    
        assertEquals(0, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testSingleTree() {
        char[][] forest = {
            {'t'}
        };
        
        assertEquals(0, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testAllTreesConnected2x2() {
        char[][] forest = {
            {'t','t'},
            {'t','t'}
        };
        
        assertEquals(2, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testSingleRow() {
        char[][] forest = {
            {'t','t','t','t'}
        };
        
        assertEquals(2, Fire.timeToBurn(forest, 0, 1));
    }

    @Test
    public void testUnreachableClusters() {
        char[][] forest = {
            {'t','t','.','t'},
            {'t','.','.','.'},
            {'.','.','t','t'},
            {'.','.','t','t'}
        };
        
        assertEquals(1, Fire.timeToBurn(forest, 0, 0));
    }
}
