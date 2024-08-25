class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int midIdx = 0;
        int mid = 0;
        
        while (start <= end) {
            midIdx = (start + end) / 2;
            mid = nums[midIdx];
            
            if (target == mid) {
                break;
            } else if (target < mid) {
                end = midIdx - 1;
            } else {
                start = midIdx + 1;
            }
        }
        if (target > mid){
            return midIdx + 1;
        } else {
            return midIdx;
        }
    }
}