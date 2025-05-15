class Solution {
    int rows, cols;
    public int numIslands(char[][] grid) {
        int islands = 0;
        rows = grid.length;
        cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(i, j, grid);
                }
            }
        }
        return islands;
    }

    void dfs(int m, int n, char[][] grid) {
        if (grid[m][n] == '2') {
            return;
        } else {
            grid[m][n] = '2';
            if (m-1 >= 0 && grid[m-1][n] == '1') {
                dfs(m-1, n, grid);
            }
            if (m+1 < rows && grid[m+1][n] == '1') {
                dfs(m+1, n, grid);
            }
            if (n-1 >= 0 && grid[m][n-1] == '1') {
                dfs(m, n-1, grid);
            }
            if (n+1 < cols && grid[m][n+1] == '1') {
                dfs(m, n+1, grid);
            }
        }
    }
}