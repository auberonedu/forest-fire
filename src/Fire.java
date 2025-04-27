
import java.util.LinkedList;
import java.util.Queue;

public class Fire {
    /**
     * Returns how long it takes for all vulnerable trees to be set on fire if a
     * match is lit at a given location.
     * 
     * The forest is represented via a rectangular 2d char array where t represents a tree
     * and . represents an empty space.
     * 
     * At time 0, the tree at location [matchR, matchC] is set on fire. At every subsequent
     * time step, any tree that is adjacent (up/down/left/right) to a burning tree is also
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
     * At time 0, the tree at (2, 6) is set on fire. At time 1, its adjacent trees also catch on fire
     * At time 2, the trees adjacent to those catch as well. At time 8, the last tree to catch is at
     * (0,6). In this example, there is one tree that never burns, so it is not included in the time calculation.
     * 
     * 
     * @param forest a 2d array where t represents a tree and . represents the ground
     * @param matchR The row the match is lit at
     * @param matchC The column the match is lit at
     * @return the time at which the final tree to be incinerated starts burning
     */
    private static final int[][] directions = {
        {-1, 0},
        { 1, 0},
        { 0,-1},
        { 0, 1}
    };
    
     public static int timeToBurn(char[][] forest, int matchR, int matchC) {
        // HINT: when adding to your BFS queue, you can include more information than
        // just a location. What other information might be useful?
        int rows = forest.length;
        int cols = forest[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        
        queue.add(new int[]{matchR, matchC});
        visited[matchR][matchC] = true; // Marking the first cell visited

        finalTime = 0;

        while(!queue.isEmpty()) {
            int[] current = 
        }
        
        
        return finalTime;
    }

    public static int[] possibleMoves(char[][] forest, char[] current) {
        
        
        return null;
    }

    public static int location(char[][] forest, int r, int c) {
        for(int r = 0; r < forest.length; r++) {
            for(int c = 0; c < forest[0].length; c++) {
                new int[]{r, c};
            }
        }
        
        
        return 0;
    }
}