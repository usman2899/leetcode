class Solution {
    public double myPow(double x, int n) {
        long exp = n;
        if (exp == 0) return 1;
        if (exp < 0) {
            exp = -exp;
            x = 1/x;
        }
        
        double res = myPow(x, (int) (exp/2));
        if (exp%2 == 0) return res * res;
        else return res*res*x;
    }
}