class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // int len = nums.length;
        // double result = -Double.MAX_VALUE;

        // for (int i = 0; i <= len-k; i++) {
        //     double curr = 0;

        //     int newNum = nums[i + k - 1];
        //     if (i - 1 >= 0 && newNum > nums[i - 1]); {
        //         for (int j = i; j < i+k; j++) {
        //             curr += nums[j];
        //         }
        //         curr = curr/k;
        //         if (curr > result) {
        //             result = curr;
        //         }
        //     }
        // }
        // return result;

        double result = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            result += nums[i];
        }
        int len = nums.length;
        sum = (int)result;
        for (int i = 1; i <= len-k; i++) {
            sum = sum - nums[i-1] + nums[i+k-1];
            if (sum > result) {
                result = sum;
            }
        }
        return result/k;
    }
}