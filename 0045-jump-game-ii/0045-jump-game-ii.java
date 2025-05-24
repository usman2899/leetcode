class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
       int max = 0;
       int curr = nums[0];
       int maxIndex = 0;
       int res = 1;

       for (int i = 1; i < nums.length - 1; i++) {
            curr--;
            max--;
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
            if (curr == 0) {
                curr = max;
                res++;
            }
       } 
       return res;
    }
}