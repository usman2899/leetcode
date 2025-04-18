class Solution {
    public int longestSubarray(int[] nums) {
        int sP = 0;
        int zP = -1;
        int len = nums.length;
        int result = 0;

        for (int i = 0; i < len; i++) {
            //Update pointers when there is zero
            if (nums[i] == 0) {

                //For every zero after first one - update starting pointer
                if (zP != -1) {
                    sP = zP + 1;
                }

                //Keep track of zero pointer
                zP = i;
            }

            result = Math.max(result, i - sP);
        }
        return result == len ? result - 1 : result;
    }
}