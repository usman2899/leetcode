class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        
        for (int i = 0; i < len; i++) {
            if (i < 2) {
                dp[i] = cost[i];
            } else {
                dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
            }
        }
        return Math.min(dp[len-1], dp[len-2]);
    }
}