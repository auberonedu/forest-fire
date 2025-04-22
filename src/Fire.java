import java.util.ArrayList;
import java.util.*;

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

     // need possible moves
     // logic to make sure next possible move is a tree that is also not on fire
     // queue 
     // add possiblemoves
     // traverse
     // will need visited grid
     // need count for time

    public static int timeToBurn(char[][] forest, int matchR, int matchC) {
        // HINT: when adding to your BFS queue, you can include more information than
        // just a location. What other information might be useful?

        int timer = 0;

        // boolean[][] visited
        boolean[][] visited = new boolean[forest.length][forest[0].length];

        // queue linkedlist<int[]>
        Queue<int[]> treeFire = new LinkedList<>();
        // add current location to queue
        treeFire.add(new int[]{matchR, matchC, timer});

        // while queue is not empty, iterate
            // poll 
            // if location valid
                // add to visited
                // change char to f
                // add possible moves
                // timer++;

        while (!treeFire.isEmpty()) {
            int[] current = treeFire.poll();
            // separate rows and colums
            int curR = current[0];
            int curC = current[1];
            int curTimer = current[2];

            // if curR = -1, timer++
            if (!visited[curR][curC]) {
                visited[curR][curC] = true;
                forest[curR][curC] = 'b';
                List<int[]> moves = possibleMoves(forest, current, curTimer + 1);
                treeFire.addAll(moves);
                timer = Math.max(curTimer, timer);
            } else {
                continue;
            }
        }
        return timer;
    }

    private static List<int[]> possibleMoves(char[][] forest, int[] currentLocation, int timer) {
        int curR = currentLocation[0];
        int curC = currentLocation[1];

        List<int[]> moves = new ArrayList<>();

        int[][] directions = new int[][] {
            {-1, 0}, // up
            {1, 0}, // down
            {0, -1}, // left
            {0, 1} // right
        };

        for(int[] direction: directions) {
            int newR = curR + direction[0];
            int newC = curC + direction[1];

            if(newR >= 0 && newR < forest.length && newC >= 0 && newC < forest[0].length && forest[newR][newC] == 't') {
                moves.add(new int[]{newR, newC, timer});
            }
        }
        return moves;
    }
}