class Node {
    String neighbor;
    double value;

    public Node(String n, double val) {
        this.neighbor = n;
        this.value = val;
    }
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, List<Node>> adjList = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double value = values[i];

            List<Node> list = adjList.getOrDefault(dividend, new ArrayList<>());
            Node node = new Node(divisor, value);
            list.add(node);
            adjList.put(dividend, list);

            list = adjList.getOrDefault(divisor, new ArrayList<>());
            node = new Node(dividend, 1/value);
            list.add(node);
            adjList.put(divisor, list);
        }

        int totalQueries =  queries.size();
        double[] result = new double[totalQueries];

        for (int i = 0; i < totalQueries; i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (adjList.containsKey(start) && adjList.containsKey(end)) {
                result[i] = dfs(start, end, new HashSet<>(), 1, adjList);
            } else result[i] = -1;
        }
        return result;   
    }

    double dfs (String start, String end, Set<String> visited, double result, Map<String, List<Node>> adjList) {
        if (visited.contains(start)) return -1;
        if (start.equals(end)) return result;
        visited.add(start);
        for (Node node: adjList.get(start)) {
            double val = dfs(node.neighbor, end, visited, result*node.value, adjList);
            if (val != -1) {
                return val;
            }
        }
        return -1;
    }
}