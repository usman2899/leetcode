class Solution {
    public int maxProfit(int[] prices) {
        int cost = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int currProfit = prices[i] - cost;
            if (currProfit > 0) {
                maxProfit += currProfit;
                cost = prices[i];
            }
            cost = Math.min(cost, prices[i]);            
        }
        return maxProfit;
    }
}