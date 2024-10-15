class Solution {
    public int numTilings(int n) {
        double[] res = new double[n+2];
        res[0] = 1;
        res[1] = 2;
        res[2] = 5;
        for (int i = 3; i < n; i++) {
            res[i] = ((res[i-1]*2) + res[i-3]) % (Math.pow(10,9) + 7);
        }
        return (int) res[n-1];
    }
}