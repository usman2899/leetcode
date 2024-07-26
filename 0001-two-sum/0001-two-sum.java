class Solution {
    public int[] twoSum(int[] nums, int target) {
        // // Arrays.sort(nums);
        // int i = 0;
        // int j = nums.length - 1;


        // while (0 < 1) {
        //     int sum = nums[i] + nums[j];
        //     if (sum == target) {
        //         break;
        //     } else if (sum > target) {
        //         j--;
        //     } else {
        //         i++;
        //     }
        // }
        // return new int[]{i, j};


        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i +1; j < nums.length; j++) {
        //         if (nums[i] + nums[j] == target) {
        //             return new int[]{i, j};
        //         }
        //     }
        // }
        // return new int[]{};

        Map<Integer, Integer> arrMap = new HashMap<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int diff = target - nums[i];
            if (arrMap.containsKey(diff)) {
                return new int[]{i, arrMap.get(diff)};
            } else {
                arrMap.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}