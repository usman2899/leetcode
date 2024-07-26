class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        //find cols
        int numCols = 1;
        int i = numRows;
        while (i < s.length()) {
           if (i+1 % numRows == 0) {
                i = i + numRows;
            }
            else {
                i++;
            }
            numCols++;
        };

        //fill 2d array
        Character[][] pattern = new Character[numRows][numCols]; 
        int p = 0;
        for (int col = 0; col < numCols && p < s.length(); col++){
            if (col == 0 || (col%(numRows-1) == 0)) {
                for (int row = 0; row < numRows && p < s.length(); row++) {
                    pattern[row][col] = s.charAt(p);
                    p++;
                }
            }
            else {
                int row = (numRows-1) - (col% (numRows-1));
                pattern[row][col] = s.charAt(p);
                p++;
            }
        }

        String result = "";
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (pattern[row][col] != null) {
                    result = result + pattern[row][col];
                }
            }
        }
        return result;
    }
}