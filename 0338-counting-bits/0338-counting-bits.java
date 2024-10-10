class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            int highest = 0;
            while (Math.pow(2, highest) < i) {
                highest++;
            }
            int num = i;
            int ones = 0;
            while (num > 0) {
                if (Math.pow(2,highest) <= num) {
                    num -= Math.pow(2,highest);
                    ones++;
                }
                highest--;
            }
            res[i] = ones;
        }
        return res;
    }
}