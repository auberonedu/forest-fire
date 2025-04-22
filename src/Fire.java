import java.util.Deque;
import java.util.ArrayDeque;

public class Fire {
    /**
     * Returns how long it takes for all vulnerable trees to be set on fire if a
     * match is lit at a given location.
     * 
     * The forest is represented via a rectangular 2d char array where t represents
     * a tree
     * and . represents an empty space.
     * 
     * At time 0, the tree at location [matchR, matchC] is set on fire. At every
     * subsequent
     * time step, any tree that is adjacent (up/down/left/right) to a burning tree
     * is also
     * set on fire.
     * 
     * 
     * EXAMPLE
     * forest:
     * 
     * t..tttt.t
     * ..tt....t
     * ..ttttttt
     * tttt.....
     * 
     * matchR: 2
     * matchC: 6
     * 
     * Result: 8
     * 
     * Explanation:
     * At time 0, the tree at (2, 6) is set on fire. At time 1, its adjacent trees
     * also catch on fire
     * At time 2, the trees adjacent to those catch as well. At time 8, the last
     * tree to catch is at
     * (0,6). In this example, there is one tree that never burns, so it is not
     * included in the time calculation.
     * 
     * 
     * @param forest a 2d array where t represents a tree and . represents the
     *               ground
     * @param matchR The row the match is lit at
     * @param matchC The column the match is lit at
     * @return the time at which the final tree to be incinerated starts burning
     */

    private static final int[][] moves = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static int timeToBurn(char[][] forest, int matchR, int matchC) {
        // HINT: when adding to your BFS queue, you can include more information than
        // just a location. What other information might be useful?
        // create a queue to track possible moves
        // write a for-each loop to iterate through each possible move
        // add tree location and extra information (time it took to reach)
        // write variables to track the current location of columns and rows
        // potentially an integer array to track current coordinates
        int rows = forest.length;
        int cols = forest[0].length;

        int max = 0; //return (the time it takes for all trees to burn).

        // if no tree, no fire
        if(forest[matchR][matchC] != 't') {
            return 0;
        }

        boolean[][] visited = new boolean[rows][cols];
        Deque<int[]> deq = new ArrayDeque<int[]>();

        deq.addLast(new int[]{matchR, matchC, 0});
        visited[matchR][matchC] = true;

        while(!deq.isEmpty()) {
            int[] current = deq.removeFirst();
            int row = current[0], col = current[1], time = current[2];

            // latest time
            max = Math.max(max, time);

            // breadth-first search
            for (int[] move : moves) {
                int newRow = row + move[0];
                int newCol = col + move[1];
                // make sure new position is in bounds
                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                    continue;
                }
                // check if already visited, if not, add to deque
                if (!visited[newRow][newCol] && forest[newRow][newCol] == 't') {
                    visited[newRow][newCol] = true;
                    deq.addLast(new int[]{newRow, newCol, time + 1});
                }
            }
        }

        return max;
    }
}