class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        int changes = 0;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            graph.get(from).add(new int[]{to, 1});   
            graph.get(to).add(new int[]{from, -1}); 
        }
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0); 

        while (!stack.isEmpty()) {
            int current = stack.pop();
            visited[current] = true;

            for (int[] neighbor : graph.get(current)) {
                int next = neighbor[0];

                if (!visited[next]) {
                    int direction = neighbor[1];
                    if (direction == 1) {
                        changes++;
                    }
                    stack.push(next); 
                }
            }
        }
        return changes;
    }
}

// class Solution {
//     public int minReorder(int n, int[][] connections) {       
//         int[][] matrix = new int[n][n];
//         int changes = 0;
        
//         for (int i = 0; i < n - 1; i++) {
//             matrix[connections[i][0]][connections[i][1]] = 1;
//             matrix[connections[i][1]][connections[i][0]] = -1;
//         }
        
//         for (int i = 0; i < n; i++) {
//             if (matrix[0][i] != 0) {
//                 Stack<Integer> stack = new Stack<>();
//                 stack.push(i);
//                 if (matrix[0][i] == 1) {
//                     changes++;
//                 }
//                 matrix[0][i] = 2;
//                 matrix[i][0] = 2;
//                 while (!stack.isEmpty()) {
//                     int current = stack.pop();
//                     for (int j = 0; j < n; j++) {
//                         if (Math.abs(matrix[current][j]) == 1) {
//                             if (matrix[current][j] == 1) {
//                                 changes++;
//                             }
//                             matrix[current][j] = 2;
//                             matrix[j][current] = 2;
//                             stack.push(j);
//                         }
//                     } 
//                 }
//             }
//         }
//         return changes;
//     }
// }