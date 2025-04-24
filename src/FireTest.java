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
    public void testTimeToBurn_OneSurroundedTree(){
        char[][] forest = {
            {'t', '.', 't'},
            {'.', 't', '.'},
            {'t', '.', 't'}
        };

        int matchR = 1;
        int matchC = 1;

        int expected = 0;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);

    
    }

    @Test 
    public void testTimeToBurn_SingleRowOfTrees(){
        char[][] forest = {
            {'t', 't', 't'}
        };

        int matchR = 0;
        int matchC = 0;

        int expected = 2;
        int actual = Fire.timeToBurn(forest, matchR, matchC);

        assertEquals(expected, actual);
    }
}
