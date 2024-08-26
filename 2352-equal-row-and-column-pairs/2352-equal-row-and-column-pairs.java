class Solution {
    public int equalPairs(int[][] grid) {

        Map<String, Integer> rows = new HashMap<>();
        Map<String, Integer> cols = new HashMap<>();
        int len = grid.length;
        int res = 0;

        for (int i = 0; i < len; i++) {
            String row = "";
            String col = "";
            for (int j = 0; j < len; j++) {
                row += grid[i][j];
                row += "+";
                col += grid[j][i];
                col += "+";
            }
            rows.put(row, rows.getOrDefault(row, 0) + 1);
            cols.put(col, cols.getOrDefault(col, 0) + 1);
        }

        for(String i : rows.keySet()) {
            if (cols.containsKey(i)) {
                res = res + (rows.get(i) * cols.get(i));
            }
        }
        return res;


        // int res = 0;
        // int len = grid.length;
        // Map<Integer, List<Integer>> rows = new HashMap<>();
        // Map<Integer, List<Integer>> cols = new HashMap<>();

        // for (int i = 0; i < len; i++) {
        //     List<Integer> row = new ArrayList<>();
        //     for (int j = 0; j < len; j++) {
        //         row.add(grid[i][j]);
        //     }
        //     rows.put(i, row);
        // }
        // for (int i = 0; i < len; i++) {
        //     List<Integer> col = new ArrayList<>();
        //     for (int j = 0; j < len; j++) {
        //         col.add(grid[j][i]);
        //     }
        //     cols.put(i, col);
        // }

        // for(Integer i : rows.keySet()) {
        //     List<Integer> row = rows.get(i);
        //     for(Integer j : cols.keySet()) {
        //         List<Integer> col = cols.get(j);
        //         boolean flag = true;
        //         for (int k = 0; k < len; k++) {
        //             if (!row.get(k).equals(col.get(k))) {
        //                 flag = false;
        //                 break;
        //             }
        //         }   
        //         if (flag) {
        //             res++;
        //         }         
        //     }
        // }
        // return res;
    }
}