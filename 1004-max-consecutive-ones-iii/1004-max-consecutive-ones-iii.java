class Solution {
    public int longestOnes(int[] nums, int k) {

       if (nums == null) {
            throw new IllegalArgumentException("Input array is null");
        }

        int start = 0;
        int end = 0;
        int zeros = 0;

        while (end < nums.length) {
            if (nums[end] == 0) {
                zeros++;
            }
            end++;
            if (zeros > k) {
                if (nums[start] == 0) {
                    zeros--;
                }
                start++;
            }
        }

        return end - start; 
        
        // int len = nums.length;
        // int result = 0;
        // for (int i = 0; i < len; i++) {
        //     int currTotal = 0;
        //     int remZeros = k;
        //     for (int j = i; j < len; j++) {
        //         int val = nums[j];
        //         if (val == 0) {
        //             remZeros--;
        //         }
        //         if (remZeros == -1) {
        //             break;
        //         }
        //         currTotal++;
        //     }
        //     if (currTotal > result) {
        //         result = currTotal;
        //     }
        // }
        // return result;
    }
}