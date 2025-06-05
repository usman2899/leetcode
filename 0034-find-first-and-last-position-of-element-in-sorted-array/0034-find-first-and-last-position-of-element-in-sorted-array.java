class Solution {
    public int[] searchRange(int[] nums, int target) {
        int total = nums.length;
        int firstLow = 0;
        int firstHigh = total - 1;
        boolean found = false;
        int[] result = new int[]{-1,-1};
        int firstMid = 0;
        int ans = 0;

        while(firstLow <= firstHigh) {
            firstMid = firstLow + (firstHigh-firstLow)/2;
            if (nums[firstMid] == target) {
                found = true;
                break;
            }
            else if (nums[firstMid] > target) firstHigh = firstMid - 1;
            else firstLow = firstMid + 1;
        }
        if (!found) return result;

        int secondHigh = firstMid;
        int secondMid = 0;
        while (firstLow <= secondHigh) {
            secondMid = firstLow + (secondHigh - firstLow)/2;
            if (nums[secondMid] == target) {
                ans = secondMid;
                secondHigh = secondMid - 1;
            }
            else firstLow = secondMid + 1;
        }
        result[0] = ans;

        int secondLow = firstMid;
        while (secondLow <= firstHigh) {
            secondMid = secondLow + (firstHigh - secondLow)/2;
            if (nums[secondMid] == target) {
                ans = secondMid;
                secondLow = secondMid + 1;
            }
            else firstHigh = secondMid - 1;
        }
        result[1] = ans;
        return result;
    }
}