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
    public void testTimeToBurnOneTree(){
        char[][] forest = {
            {'t'}
        };

        int matchR = 0;
        int matchC = 0;

        int result = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(0, result);
    }

    @Test
    public void testTimeToBurnNoTree(){
        char[][] forest = {
            {'.', '.', '.'},
            {'.', '.', '.'},
            {'.', '.', '.'}
        };

        int matchR = 1;
        int matchC = 2;

        int result = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(0, result);
    } 

    @Test
    public void testBurningAnEmptyForest(){
        char[][] forest = new char[0][0];

        int matchR = 0;
        int matchC = 0;

        int result = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(0, result);
    }

    @Test
    public void testThatFireDoesntJump(){
        char[][] forest = {
            {'t', '.', 't'},
            {'t', '.', '.'},
            {'t', '.', 't'}
        };

        int matchR = 0;
        int matchC = 0;

        int result = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(2, result);
    }
}
