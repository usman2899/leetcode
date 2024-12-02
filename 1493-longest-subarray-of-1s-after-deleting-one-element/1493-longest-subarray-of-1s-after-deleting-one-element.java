class Solution {
    public int longestSubarray(int[] nums) {
        int sP = 0; 
        int zP = -1; 
        int result = 0;
        int len = nums.length; 

        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                if (zP != -1) {
                    sP = zP + 1;
                }
                zP = i;
            }
            result = Math.max(result, i - sP);
        }

        return result == len ? result - 1 : result;
    }
}