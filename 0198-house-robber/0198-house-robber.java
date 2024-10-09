class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (len == 3) {
            return Math.max(nums[1], (nums[0]+nums[2]));
        }
        res[0] = nums[0];
        res[1] = nums[1];
        res[2] = nums[0] + nums[2];
        
        for (int i = 3; i < len; i++) {
            res[i] = nums[i] + Math.max(res[i-2], res[i-3]);
        }
        return Math.max(res[len-1], res[len-2]);
    }
}