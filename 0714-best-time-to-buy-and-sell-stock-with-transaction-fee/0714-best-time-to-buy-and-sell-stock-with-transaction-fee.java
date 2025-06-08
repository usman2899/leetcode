class Solution {
    public int maxProfit(int[] prices, int fee) {
        int totalProfit = 0;
        int cost = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int currProfit = prices[i] - cost - fee;
            if (currProfit > 0) {
                totalProfit += currProfit;
                cost = prices[i] - fee;
            }
            cost = Math.min(cost, prices[i]);
        
        }
        return totalProfit;       
    }
}

// class Solution {
//    public int maxProfit(int[] prices) {
//        int cost = prices[0];
//        int totalProfit = 0;
//        for (int i = 1; i < prices.length; i++) {
//            int currProfit = prices[i] - cost;
//            if (currProfit > 0) {
//                totalProfit += currProfit;
//                cost = prices[i];
//            }
//            cost = Math.min(cost, prices[i]);           
//        }
//        return totalProfit;
//    }
// }
