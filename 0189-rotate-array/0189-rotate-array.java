class Solution {
    public void rotate(int[] nums, int k) {
        //++ k
        int n = nums.length;
        int[] nNums = new int[n];
        for (int i = 0; i<n; i++) {
            // int pos = (i+k)%n;
            nNums[(i+k)%n] = nums[i];
        }
        System.arraycopy(nNums,0,nums,0,n);
    }
}