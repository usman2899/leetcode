class Solution {
    public int reverse(int x) {
        boolean neg = false;
        if (x<0) {
            neg = true;
            x = x*-1;
        }
        int length = String.valueOf(x).length();
        //length -1
        int dec = length-1;
        long res = 0;

        for (int i = 0; i < length; i++) {
            long curr = x%10;
            curr = curr * (long)Math.pow(10,dec);
            res = res + curr;
            dec--;
            x=x/10;
        }
        if (neg) {
            res = res*-1;
        }
        if (res < Math.pow(-2,31) || res > (Math.pow(2,31)-1)) {
            return 0;
        } else {
            return (int)res;
        }
    }
}