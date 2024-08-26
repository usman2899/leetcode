class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int j = 0;

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num != 0) {
                nums[j] = num;
                j++;
            }
        }

        while (j < len) {
            nums[j] = 0;
            j++;
        }
    }
}