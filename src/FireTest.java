import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FireTest {

    @Test
    public void testTimeToBurnExample() {
        char[][] forest = {
                { 't', '.', '.', 't', 't', 't', 't', '.', 't' },
                { '.', '.', 't', 't', '.', '.', '.', '.', 't' },
                { '.', '.', 't', 't', 't', 't', 't', 't', 't' },
                { 't', 't', 't', 't', '.', '.', '.', '.', '.' }
        };

        int matchR = 2;
        int matchC = 6;
        int expected = 8;
        assertEquals(expected, Fire.timeToBurn(forest, matchR, matchC));
    }

    @Test
    public void testSingleTree() {
        char[][] forest = {
                { 't' }
        };
        assertEquals(0, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testNoBurnableTrees() {
        char[][] forest = {
                { '.', '.', '.' },
                { '.', '.', '.' },
                { '.', '.', '.' }
        };
        assertEquals(0, Fire.timeToBurn(forest, 1, 1));
    }

    @Test
    public void testAllConnected() {
        char[][] forest = {
                { 't', 't', 't' },
                { 't', 't', 't' },
                { 't', 't', 't' }
        };
        int expected = 2;
        assertEquals(expected, Fire.timeToBurn(forest, 1, 1));
    }

    @Test
    public void testTreeInCorner() {
        char[][] forest = {
                { 't', 't', '.' },
                { 't', '.', '.' },
                { '.', '.', '.' }
        };
        assertEquals(1, Fire.timeToBurn(forest, 0, 0));
    }

    @Test
    public void testIsolatedTreeCluster() {
        char[][] forest = {
                { 't', '.', 't' },
                { '.', '.', '.' },
                { 't', 't', 't' }
        };
        assertEquals(1, Fire.timeToBurn(forest, 2, 1));
    }
}
