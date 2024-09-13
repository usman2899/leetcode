class Solution {
    
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;
        int steps = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        
        int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};

        while (!queue.isEmpty()) {            
            int len =  queue.size();
            steps++;
            
            for (int i = 0; i < len; i++) {
                int[] curr = queue.poll();

                for (int[] direction: directions){
                    int[] next = new int[2];
                    next[0] = curr[0] + direction[0];
                    next[1] = curr[1] + direction[1];
                    
                    if (next[0] < 0 || next[0] >= rows || next[1] < 0 || next[1] >= cols) {
                        continue;
                    }
                    if (maze[next[0]][next[1]] == '+') {
                        continue;
                    }
                    if (next[0] == 0 || next[0] == rows - 1 || next[1] == 0 || next[1] == cols - 1) {
                        return steps;
                    }
                    maze[next[0]][next[1]] = '+';
                    queue.offer(next);
                }
            }  
        }
        return -1; 
    }
    
//     RECURSION - Time exceeded 
//     public int nearestExit(char[][] maze, int[] entrance) {
//         int rows = maze.length;
//         int cols = maze[0].length;

//         int result = dfs(maze, entrance[0], entrance[1], rows, cols, 0);

//         return result == Integer.MAX_VALUE ? -1 : result;
//     }

//     private int dfs(char[][] maze, int row, int col, int rows, int cols, int steps) {
//         if (row < 0 || row >= rows || col < 0 || col >= cols || maze[row][col] == '+') {
//             return Integer.MAX_VALUE;
//         }

//         if (steps > 0 && (row == 0 || row == rows - 1 || col == 0 || col == cols - 1)) {
//             return steps;
//         }

//         maze[row][col] = '+';

//         int up = dfs(maze, row - 1, col, rows, cols, steps + 1);
//         int down = dfs(maze, row + 1, col, rows, cols, steps + 1);
//         int left = dfs(maze, row, col - 1, rows, cols, steps + 1);
//         int right = dfs(maze, row, col + 1, rows, cols, steps + 1);

//         maze[row][col] = '.';

//         return Math.min(Math.min(up, down), Math.min(left, right));
//     }
}