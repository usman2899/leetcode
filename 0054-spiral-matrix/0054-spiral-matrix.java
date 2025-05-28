class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int minLoop = Math.min(rows, cols);

        for (int i = 0; i < (minLoop+1)/2; i++) {
            result.addAll(currSpiral(i, rows - i, cols - i, matrix));
        }
        return result;
    }

    List<Integer> currSpiral (int start, int rowsEnd, int colsEnd, int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        for (int i = start; i < colsEnd; i++) {
            res.add(matrix[start][i]);
        }
        for (int i = start+1; i < rowsEnd; i++) {
            res.add(matrix[i][colsEnd-1]);
        } 
        if (start != rowsEnd-1) {
            for (int i = colsEnd - 2; i >= start; i--) {
                res.add(matrix[rowsEnd-1][i]);
            } 
        }
        if (start != colsEnd-1) {
            for (int i = rowsEnd - 2; i >= start+1; i--) {
                res.add(matrix[i][start]);
            }
        }
        return res;
    }
}