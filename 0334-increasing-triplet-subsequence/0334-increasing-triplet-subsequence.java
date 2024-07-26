class Solution {
    public boolean increasingTriplet(int[] nums) {

        boolean res = false;
        int len = nums.length;
        int small1 = Integer.MAX_VALUE;
        int small2 = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            int val = nums[i]; 
            if (val <= small1) {
                small1 = val;
            } else if (val <= small2) {
                small2 = val;
            } else {
                res = true;
                break;
            }
        }
        return res;        
    }
}