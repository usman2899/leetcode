class Solution {
    public int orangesRotting(int[][] grid) {

        // int mins = -1;
        // ArrayList<Integer> row = new ArrayList<>();
        // ArrayList<Integer> col = new ArrayList<>();
        // do {
        // row.clear();
        // col.clear();
        // boolean rot;

        // for(int i=0; i<grid.length; i++) {
        //     for(int j=0; j<grid[i].length; j++) {
        //         if (grid[i][j] == 1) {
        //             rot = false;
        //             if ((i - 1) >= 0 && grid[i-1][j] == 2) {
        //                 rot = true;
        //             }
        //             else if ((j - 1) >= 0 && grid[i][j-1] == 2) {
        //                 rot = true;
        //             }
        //             else if ((i + 1) < grid.length && grid[i+1][j] == 2) {
        //                 rot = true;
        //             }
        //             else if ((j + 1) < grid[i].length && grid[i][j+1] == 2) {
        //                 rot = true;
        //             }
        //             else {}
        //             if (rot) {
        //                 row.add(i);
        //                 col.add(j);
        //             }
        //         }
        //     }
        // }

        // for (int i = 0; i < row.size(); i++){
        //     grid[row.get(i)][col.get(i)] = 2;
        // }
        // mins++;
        // } while (row.size() > 0 );
        // for(int i=0; i<grid.length; i++) {
        //     for(int j=0; j<grid[i].length; j++) {
        //         if (grid[i][j] == 1){
        //             return -1;
        //         }
        //     }
        // }
        // return mins;


        int mins = -1;
        boolean change;
        do {
        boolean rot;
        change = false;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    rot = false;
                    if ((i - 1) >= 0 && grid[i-1][j] == 2) {
                        rot = true;
                    }
                    else if ((j - 1) >= 0 && grid[i][j-1] == 2) {
                        rot = true;
                    }
                    else if ((i + 1) < grid.length && grid[i+1][j] == 2) {
                        rot = true;
                    }
                    else if ((j + 1) < grid[i].length && grid[i][j+1] == 2) {
                        rot = true;
                    }
                    else {}
                    if (rot) {
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