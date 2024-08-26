class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int emptyBottles = 0;
        int res = 0;
        while (numBottles > 0) {
            res += numBottles;
            emptyBottles += numBottles;
            numBottles = emptyBottles/numExchange;
            emptyBottles -= numBottles*numExchange;
        }
        return res;        
    }
}