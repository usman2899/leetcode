class Solution {
    public int orangesRotting(int[][] grid) {
        int mins = -1;
        boolean change;
        do {
            change = false;
            for(int i=0; i<grid.length; i++) {
                for(int j=0; j<grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        if ((i - 1 >= 0 && grid[i-1][j] == 2) ||
                            (j - 1 >= 0 && grid[i][j-1] == 2) ||
                            (i + 1 < grid.length && grid[i+1][j] == 2) ||
                            (j + 1 < grid[i].length && grid[i][j+1] == 2)) {
                            grid[i][j] = 3;
                        }
                    }
                }
            }
            for(int i=0; i<grid.length; i++) {
                for(int j=0; j<grid[i].length; j++) {
                    if (grid[i][j] == 3){
                        grid[i][j] = 2;
                        change = true;
                    }
                }
            }
            mins++;
        } while (change);

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return mins;
    }
}