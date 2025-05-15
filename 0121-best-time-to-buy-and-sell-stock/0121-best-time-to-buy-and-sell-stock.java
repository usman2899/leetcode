class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int min = prices[0];
        int res = 0;

        for (int i = 1; i < len; i++) {
            int diff = prices[i] - min;
            res = Math.max(res, diff);
            if (prices[i] < min) {
                min = prices[i];
            } 
        }
        return res;
    }
}