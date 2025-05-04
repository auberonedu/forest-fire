import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    public static int timeToBurn(char[][] forest, int matchR, int matchC) {
        // HINT: when adding to your BFS queue, you can include more information than
        // just a location. What other information might be useful?
         if (forest[matchR][matchC] != 't') {
            return 0;
        }

        
        int[] start = new int[]{matchR, matchC, 0};
        boolean[][] burnt = new boolean[forest.length][forest[0].length];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start); 

        int maxTime = 0;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            
            int row = current[0];
            int col = current[1];
            int time = current[2];  

            // if the current tree is down continue
            if (burnt[row][col]){
                continue;
            } 

            burnt[row][col] = true; 

            List<int[]> moves = possibleMoves(forest, row, col); 

            // add reachable tree to the queue
            for (var move : moves){
                int[] toAdd = new int[]{move[0],move[1], time + 1};
                queue.add(toAdd);
            } 
            
            if( time > maxTime){
                maxTime = time;
            }
        }
        return maxTime;
    }

    public static List<int[]> possibleMoves(char[][] forest, int row, int col) {
        List<int[]> moves = new ArrayList<>();
        int[][] directions = {
            {-1, 0}, // up
            { 1, 0}, // down
            { 0,-1}, // left
            { 0, 1}  // right
        };

        for (int[] d : directions) {
            int nr = row + d[0], nc = col + d[1];
            if (nr >= 0 && nr < forest.length &&
                nc >= 0 && nc < forest[0].length &&
                forest[nr][nc] == 't') {
                moves.add(new int[]{nr, nc});
            }
        }

        return moves;
    }
}