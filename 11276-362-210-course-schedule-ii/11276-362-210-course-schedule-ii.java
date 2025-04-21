class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair: prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            graph.get(course).add(prereq);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recursionStack = new boolean[numCourses];
        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(i, graph, visited, recursionStack, resultList)) {
                return new int[]{};
            }
        }
        int[] resultArray = resultList.stream().mapToInt(Integer::intValue).toArray();
        return resultArray;
    }

    boolean hasCycle(int course, List<List<Integer>> graph, boolean[] visited, boolean[] recursionStack, List<Integer> result) {
        visited[course] = true;
        recursionStack[course] = true;

        for (Integer neighbor: graph.get(course)) {
            if (!visited[neighbor] && hasCycle(neighbor, graph, visited, recursionStack, result)) {
                return true;
            }
            if (recursionStack[neighbor]) {
                return true;
            }
        }
        result.add(course);
        recursionStack[course] = false;
        return false;
    }
}