class Solution {

    public int findCircleNum(int[][] isConnected) {
        int totalCities = isConnected.length;
        int provinces = 0;
        boolean[] visited = new boolean[totalCities];

        for (int i = 0; i < totalCities; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(i, totalCities, visited, isConnected);
            }
        }
        return provinces;
    }

    void dfs (int city, int totalCities, boolean[] visited, int[][] isConnected) {
        for (int j = 0; j < totalCities; j++) {
            if (!visited[j] && isConnected[city][j] == 1) {
                visited[j] = true;
                dfs(j, totalCities, visited, isConnected);
            } 
        }
    }
}