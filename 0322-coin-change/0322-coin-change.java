import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> memo = new HashMap<>();
        int result = dfs(coins, amount, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    int dfs(int[] coins, int rem, Map<Integer, Integer> memo) {
        if (rem == 0) return 0;
        if (rem < 0) return Integer.MAX_VALUE;
        if (memo.containsKey(rem)) return memo.get(rem);

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dfs(coins, rem - coin, memo);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res + 1);
            }
        }

        memo.put(rem, min);
        return min;
    }
}
