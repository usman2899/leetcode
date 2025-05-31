class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int result = Integer.MAX_VALUE;
        int end = 0;
        int sum = 0;

        while (end < nums.length) {
            sum += nums[end];

            if (sum >= target) {
                while (sum-nums[start] >= target && end > start) {
                    sum -= nums[start];
                    start++;
                }
                result = Math.min(result, end - start + 1);            
            }
            end++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}