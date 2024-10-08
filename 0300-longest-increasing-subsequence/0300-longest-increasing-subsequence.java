class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] res = new int [len];
        int size = 0;
        
        for (int num : nums) {
            int i = 0;
            int j = size;
            
            while (i < j) {
                int m = (i + j) / 2;
                
                if (res[m] < num) {
                    i = m + 1;
                }
                else {
                    j = m;
                }
            }
            res[i] = num;
            if (i == size) {
                size++;
            }
        }
        return size;
    }
}