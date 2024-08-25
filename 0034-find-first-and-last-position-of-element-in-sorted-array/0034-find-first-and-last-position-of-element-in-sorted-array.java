class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }
    
    int findFirst(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int midIdx = (start + end) / 2;
            if (nums[midIdx] >= target) {
                end = midIdx - 1;
            }
            else {
                start = midIdx + 1;
            }
            if (nums[midIdx] == target) {
                idx = midIdx;
            }
        }  
        return idx;            

    }
    
    int findLast(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int midIdx = (start + end) / 2;
            if (nums[midIdx] <= target) {
                start = midIdx + 1;
            }
            else {
                end = midIdx - 1;
            }
            if (nums[midIdx] == target) {
                idx = midIdx;
            }            
        }  
        return idx;
    }
    
}