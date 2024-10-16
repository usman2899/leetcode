class Solution {
    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int buy = -prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, buy + prices[i] - fee);
            buy = Math.max(buy, profit - prices[i]);
        }
        return profit;
        
    }
}