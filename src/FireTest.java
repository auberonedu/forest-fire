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
    public void testTimeToBurnSimpler() {
        char[][] forest = {
            {'t','.','.','t'},
            {'.','.','t','t'},
            {'t','.','t','t'},
            {'t','t','t','t'}
        };

        int matchR = 2;
        int matchC = 2;

        int expected = 4;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToBurnEmptySurroundedTree() {
        char[][] forest = {
            {'.','.','.','.'},
            {'.','.','.','t'},
            {'.','.','.','.'},
            {'.','.','.','.'}
        };

        int matchR = 1;
        int matchC = 3;

        int expected = 0;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToBurnOneTree() {
        char[][] forest = {
            {'t'}
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 0;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToBurnDiagonalTrees() {
        char[][] forest = {
            {'t','.','t'},
            {'.','t','.'},
            {'t','.','t'}
        };

        int matchR = 1;
        int matchC = 1;

        int expected = 0;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }

    @Test
    public void testTimeToBurnAllTrees() {
        char[][] forest = {
            {'t','t','t'},
            {'t','t','t'},
            {'t','t','t'}
        };

        int matchR = 1;
        int matchC = 1;

        int expected = 2;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }
}
