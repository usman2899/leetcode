class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if (end == 0) {
            return end;
        }
        while (start <= end) {
            int midIdx = (start + end) /2;
            int mid = nums[midIdx];
            if (midIdx == 0 && mid > nums[midIdx + 1]) {
                return midIdx;
            }
            if (midIdx == end && mid > nums[midIdx - 1]) {
                return midIdx;
            }
            if (mid > nums[midIdx + 1] && mid > nums[midIdx - 1]) {
                return midIdx;
            }
            if (nums[midIdx + 1] > mid) {
                start = midIdx + 1;
            } else {
                end = midIdx - 1;
            }
        }
        return -1;
    }
}