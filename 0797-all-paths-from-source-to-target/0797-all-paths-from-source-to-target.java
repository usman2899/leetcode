class Solution {
    boolean[] visited;
    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        visited = new boolean[graph.length];
        res = new ArrayList<>();
        recursion(graph, 0, new ArrayList<>());
        return res;
    }

    void recursion (int[][] graph, int curr, List<Integer> tempList) {
        if (curr == graph.length-1) {
            List<Integer> ans = new ArrayList<>();
            ans.addAll(tempList);
            ans.add(curr);
            res.add(ans);
            return;
        }
        for (int i = 0; i < graph[curr].length; i++) {
            if (visited[curr]) continue;
            visited[curr] = true;
            tempList.add(curr);
            recursion(graph, graph[curr][i], tempList);
            visited[curr] = false;
            tempList.remove(tempList.size()-1);
            // if (tempList.size() == 0) break;
        }
        return;
    }
}