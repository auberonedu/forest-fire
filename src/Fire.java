import java.util.*;

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
    public static int timeToBurn(char[][] forest, int matchR, int matchC) {
        // HINT: when adding to your BFS queue, you can include more information than
        // just a location. What other information might be useful?

        // base cases
        if (forest == null)
            throw new NullPointerException("Forest 2D matrix cannot be null!");
        if (forest[matchR][matchC] != 't')
            return 0;

        // initializing directions variable for more elegant code
        int[][] directions = {
                // up, down, right, left
                { -1, 0 },
                { 1, 0 },
                { 0, 1 },
                { 0, -1 }
        };
        // for readability
        int ROW = forest.length;
        int COL = forest[0].length;
        // initialize visited to avoid looping and Queue structure
        boolean[][] visited = new boolean[ROW][COL];
        Queue<int[]> burningTree = new LinkedList<>();

        // start position of the fire
        // .offer() adds to the queue like .add() but won’t crash if the queue is full
        burningTree.offer(new int[] { matchR, matchC, 0 });
        visited[matchR][matchC] = true;
        // initialize counter
        int maxStepCount = 0;

        // perform BFS to spread fire to all reachable trees
        while (!burningTree.isEmpty()) {
            int[] current = burningTree.poll();
            int curR = current[0];
            int curC = current[1];
            int time = current[2];

            // Math.max compare (maxStepCount to current time)
            maxStepCount = Math.max(maxStepCount, time);

            // iterate all cardinal directions
            for (int[] direction : directions) {
                int newR = curR + direction[0];
                int newC = curC + direction[1];

                // edge cases: check the bounds, visited, treeless cells
                if (newR < 0 || newC < 0 || newR >= forest.length ||
                        newC >= forest[0].length || visited[newR][newC] ||
                        forest[newR][newC] == '.')
                    continue;

                // edge cases passed -> mark visited, add to queue, increment time
                visited[newR][newC] = true;
                burningTree.offer(new int[] { newR, newC, time + 1 });
            }
        }
        return maxStepCount;
    }
}