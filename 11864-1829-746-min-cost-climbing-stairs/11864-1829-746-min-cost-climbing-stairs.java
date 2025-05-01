class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int total = cost.length;
        int first = cost[0];
        int second = cost[1];

        for (int i = 2; i < total; i++) {
            int temp = cost[i] + Math.min(second, first);
            first = second;
            second = temp;
        }
        return Math.min(second, first);
    }
}