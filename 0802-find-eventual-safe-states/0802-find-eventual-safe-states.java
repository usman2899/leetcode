class Solution {
    boolean[] visited;
    boolean[] recursionStack;
    List<Integer> result;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int nodes = graph.length;
        visited = new boolean[nodes];
        recursionStack = new boolean[nodes];
        result = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                isSafe(i, graph);
            }
        }
        Collections.sort(result);
        return result;
    }

    boolean isSafe(int node, int[][] graph) {
        visited[node] = true;
        recursionStack[node] = true;
        
        for (int neighbor: graph[node]) {
            if (!visited[neighbor] && !isSafe(neighbor, graph)) {
                return false;
            }
            if (recursionStack[neighbor] == true) {
                return false;
            }
        }
        result.add(node);
        recursionStack[node] = false;
        return true;
    }
}