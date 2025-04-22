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
        int[] start = {matchR, matchC, 0};
        Queue<int[]> lit = new LinkedList<>();
        lit.add(start);

        boolean[][] visited = new boolean[forest.length][forest[0].length];
        int maxTime = 0;

        while (!lit.isEmpty()){
            int[] current = lit.poll();
            int currentTime = current[2];
            
            if (currentTime > maxTime){
                maxTime = currentTime;
            }

            List<int[]> nextMoves = traverseFire(forest, current, currentTime);

            for (int[] move : nextMoves) {
                int newR = move[0];
                int newC = move[1];

                if (!visited[newR][newC]) {
                    visited[newR][newC] = true;  
                    lit.add(new int[]{newR, newC, currentTime + 1});  
                }
            }

        }
       
        return maxTime;
    }

    public static List<int[]> traverseFire(char[][] forest, int[] current, int time){
        List<int[]> moves = new ArrayList<>();
        int[][] steps = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        int curR = current[0];
        int curC = current[1];
      
        for (int[] step : steps) {
            int newR = curR + step[0];
            int newC = curC + step[1];

            if (newR >= 0 && newR < forest.length && 
                newC >= 0 && newC < forest[0].length && 
                forest[newR][newC] == 't') {
                    moves.add(new int[]{newR, newC, time});
                }
        }
        
        return moves;
    }
}