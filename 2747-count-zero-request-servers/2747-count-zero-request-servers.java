class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        List<Set<Integer>> rangeList = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            rangeList.add(new HashSet<>());
        }

        for (int[] log: logs) {
            int server = log[0];
            int ts = log[1];

            for (int i = 0; i < queries.length; i++) {
                if (ts >= queries[i] - x && ts <= queries[i]) {
                    Set<Integer> set = rangeList.get(i);
                    set.add(server);
                    rangeList.set(i, set);
                } 
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < rangeList.size(); i++) {
            res[i] = n - rangeList.get(i).size();
        }
        return res;
    }
}