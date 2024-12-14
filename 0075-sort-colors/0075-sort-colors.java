class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;
        int len = nums.length;
        
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zero++;
            } else if (nums[i] == 1) {
                one++;
            } else {
                two++;
            }
        }
        for (int i = 0; i < len; i++) {
            if (zero > 0) {
                nums[i] = 0;
                zero--;
            } else if (one > 0) {
                nums[i] = 1;
                one--;
            } else {
                nums[i] = 2;
            }
        }
    }
}