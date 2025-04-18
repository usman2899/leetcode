class Solution {
    public int maxOperations(int[] nums, int k) {
        int result = 0;
        int len = nums.length;
        int low = 0;
        int high = len - 1;

        //Sorting, can do hashmap method for faster
        Arrays.sort(nums);
        
        while (low < high) {
            int lowNum = nums[low];
            int highNum = nums[high];
            int sum = lowNum + highNum;
            
            if (sum == k) {
                low++;
                high--;
                result++;
            } else if (sum < k) {
                low++;
            } else {
                high--;
            }
        }
        return result;
    }
}