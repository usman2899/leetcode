class Solution {
    public int minDifference(int[] nums) {
        // int n = nums.length;
        // if (n <= 4) return 0;

        // Arrays.sort(nums);

        // int res = Integer.MAX_VALUE;
        // res = Math.min(res, nums[n-4]-nums[0]);
        // res = Math.min(res, nums[n-3]-nums[1]);
        // res = Math.min(res, nums[n-2]-nums[2]);
        // res = Math.min(res, nums[n-1]-nums[3]);
        // return res;

        int n = nums.length;
        if(n <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = nums[n - 1] - nums[0];
        for(int i = 0; i <= 3; i++) {
            ans = Math.min(ans, nums[n - (3 - i) - 1] - nums[i]);
        }
        return ans;
    }
}