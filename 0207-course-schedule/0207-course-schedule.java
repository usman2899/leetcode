class Solution {
    boolean[] visited;
    boolean[] recursionStack;
    List<List<Integer>> adjList;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prereq: prerequisites) {
            adjList.get(prereq[0]).add(prereq[1]);
        }

        visited = new boolean[numCourses];
        recursionStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(i)) {
                return false;
            }
        }
        return true;
    }

    boolean hasCycle(int course) {
        visited[course] = true;
        recursionStack[course] = true;

        for (int prereq: adjList.get(course)) {
            if (!visited[prereq] && hasCycle(prereq)) {
                return true;
            }
            if (recursionStack[prereq] == true) {
                return true;
            }
        }
        recursionStack[course] = false;
        return false;
    }
}

// //Iterative DFS
// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         List<List<Integer>> graph = new ArrayList<>();
        
//         for (int i = 0; i < numCourses; i++) {
//             graph.add(new ArrayList<>());
//         }

//         for (int[] pair : prerequisites) {
//             graph.get(pair[0]).add(pair[1]);
//         }

//         boolean[] visited = new boolean[numCourses];
//         boolean[] inPath = new boolean[numCourses];

//         for (int i = 0; i < numCourses; i++) {
//             if (!visited[i] && hasCycleIterative(i, graph, visited, inPath)) {
//                 return false;
//             }
//         }

//         return true;
//     }

//     private boolean hasCycleIterative(int start, List<List<Integer>> graph, boolean[] visited, boolean[] inPath) {
//         Stack<Integer> stack = new Stack<>();
//         Set<Integer> tempPath = new HashSet<>();

//         stack.push(start);

//         while (!stack.isEmpty()) {
//             int node = stack.peek();

//             if (!visited[node]) {
//                 visited[node] = true;
//                 inPath[node] = true;
//                 tempPath.add(node);
//             }

//             boolean allNeighborsVisited = true;
//             for (int neighbor : graph.get(node)) {
//                 if (inPath[neighbor]) {
//                     // cycle detected
//                     return true;
//                 }
//                 if (!visited[neighbor]) {
//                     stack.push(neighbor);
//                     allNeighborsVisited = false;
//                     break;
//                 }
//             }

//             if (allNeighborsVisited) {
//                 int finished = stack.pop();
//                 inPath[finished] = false;
//             }
//         }

//         return false;
//     }
// }
