class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] matrix = new int[rows][cols];
        matrix[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0 && obstacleGrid[i][j] == 0) {
                    matrix[i][j] = matrix[i][j-1];
                    continue;
                }
                if (j == 0 && obstacleGrid[i][j] == 0) {
                    matrix[i][j] = matrix[i-1][j];
                    continue;
                }
                if (obstacleGrid[i][j] == 0) {
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
                    continue;
                }
            }
        }
        return matrix[rows-1][cols-1];
    }
}