class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[][] matrix = new int[l1][l2];

        if (text1.charAt(0) == text2.charAt(0)) matrix[0][0] = 1;
        else matrix[0][0] = 0;

        for (int i = 1; i < l1; i++) {
            matrix[i][0] = text1.charAt(i) == text2.charAt(0) ? 1 : matrix[i-1][0];
        }
        for (int i = 1; i < l2; i++) {
            matrix[0][i] = text2.charAt(i) == text1.charAt(0) ? 1 : matrix[0][i-1];
        }

        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < l2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }
        return matrix[l1-1][l2-1];
    }
}