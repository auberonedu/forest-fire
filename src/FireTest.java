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
    public void testNoburn() {
        char[][] forest = {
            {'.','.','.'},
            {'.','t','.'},
            {'.','.','.'}
            
        };

        int matchR = 2;
        int matchC = 2;

        int expected = 0;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testFullForest() {
        char[][] forest = {
            {'t', 't', 't'},
            {'t', 't', 't'},
            {'t', 't', 't'}
        };
        int matchR = 1, matchC = 1;
        int expected = 2; 
        int actual = Fire.timeToBurn(forest, matchR, matchC);
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyForest() {
        char[][] forest = {
            {'.', '.', '.'},
            {'.', '.', '.'},
            {'.', '.', '.'}
        };
        int matchR = 1, matchC = 1;
        int expected = 0;
        int actual = Fire.timeToBurn(forest, matchR, matchC);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testIsolatedTree() {
        char[][] forest = {
            {'.', '.', '.'},
            {'.', 't', '.'},
            {'.', '.', '.'}
        };
        int matchR = 1, matchC = 1;
        int expected = 0; // no other trees to burn
        int actual = Fire.timeToBurn(forest, matchR, matchC);
        assertEquals(expected, actual);
    }

    @Test
    public void testCornerTreeSpread() {
        char[][] forest = {
            {'t', '.', '.'},
            {'.', 't', '.'},
            {'.', '.', 't'}
        };
        int matchR = 0, matchC = 0;
        int expected = 0; // fire can't spread diagonally
        int actual = Fire.timeToBurn(forest, matchR, matchC);
        assertEquals(expected, actual);
    }
}

