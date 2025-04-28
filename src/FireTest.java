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
    public void testTimeToBurn_emptyForest() {
        char[][] forest = {
            {'.','.','.','.','.'},
            {'.','.','.','.','.'},
            {'.','.','.','.','.'},
            {'.','.','.','.','.'}
        };

        int expected = 0;
        int actual = Fire.timeToBurn(forest, 1, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToBurn_allTrees() {
        char[][] forest = {
            {'t','t','t','t','t'},
            {'t','t','t','t','t'},
            {'t','t','t','t','t'},
            {'t','t','t','t','t'},
            {'t','t','t','t','t'}
        };

        int expected = 5;
        int actual = Fire.timeToBurn(forest, 3, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToBurn_twoColumnsWithTrees() {
        char[][] forest = {
            {'t','t','.','.','.'},
            {'t','t','.','.','.'},
            {'t','t','.','.','.'},
            {'t','t','.','.','.'},
            {'t','t','.','.','.'}
        };

        int expected = 3;
        int actual = Fire.timeToBurn(forest, 2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToBurn_twoColumnsWithTreesButStartMatchInWhiteSpace() {
        char[][] forest = {
            {'t','t','.','.','.'},
            {'t','t','.','.','.'},
            {'t','t','.','.','.'},
            {'t','t','.','.','.'},
            {'t','t','.','.','.'}
        };

        int expected = 0;
        int actual = Fire.timeToBurn(forest, 2, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToBurn_diagonalTreesStartingAtTopLeft() {
        char[][] forest = {
            {'t','.','.','.','.'},
            {'.','t','.','.','.'},
            {'.','.','t','.','.'},
            {'.','.','.','t','.'},
            {'.','.','.','.','t'}
        };

        int expected = 0;
        int actual = Fire.timeToBurn(forest, 0, 0);
        assertEquals(expected, actual);    
    }

    @Test
    public void testTimeToBurn_treesInTheCenter() {
        char[][] forest = {
            {'.','.','.','.','.'},
            {'.','.','t','.','.'},
            {'.','t','t','t','.'},
            {'.','.','t','.','.'},
            {'.','.','.','.','.'},
        };

        int expected = 1;
        int actual = Fire.timeToBurn(forest, 2, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToBurn_spiralForest() {
        char[][] forest = {
            {'t','t','t','t','t'},
            {'.','.','.','.','t'},
            {'.','t','t','.','t'},
            {'.','t','.','.','t'},
            {'.','t','t','t','t'},
        };
        
        int expected = 14;
        int actual = Fire.timeToBurn(forest, 0, 0);
        assertEquals(expected, actual);
    }
}
