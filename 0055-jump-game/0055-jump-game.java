class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        if (nums[0] == 0) return false;
        for (int i = 1; i < nums.length - 1; i++) {
            nums[i] = Math.max(nums[i], nums[i-1] - 1);
            if (nums[i] == 0) return false;
        }
        return true;
    }
}