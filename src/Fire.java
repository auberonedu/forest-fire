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

    private static int[][] moves =  {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int timeToBurn(char[][] forest, int matchR, int matchC) {
        // HINT: when adding to your BFS queue, you can include more information than
        // just a location. What other information might be useful?
        // create a queue to track possible moves
        // write a for-each loop to iterate through each possible move
        // add tree location and extra information (time it took to reach)
        // write variables to track the current location of columns and rows
        // potentially an integer array to track current coordinates

        int max = 0; //return (the time it takes for all trees to burn).

        if(forest[matchR][matchC] != 't') {
            return 0;
        }

        Deque<int[]> deq = new ArrayDeque<int[]>();

        char[][] seen = new char[forest.length][forest[0].length]; //I don't like the [0].length
        deq.addLast(new int[]{matchR, matchC, 0});
        while(deq.size() > 0) {
            int[] current = deq.removeFirst();
            if(max < current[2]) {
                max = current[2];
            }
            if(seen[current[0]][current[1]] != 's') {
                for(int[] move : moves) {
                    int[] currentModified = new int[]{current[0]+move[0], current[1]+move[1], current[2]++};
                    if(forest[currentModified[0]][currentModified[1]] != 't') {
                        deq.addLast(currentModified);
                    }
                }
                seen[current[0]][current[1]] = 's';
            }
        }

        return max;
    }
}