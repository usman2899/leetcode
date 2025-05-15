class Solution {
    private int mod = (int) Math.pow(10, 9) + 7;
    int faces;
    int result;
    public int numRollsToTarget(int n, int k, int target) {
        result = 0;
        faces = k;
        int[][] mem = new int[n+1][target+1];
        for (int[] dice: mem) {
            Arrays.fill(dice, -1);
        }
        return recursion(n, target, mem);

    }

    int recursion(int n, int target, int[][] mem) {
        if (n == 0 && target == 0) {
            return 1;
        }
        if (n == 0 || target < 0) {
            return 0;
        }
        if (mem[n][target] != -1) {
            return mem[n][target];
        }
        int count = 0;
        for (int i = 1; i <= faces; i++) {
            count = (count + recursion (n-1, target - i, mem)) % mod;
        }
        mem[n][target] = count;
        return mem[n][target];
    }
}
