class Solution {
    long mod_val = 1000000007;
    public int countGoodNumbers(long n) {
        long evenRes = power(5, (n+1)/2);
        long oddRes = power(4, (n)/2);
        return (int) ((evenRes * oddRes) % mod_val);
    }

    long power(long n, long exp) {
        if (exp == 0) return 1;

        long temp = power(n, exp/2);

        if (exp % 2 == 0) return (temp*temp) % mod_val;
        else return (n*temp*temp) % mod_val;
    }
}