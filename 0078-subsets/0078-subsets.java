class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int max = (int) Math.pow(2, nums.length) - 1;
        for (int i = max; i >= 0; i--) {
            List<Integer> arr = new ArrayList<Integer>();
            int temp = i;
            for (int j = nums.length-1; j >= 0; j--) {
                if (temp - Math.pow(2,j) >= 0 ) {
                    temp = temp - (int) Math.pow(2,j);
                    arr.add(nums[j]);
                    if (temp == 0) break;
                    }
            }
            result.add(arr);
        }
        return result;
    }
}